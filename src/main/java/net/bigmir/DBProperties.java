package net.bigmir;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties {
    private String url;
    private String user;
    private String passsword;
    public DBProperties(){
        InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url=properties.getProperty("db.url");
        user=properties.getProperty("db.user");
        passsword=properties.getProperty("db.password");
    }
    public String getUrl(){
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPasssword() {
        return passsword;
    }
}
