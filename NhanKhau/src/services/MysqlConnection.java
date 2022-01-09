package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hai
 */
public class MysqlConnection {
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "quan_ly_nhan_khau";
        String userName = "postgres";
        String password = "123123";
        return getMysqlConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMysqlConnection(String hostName, String dbName, String userName, String password) 
        throws SQLException, ClassNotFoundException{
        //Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:postgresql://localhost:5432/quan_ly_nhan_khau";;
        System.out.println(connectionUrl);
        Connection conn = null;
        try {
        	conn = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (Exception e){
        	System.out.println(e);
        }
        
        if(conn != null) System.out.println("Connected!");
        else System.out.println("Failed");
        return conn;
    }
}
