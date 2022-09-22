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

    private final PreparedStatement selectUser;

    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection connection) {
        this.connection = connection;
        try {
            this.selectUser = connection.prepareStatement("select id, username, password from users where id = ?");
        } catch (SQLException exp) {
            throw new IllegalStateException(exp);
        }
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

    }

    public void insert(User user) {

    }

    public void delete(User user) {

    }

}
