package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {

    private static final UserService userService = new UserServiceImpl();
    private void save(String name, String lastName, byte age) {
        userService.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }
    public static void main(String[] args) throws SQLException {

//        !1. убрать лишние файлы из проекта на гит
//        !2. инициализация коннекшн в каждом методе
//        !3. внедряй через интерфейсы
//        !4. поля класса - приватные финальные
//        !5. убрать из мейна статик методы!


        Main main = new Main();

        userService.createUsersTable();

        main.save("Nigmat", "Nigmatullin", (byte) 25);
        main.save("Ayusha", "Nigmatullin", (byte) 25);
        main.save("Assaf Josef", "Nigmatullin", (byte) 1);
        main.save("Jotaro", "Kujo", (byte) 111);


        System.out.println();
        userService.getAllUsers().stream()
                        .forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
