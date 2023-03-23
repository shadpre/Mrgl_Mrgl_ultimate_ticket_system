package TicketSystem.DAL.db;

import TicketSystem.BE.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO_DB {
    private DatabaseConnector databaseConnector;

    public UsersDAO_DB() throws IOException {
        databaseConnector = new DatabaseConnector();
    }

    public List<User> getAllUsers() throws Exception {

        ArrayList<User> allUsers = new ArrayList<>();


        try (Connection conn = databaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM dbo.Users;";


            ResultSet rs = stmt.executeQuery(sql);

            // Loop through rows from the database result set
            while (rs.next()) {

                //Map DB row to Song object
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String login = rs.getString("Login");
                String password = rs.getString("Password");
                int isSpecial = rs.getInt("isSpecial");

                User users = new User(id, name, login, password, isSpecial);

                allUsers.add(users);
            }

            return allUsers;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Could not get Songs from database", ex);
        }

    }
}

