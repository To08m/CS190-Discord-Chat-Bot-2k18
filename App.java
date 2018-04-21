package To08m;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App extends ListenerAdapter
{
    public static void main( String[] args ) throws Exception
    {
        JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
        jda.addEventListener(new App());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent evt){
        User objUser = evt.getAuthor();
        MessageChannel objMsgCh= evt.getChannel();
        Message objMsg = evt.getMessage();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String[] msg = objMsg.getContentDisplay().split(" ");
        if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"listusers")) {
            File folder = new File(".");
            File[] listofFiles = folder.listFiles();
            for(int i =0; i<listofFiles.length; i++){
                if(listofFiles[i].isFile() && !(listofFiles[i].getName().contains(".")) && listofFiles[i].getName().length()<20){
                    objMsgCh.sendMessage(listofFiles[i].getName()).queue();

                }
            }
            return;
        }
        if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"ping")){
            objMsgCh.sendMessage(objUser.getAsMention()+" Pong").queue();
            return;
        }

        if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"time")){
            objMsgCh.sendMessage(timeStamp).queue();
            return;
        }
        if(objMsg.getContentDisplay().charAt(0) == '!'){
            if(msg.length == 1){
                //if there is only "!userID" in the message, print the messages
                String thisUser = "";
                for(int i=1;i<msg[0].length();i++){
                    thisUser += msg[0].charAt(i);
                }
                File f = new File(thisUser);
                if(!f.exists()) {
                    objMsgCh.sendMessage(objUser.getAsMention()+" There is no user with such a userID").queue();
                }else {
                    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                        String line,finall = "";
                        while ((line = br.readLine()) != null) {
                            finall+=line+"\n";
                        }
                        objMsgCh.sendMessage(finall).queue();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        File file = new File(objUser.getAvatarId());
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);

            writer.write(timeStamp+" "+objMsg.getContentDisplay()+System.getProperty( "line.separator" ));
            writer.close();
        } catch (IOException e) {
            System.out.println("error writing in file");
        }
    }
}
