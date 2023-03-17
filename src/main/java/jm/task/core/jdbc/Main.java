package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static UserServiceImpl userService = new UserServiceImpl();
    private static void save(String name, String lastName, byte age) {
        userService.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }
    public static void main(String[] args) throws SQLException {


        userService.createUsersTable();

        save("Nigmat", "Nigmatullin", (byte) 25);
        save("Ayusha", "Nigmatullin", (byte) 25);
        save("Assaf Josef", "Nigmatullin", (byte) 1);
        save("Jotaro", "Kujo", (byte) 111);


        System.out.println();
        userService.getAllUsers().stream()
                        .forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
