package runnable;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.*;
import java.io.File;
import net.sourceforge.javaflacencoder.FLACFileWriter;
import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.microphone.MicrophoneAnalyzer;
import com.darkprograms.speech.recognizer.Recognizer;
import com.darkprograms.speech.recognizer.GoogleResponse;
import config.Database;
import java.io.*;


/**
 *
 * @author Miguel
 */
public class Start {
        
    public static void main(String[] args)  {
        
        Database.Create();
        try{
            ambientListening();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void ambientListening() {
	MicrophoneAnalyzer mic = new MicrophoneAnalyzer(FLACFileWriter.FLAC);
	mic.setAudioFile(new File("voice.flac"));
	while(true){
            mic.open();
            //margin to activate mic
            final int THRESHOLD = 10;
            int volume = mic.getAudioVolume();
            boolean isSpeaking = (volume > THRESHOLD);
            if(isSpeaking){
                try {
                        System.out.println("Listening to voice");
                        mic.captureAudioToFile(mic.getAudioFile());
                        do{
                            Thread.sleep(100);
                        }
                        while(mic.getAudioVolume() > THRESHOLD);
                        System.out.println("Procesing Request");
                        Recognizer rec = new Recognizer(Recognizer.Languages.ENGLISH_US,"AIzaSyAd_NTqS8ka4Z-W7YlQBLxwSL645JBBo-8");
                        GoogleResponse response = rec.getRecognizedDataForFlac(mic.getAudioFile(), 3);
                        System.out.println(response.getResponse());
                } catch (Exception e) {
                        e.printStackTrace();
                }
                mic.close();
            }
        }
    }
}

