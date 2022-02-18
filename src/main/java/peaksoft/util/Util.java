package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "venera";



    public static Connection connection() {

        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, login, password);
            System.out.println("Подключение БД данных успешно ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }


}
