package ru.aberezhnoy.orm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OrmApp {
    public static void main(String[] args) throws SQLException {

        OrmDb ormDb = new OrmDb();
        UserRepository userRepository = new UserRepository(ormDb.getConnection());

        ormDb.dropTable();
        ormDb.createTable();

        User tom, bob, john, steve, billy;
        List<User> users = new ArrayList<>(Arrays.asList(
                tom = User.createUser().setLogin("Tom").setPassword("qwerty").build(),
                bob = User.createUser().setLogin("Bob").setPassword("asdfg").build(),
                john = User.createUser().setLogin("John").setPassword("123").build(),
                steve = User.createUser().setLogin("Steve").setPassword("456").build(),
                billy = User.createUser().setLogin("Billy").setPassword("789").build()));

        userRepository.beginTransaction();
        users.forEach(userRepository::insert);
        userRepository.commitTransaction();
        ormDb.show();

        System.out.println("try to findById");
        System.out.println(userRepository.findById(1L));

        steve.setLogin("Monty");
        System.out.println("try to update and delete");
        userRepository.beginTransaction();
        userRepository.insert(User.createUser().setLogin("KakoytaMuzhik").setPassword("paspart").build());
        userRepository.update(steve);
        userRepository.delete(billy);
        userRepository.delete(john);
        userRepository.commitTransaction();

        ormDb.show();
        System.out.println();
    }

    private static void identityMapDisplay(UserMapper userMapper) {
        for (Map.Entry<Long, User> entry : userMapper.getIdentityMap().entrySet()) {
            System.out.println("IMID: " + entry.getKey() + " | id: " + entry.getValue().getId() + " | login: " + entry.getValue().getLogin() + " | password: " + entry.getValue().getPassword());
        }
    }
}
