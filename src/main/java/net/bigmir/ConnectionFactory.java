package net.bigmir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String url;
    private String user;
    private String password;

    public ConnectionFactory() {
        DBProperties db = new DBProperties();
        this.url = db.getUrl();
        this.user = db.getUser();
        this.password = db.getPasssword();
    }
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
