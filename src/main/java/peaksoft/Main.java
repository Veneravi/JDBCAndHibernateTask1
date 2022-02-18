package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService=new UserServiceImpl();
        userService.saveUser("Venera","Adybaeva",(byte)23);

        User user2=new User("Jamila","Abylova",(byte)47);
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        User user3=new User("Sapargul","Satybaldieve",(byte)52);
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        User user4=new User("Chyngyz","Kamarov",(byte)25);
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        User user5=new User("Elnura","Tajibaeva",(byte)24);
        userService.saveUser(user5.getName(), user5.getLastName(), user5.getAge());




        List<User> userList= (List<User>) userService.getAllUsers();
        for (User u:userList) {
            System.out.println(u);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        userService.getAllUsers();
    }
}
