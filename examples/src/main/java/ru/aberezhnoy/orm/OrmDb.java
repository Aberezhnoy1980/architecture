package ru.aberezhnoy.orm;

import java.sql.*;

public class OrmDb {
    private final Connection connection;
    private final Statement statement;

    public OrmDb() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:orm.db");
        this.statement = connection.createStatement();
    }

    public Connection getConnection() {
        return connection;
    }

    public void createTable() throws SQLException {
        statement.executeUpdate("create table if not exists `users` (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "login TEXT," +
                "password TEXT" +
                ")");
    }

    public void createParameterTable(String title, String id, String login, String password) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement("create table if not exists ? (? INTEGER PRIMARY KEY AUTOINCREMENT, ? TEXT, ? TEXT)")) {
            ps.setString(1, title);
            ps.setString(2, id);
            ps.setString(3, login);
            ps.setString(4, password);
            ps.executeUpdate();
        }
    }

    public void insert(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into users (login, password) values (?, ?)");
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getPassword());
        ps.executeUpdate();
    }

    public void findById(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from users where id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next())
            System.out.printf("id: %d | login: %s | password: %s%n", rs.getLong(1), rs.getString(2), rs.getString(3));
    }

    public void findByLogin(String login) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from users where login = ?");
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.printf("id: %d | login: %s | password: %s%n", rs.getLong(1), rs.getString(2), rs.getString(3));
        }
    }

    public void show() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from users");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.printf("id: %d | login: %s | password: %s%n", rs.getLong(1), rs.getString(2), rs.getString(3));
        }
    }

    public void dropTable() throws SQLException {
        statement.execute("drop table if exists users ");
    }
}
