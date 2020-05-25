package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        //Controle of het bericht !hi bevat
        if(messageSent.equalsIgnoreCase("!Hi")){
            //Controle of het geen bot is
            if (!event.getMember().getUser().isBot()) {
                //Antwoord van de bot
                event.getChannel().sendMessage(":wave: Er zwaait wat!").queue();
            }
            else {
                //Voor als het een bot is
                System.out.println("It was a bot.");
            }
        }
    }
}
