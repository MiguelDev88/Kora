package threads;
import config.Diagnostic;
import config.Settings;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import runnable.Speaker;

// @author Miguel

public class Email extends Thread{
    
    public void run(){
        try{
            while(true){
                readEmail();
                sleep(30000);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void readEmail(){
        try{
            Properties properties= new Properties();
            properties.setProperty("mail.store.protocol", "imaps");
            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore("imaps");
            store.connect("outlook.office365.com",Settings.getSetting("EMAIL_USER"),Settings.getSetting("EMAIL_PSW"));
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            FlagTerm unseen = new FlagTerm(new Flags(Flags.Flag.SEEN),false);
            FlagTerm recent = new FlagTerm(new Flags(Flags.Flag.RECENT),true);
            SearchTerm filter=new AndTerm(unseen,recent);
            Message messages[]=folder.search(filter);
            if(messages.length>0){
                File sound=new File("resources/newemail.wav");
                Speaker.playSound(sound);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
}