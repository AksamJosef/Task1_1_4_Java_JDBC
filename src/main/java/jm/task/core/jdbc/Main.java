package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {

    private void save(String name, String lastName, byte age) {
//        (name, lastName, age);

    }
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();


        userService.saveUser("Nigmat", "Nigmatullin", (byte) 25);
        System.out.println("User с именем Nigmat добавлен в базу данных");
//        System.out.println("User с именем " + name + " добавлен в базу данных");

        userService.saveUser("Ayusha", "Nigmatullina", (byte) 25);
        System.out.println("User с именем Ayusha добавлен в базу данных");

        userService.saveUser("Assaf Josef", "Nigmatullin", (byte) 1);
        System.out.println("User с именем Assaf Josef добавлен в базу данных");

        userService.saveUser("Jotaro", "Kujo", (byte) 111);
        System.out.println("User с именем Jotaro добавлен в базу данных");



        System.out.println();
        userService.getAllUsers().stream()
                        .forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
