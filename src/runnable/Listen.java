package runnable;
import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.microphone.MicrophoneAnalyzer;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import net.sourceforge.javaflacencoder.FLACFileWriter;


// @author Miguel

public class Listen extends Thread {
    
    static String API_KEY="AIzaSyAd_NTqS8ka4Z-W7YlQBLxwSL645JBBo-8";
    
    @Override
    public void run() {
        
        try {
            
            MicrophoneAnalyzer mic = new MicrophoneAnalyzer(FLACFileWriter.FLAC);
            File file = new File ("voice.flac");
            mic.captureAudioToFile (file);
            boolean speaking=false;
            while(true){
                int volume = mic.getAudioVolume();
                if(volume>10)
                    speaking=true;
                if(speaking && volume<10){
                 break;
            }
            }
            mic.close();
            
        } catch (LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
