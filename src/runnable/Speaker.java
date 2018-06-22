package runnable;
import java.io.IOException;



// @author Miguel

public class Speaker {
    
    private static final Runtime run=Runtime.getRuntime();
    
    public static void say (String text){
        try {
            run.exec("say "+text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
