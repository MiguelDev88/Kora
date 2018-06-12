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
            Connection conection = DriverManager.getConnection("jdbc:mysql://"+URL+":"+PORT+"/?user="+USER+"&password="+PASSWORD);
            Statement statement=conection.createStatement();
                
            statement.execute("CREATE DATABASE IF NOT EXISTS KORA");
            statement.execute("USE KORA");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
