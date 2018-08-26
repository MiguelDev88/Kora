package runnable;
import interactions.Menu;
import config.Diagnostic;
import interactions.Dialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// @author Miguel

public class Start {
    
    public static final String VERSION="0.2";
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
    public static void main(String[] args) throws Exception  {
        try{
            System.out.println("KORA "+VERSION);
            Thread.sleep(2000);
            startProcess();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
    
    public static void startProcess() throws IOException{
        Dialog.salute();
        Dialog.startDialog();
        startMenu();
    }
    
    public static void startMenu(){
        Menu.mainMenu();   
        try{
            option(Byte.parseByte(reader.readLine()));
        }catch(Exception e){
            System.out.println(Console.ANSI_RED+"INVALID OPTION"+Console.ANSI_RESET);
            Speaker.playNotification();
            startMenu();
        }
    }
    
    public static void option(byte option) throws Exception{
        
        switch(option){
            case 1:
                Listen.ambientListening();
                break;
            case 2:
                Core.activateServices();
                break;
            case 3:
                Diagnostic.checkDatabase();
                break;
            case 0:
                System.out.println("bye");
                System.exit(0);
                break;
            default: throw new Exception();
        }     
        startMenu();
    }
}

