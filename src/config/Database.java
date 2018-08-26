package config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import runnable.Console;
import runnable.Core;
import runnable.Speaker;



// @author Miguel

public class Database {
    
    
    private static final String URL = "192.168.178.150";
    private static final String PORT = "3306";
    private static final String USER = "miguel";
    private static final String PASSWORD = "miguelDev";
    
    
    public static boolean Create(){
        try{
            Connection connection = Connect();
            Statement statement=connection.createStatement();
                
            statement.execute("CREATE DATABASE IF NOT EXISTS KORA");
            statement.execute("USE KORA");
            
            statement.execute("CREATE TABLE IF NOT EXISTS settings (" +
                                    " variable varchar(255) NOT NULL," +
                                    " value text NOT NULL," +
                                    " PRIMARY KEY (variable)" +
                                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1");
            connection.close();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public static Connection Connect(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://"+URL+":"+PORT+"/?user="+USER+"&password="+PASSWORD);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
