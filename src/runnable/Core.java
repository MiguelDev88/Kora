package runnable;
import config.Diagnostic;
import config.Settings;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import threads.*;


// @author Miguel

public class Core {
    
    private static final Runtime run=Runtime.getRuntime();
    private static Battery batteryService=new Battery();
    private static Email emailService=new Email();
    
    public static int batteryLevel(){
        try{
            Process bat=run.exec("pmset -g batt ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(bat.getInputStream()));
            String r;
            int p=0;

            while( (r=reader.readLine()) !=null){
                if(r.contains("InternalBattery")){
                    if(r.substring(23,24).equals("%"))
                        p=Integer.parseInt(r.substring(21, 23));
                    else
                        p=Integer.parseInt(r.substring(21, 24));
                }
            }   
            return p;
        }catch(Exception e){
            System.out.println("Unable to get battery level");
            return 0;
        }
    }
    
    public static void displayText(String text, String color){
        File sound=new File("resources/text.wav");
        System.out.println(color);
        try{
            char[] letters = text.toCharArray();
            for(char a : letters){
               System.out.print(a);
               Speaker.playSound(sound);
               Thread.sleep(Settings.textSpeed);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.print(Console.ANSI_RESET);
    }
    
    public static void activateServices(){
        batteryService.start();
        emailService.start();
    }

}
