package runnable;
import com.darkprograms.speech.microphone.MicrophoneAnalyzer;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;
import java.io.File;
import net.sourceforge.javaflacencoder.FLACFileWriter;
import config.*;


// @author Miguel

public class Listen  {
    
    public static final String KEY=Settings.getSetting("API_KEY");

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
                        Recognizer rec = new Recognizer(Recognizer.Languages.ENGLISH_US,KEY);
                        GoogleResponse response = rec.getRecognizedDataForFlac(mic.getAudioFile(), 3);
                        Analizer.analizeCommand(response.getResponse());
                } catch (Exception e) {
                        e.printStackTrace();
                }
                mic.close();
            }
        }
    }
    
   
    
}
