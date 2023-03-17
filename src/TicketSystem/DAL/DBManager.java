package TicketSystem.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBManager {
    private static DBManager instance = null;

    private SQLServerDataSource source;

    private DBManager(String ip, int port, String dbName, String username, String password) {
        source = new SQLServerDataSource();
        source.setServerName(ip);
        source.setPortNumber(port);
        source.setUser(username);
        source.setPassword(password);
        source.setDatabaseName(dbName);
        source.setTrustServerCertificate(true);
    }

    public DBManager getInstance(){
        if (instance == null){

        }
        return instance;
    }



}
