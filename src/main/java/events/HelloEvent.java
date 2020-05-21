package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("!Hi")){
            if (!event.getMember().getUser().isBot()) {
                //remember to call queue()
                // otherwise our message will never be sent
                event.getChannel().sendMessage(":wave: Er zwaait wat!").queue();
            }
        }
    }
}
