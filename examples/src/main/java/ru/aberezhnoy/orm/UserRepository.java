package ru.aberezhnoy.orm;

import java.sql.Connection;
import java.util.Optional;

public class UserRepository {

    private final Connection connection;

    private final UserMapper mapper;

    private final UnitOfWork unitOfWork;

    public UserRepository(Connection connection) {
        this.connection = connection;
        this.mapper = new UserMapper(connection);
        this.unitOfWork = new UnitOfWork(mapper);
    }

    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    public void beginTransaction() {

    }

    public void insert(User user) {

    }

    public void update(User user) {

    }

    public void delete(User user) {

    }

    public void commitTransaction() {

    }
}
