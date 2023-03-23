package TicketSystem.DAL;

import TicketSystem.DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DBManager {
    private static DBManager instance = null;
    private DatabaseConnector databaseConnector;

    private SQLServerDataSource source;

    private DBManager(String ip, int port, String dbName, String username, String password) throws SQLServerException {
        databaseConnector.getConnection();
    }

    public DBManager getInstance(){
        if (instance == null){

        }
        return instance;
    }



}
