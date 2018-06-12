package runnable;
import config.Database;


/**
 *
 * @author Miguel
 */
public class Start {
        
    public static void main(String[] args)  {
        
        Database.Create();
        try{
            Listen.ambientListening();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

