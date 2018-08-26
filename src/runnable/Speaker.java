package runnable;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import threads.Sound;
import config.Settings;

// @author Miguel

public class Speaker {
    
    private static final Runtime run=Runtime.getRuntime();
    
    public static void say (String text){
        try {
            run.exec("say -v "+Settings.defaultVoice+" "+text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void playSound(File sound){
        new Sound(sound).start();
    }
    
    public static void playNotification(){
        File sound = new File("resources/notification.wav");
        new Sound(sound).start();
    }
    
    public static void playSuccess(){
        File sound = new File("resources/success.wav");
        new Sound(sound).start();
    }
}
