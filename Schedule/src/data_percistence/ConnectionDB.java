package data_percistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private final String host;
    private final String user;
    private final String password;
    private final String dataBank;

    public ConnectionDB() {
        host = "127.0.0.1";
        user = "root";
        password = "";
        dataBank = "commitments";
    }

    public Connection getConnection(){

        String url="jdbc:mysql://" + this.host + "/" + this.dataBank+"?verifyServerCertificate=false&useSSL=true";

        try
        {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex)
        {
            System.out.println("Connection with MySQL failed. :(");
            ex.printStackTrace();
        }
        return null;
    }
}
