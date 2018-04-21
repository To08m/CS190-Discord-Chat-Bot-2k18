import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.*;
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
        //VoiceChannel objVCh = evt.getC
        String[] msg = objMsg.getContentDisplay().split(" ");
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
                        String line;
                        while ((line = br.readLine()) != null) {
                            objMsgCh.sendMessage(line).queue();
                        }
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

            writer.write(timeStamp+" "+objMsg.getContentDisplay());
            writer.close();

        } catch (IOException e) {
            System.out.println("error writing in file");
        }


        if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"ping")){
            objMsgCh.sendMessage(objUser.getAsMention()+" Pong").queue();
        }
        else if(objMsg.getContentRaw().equalsIgnoreCase())
    }
}