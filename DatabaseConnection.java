package librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection Connector(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:resultmanagement.sqlite");
            return conn;
        } catch (Exception e){
            return null;
        }
    }
    public static boolean isDbConnected(){
        try {
            return !Connector().isClosed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
