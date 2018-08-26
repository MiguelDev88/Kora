package interactions;
import config.Database;
import config.Diagnostic;
import config.Settings;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import runnable.Core;
import runnable.Start;

// @author Miguel

public class Dialog {
    
    public static void salute() {
        Core.displayText("Hello "+Settings.user,"");
    }
    
    public static void startDialog(){
        Core.displayText("Would you like to run status check?","");
        while (true){
            try{
                String read = Start.reader.readLine().toLowerCase();
                if(read.equals("yes") || read.equals("ye") || read.equals("y")){
                    Diagnostic.checkDatabase();
                    break;
                }
                else if (read.equals("no") || read.equals("n")){
                    Core.displayText("Skipping status check", read);
                    break; 
                }else Core.displayText("Sorry, could you be more clear please?", "");
            }catch(Exception e){
               System.out.println(e.getMessage()); 
            }
        }
    }
}
