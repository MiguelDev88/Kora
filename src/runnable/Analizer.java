package runnable;


// @author Miguel

public class Analizer {
    
    
    public static void analizeCommand(String command){
        if(command==null) return;
        System.out.println("Analizing command \""+command+"\"");
        //RAW TESTING//
        if(command.equals("hello"))
            System.out.println("HOLA");//Speaker.say("hola miguel");
        else
            System.out.println("ADIOS");
    }

}
