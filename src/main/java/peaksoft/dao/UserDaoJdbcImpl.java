package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String CREATE_SQL="CREATE TABLE if NOT EXISTS users"+
                "(id serial,"+
                "name VARCHAR(250),"+
                "lastName VARCHAR(250),"+
                "age INT NOT NULL)";
        try (Connection conn = Util.connection()) {
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(CREATE_SQL);
                System.out.println("Таблица создано");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
@Override
    public void dropUsersTable() {
        String DROP_SQL = "DROP TABLE if EXISTS users";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(DROP_SQL);
            System.out.println("Таблица удалено");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
@Override

    public void saveUser(String name, String lastName, byte age) {
        try(Connection connnect = Util.connection()) {
            PreparedStatement statement = connnect.prepareStatement("INSERT INTO users(name, lastName, age) VALUES (?,?,?);");
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setInt(3,age);
            statement.executeUpdate();
            System.out.println(name +" "+" ДатаБаза га кошулуу.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
@Override
    public void removeUserById(long id) {
        String REMOVE_USERS_SQL="DELETE FROM users WHERE id=?";
        try (Connection conn=Util.connection();
             PreparedStatement statement= conn.prepareStatement(REMOVE_USERS_SQL)){
            statement.setLong(1,id);
            statement.executeUpdate();
            System.out.println(id+" "+"Удаление ползователя по id");

        }catch(SQLException e){
            System.out.println(e.getMessage());

        }


    }
@Override
    public List<User> getAllUsers () {
    String Get_All_SQL = "SELECT * FROM users";
    List<User> userList = new ArrayList<>();
    try (Connection connect = Util.connection()) {
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(Get_All_SQL);
        System.out.println("getAllUsers ийгиликтуу тузулду!!!");
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastName"));
            user.setAge(resultSet.getByte("age"));
            userList.add(user);

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return userList;
    }
@Override
    public void cleanUsersTable() {
        String CLEAN_SQL = "truncate users";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(CLEAN_SQL);
            System.out.println("cleaned users table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}