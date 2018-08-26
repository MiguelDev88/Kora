package threads;
import config.Diagnostic;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// @author Miguel

public class Battery extends Thread{
    
    public void run(){
        try{
            while(true){
                Diagnostic.checkBattery();
                sleep(5*60*1000);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
