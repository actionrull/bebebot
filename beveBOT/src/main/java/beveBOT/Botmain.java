package beveBOT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Botmain extends ListenerAdapter {
	public static void main(String[] args) throws LoginException, InterruptedException, FileNotFoundException, IOException {	
		String token;
		Properties prop = new Properties();
		prop.load(new FileInputStream("gradle.properties"));
		token = prop.getProperty("DISCORD_BOT_TOKEN");

		JDA jda = JDABuilder.createDefault(token).build();
	
		jda.addEventListener(new Botmain());
	}

	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
		User user = event.getAuthor();
		Message msg = event.getMessage();
		MessageChannel channel = event.getChannel();
		
		if(user.isBot()) return;
		
        if(msg.getContentRaw().equals("!¹äÁà")) {
        	String[] menu = {"Ä¡Å²", "ÇÇÀÚ", "º¸½Ó", "±èÂî", "ºÎÂî", "ÇÜ¹ö°Å", "ºÐ½Ä", "±¹¹ä", "Àü", "°í±â", "µµ½Ã¶ô", "Åä½ºÆ®", "µ·±î½º"};
    		ArrayList<String> pick = new ArrayList<String>();
    		
        	for (int i = 0; i < menu.length; i++) {        		 
        		pick.add(menu[i]);        
            }
        	
        	Collections.shuffle(pick);
            String pickedOne = pick.get(0);     
            pick.remove(0);
                      
            channel.sendMessage("¿À´ÃÀÇ ¸Þ´º´Â " + pickedOne + "ÀÔ´Ï´Ù.").queue();
        }
    }
}
