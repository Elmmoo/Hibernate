package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.sql.JDBCType.BIGINT;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try(Connection connection = new Util().getConnection();
            Statement statement = connection.createStatement()) {
            String sql = "Create table if not exists users (id BIGINT AUTO_INCRIMENT PRIMARY KEY, name VARCHAR(255), lastname VARCHAR(255), age TYNYINT)";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void dropUsersTable() {
        try(Connection connection = new Util().getConnection();
            Statement statement = connection.createStatement()) {
            String sql = "Drop table if exists users";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users (name, lastname, age) values (?, ?, ?)";
            try(Connection connection = new Util().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastName);
                preparedStatement.setByte(3, age);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
