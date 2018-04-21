package To08m;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

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
        File file = new File(objUser.getName());
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


        if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"ping")){
            objMsgCh.sendMessage(objUser.getAsMention()+" Pong").queue();
        }
    }
}
