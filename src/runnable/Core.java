package runnable;


// @author Miguel

public class Core {
    
    private static final Runtime run=Runtime.getRuntime();
    public static void batteryLevel() throws Exception{
        Process bat=run.exec("pmset -g batt ");
        System.out.println(bat.toString());
        
    }

}
