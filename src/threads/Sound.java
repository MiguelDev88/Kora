package threads;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// @author Miguel

public class Sound extends Thread {
        
    File sound;
    
    public Sound(File sound){
        this.sound=sound;
    }
    
    public void run (){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            this.sleep(clip.getMicrosecondLength()/1000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
