package TicketSystem.DAL.db;

import TicketSystem.BE.User;

import java.io.IOException;
import java.sql.*;
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
                int isSysAdmin = rs.getInt("isSysAdmin");
                int isSpecial = rs.getInt("isSpecial");

                User users = new User(id, name, login, password, isSysAdmin, isSpecial);

                allUsers.add(users);
            }

            return allUsers;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Could not get Songs from database", ex);
        }

    }

    public User createPlanner(String name, String login, String password,int isSysAdmin, int isSpecial) throws Exception {
        String sql = "INSERT INTO dbo.Users (name, login, password, isSysAdmin, isSpecial)VALUES (?,?,?,?,?);";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, name);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.setInt(4, isSysAdmin);
            statement.setInt(5, isSpecial);

            statement.executeUpdate();
            //giving an ID value to the Planner we create.
            ResultSet rs = statement.getGeneratedKeys();
            int id = 0;

            if(rs.next());{
                id = rs.getInt(1);
            }

            User user = new User(id, name, login, password, isSysAdmin, isSpecial);
            return user;
        }
        catch (SQLException exc){
            exc.printStackTrace();
            throw new Exception("Could not create Planner", exc);

        }
    }
}

