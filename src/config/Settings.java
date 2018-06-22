package config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// @author Miguel

public class Settings {
      
    public static String getSetting(String val){
        String response="";
        try{
            Connection connection = Database.Connect();
            Statement statement=connection.createStatement();
            statement.execute("USE KORA");
            ResultSet result=statement.executeQuery("SELECT value FROM settings WHERE variable=\""+val+"\" ");
            while(result.next())
            response=result.getString(1);
            connection.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return response;
    }
    

}
