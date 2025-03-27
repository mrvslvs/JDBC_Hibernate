package jm_task_core_jdbc;

import jm_task_core_jdbc.model.User;
import jm_task_core_jdbc.service.UserService;
import jm_task_core_jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Арнольд", "Арнольдов", (byte) 70);
        System.out.println("Пользователь Арнольд Арнольдов добавлен");
        userService.saveUser("Гумберт", "Гумберт", (byte) 33);
        System.out.println("Пользователь Гумберт Гумберт добавлен");
        userService.saveUser("Иисус", "Христос", (byte) 70);
        System.out.println("Пользователь Иисус Христос добавлен");
        userService.saveUser("Никита", "Джавов", (byte) 70);
        System.out.println("Пользователь Никита Джавов добавлен");

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
