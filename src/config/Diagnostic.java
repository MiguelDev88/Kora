/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import runnable.Console;
import runnable.Core;
import runnable.Speaker;

/**
 *
 * @author Miguel
 */
public class Diagnostic {
    
    public static void checkDatabase(){
        Core.displayText("Checking database status...  ",Console.ANSI_BLUE);
        if(!Database.Create()){
            System.out.print(Console.ANSI_RED+"ERROR");
            Speaker.playNotification();
        }
        else {
            System.out.print(Console.ANSI_GREEN+"OK");
            Speaker.playSuccess();
        }
    }
    
    public static void checkBattery(){
        int level = Core.batteryLevel();
        if(level>0 && level<=25){
            Speaker.say("Battery at "+level+"%.");
        }
    }
}
