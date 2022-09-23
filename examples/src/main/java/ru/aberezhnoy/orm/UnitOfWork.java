package ru.aberezhnoy.orm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitOfWork {

    private final List<User> newUsers = new ArrayList<>();
    private final List<User> updateUsers = new ArrayList<>();
    private final List<User> deleteUsers = new ArrayList<>();
    private final UserMapper userMapper;

    public UnitOfWork(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void registerNew(User user) {
        this.newUsers.add(user);
    }

    public void registerUpdate(User user) {
        this.updateUsers.add(user);
    }

    public void registerDelete(User user) {
        this.deleteUsers.add(user);
    }

    public void commit() {
        newUsers.forEach(userMapper::insert);
//        newUsers.clear();
        for (User u : updateUsers) {
            userMapper.update(u);
        }
        deleteUsers.forEach(userMapper::delete);
    }
}
