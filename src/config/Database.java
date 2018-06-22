package config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



// @author Miguel

public class Database {
    
    
    private static final String URL = "localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
    public static void Create(){
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
        }catch(SQLException e){
            System.out.println(e.getMessage());
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
