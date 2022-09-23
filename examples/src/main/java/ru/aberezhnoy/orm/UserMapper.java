package ru.aberezhnoy.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {

    private final Connection connection;

    private final PreparedStatement selectUser, updateUser, insertUser, deleteUser;

    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection connection) {
        this.connection = connection;
        try {
            this.selectUser = connection.prepareStatement("select id, login, password from users where id = ?");
//            this.requestUserId = connection.prepareStatement("select id from users where login = ? and password = ?");
            this.updateUser = connection.prepareStatement("update users set login = ?, password = ? where id = ?");
            this.insertUser = connection.prepareStatement("insert into users (login, password) values (?, ?)");
            this.deleteUser = connection.prepareStatement("delete from users where id = ?");
        } catch (SQLException exp) {
            throw new IllegalStateException(exp);
        }
    }

    public Map<Long, User> getIdentityMap() {
        return identityMap;
    }

    public Optional<User> findById(Long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            selectUser.setLong(1, id);
            ResultSet rs = selectUser.executeQuery();
            if (rs.next()) {
                user = User
                        .createUser()
                        .setId(rs.getLong(1))
                        .setLogin(rs.getString(2))
                        .setPassword(rs.getString(3))
                        .build();
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException exp) {
            throw new IllegalStateException(exp);
        }
        return Optional.empty();
    }

    public void update(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("No id in entity to update");
        }
        User tempUser = findById(user.getId()).orElseThrow(() -> new IllegalStateException("No entity with id"));
        tempUser.setLogin(user.getLogin());
        tempUser.setPassword(user.getPassword());
        identityMap.put(tempUser.getId(), tempUser);
        try {
            updateUser.setString(1, user.getLogin());
            updateUser.setString(2, user.getPassword());
            updateUser.setLong(3, user.getId());
            updateUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("New entity should not have id");
        }
        try {
            insertUser.setString(1, user.getLogin());
            insertUser.setString(2, user.getPassword());
            insertUser.executeUpdate();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        try {
            PreparedStatement requestUserId = connection.prepareStatement("select id from users where login = ? and password = ?");
            requestUserId.setString(1, user.getLogin());
            requestUserId.setString(2, user.getPassword());
            ResultSet rs = requestUserId.executeQuery();
            if (rs.next()) {
                user.setId(rs.getLong(1));
            }
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        identityMap.put(user.getId(), user);
    }

    public void delete(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("No id in entity to delete");
        }
        try {
            deleteUser.setLong(1, user.getId());
            deleteUser.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        identityMap.remove(user.getId());
    }
}
