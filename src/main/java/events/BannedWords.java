package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class BannedWords extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        String messageSent = event.getMessage().getContentRaw();
            EmbedBuilder eb = new EmbedBuilder();
            //Controle op het gebande woord
            if (messageSent.contains("Kanker")){
                //Het bericht wordt verwijderd
                event.getMessage().delete().queue();

                //Opbouw van het bericht
                eb.setTitle("VERBODEN");
                eb.setDescription(event.getMember().getUser().getName() + ", Ik wil je er op wijzen \n dat het niet de bedoeling is deze woorden \n in deze discord te gebruiken !");
                eb.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
                eb.setColor(Color.yellow);

                //Bericht wordt verstuurd
                event.getChannel().sendMessage(eb.build()).queue();
        }
            //Controle op het gebande woord
        else if (messageSent.contains("Kkr")){
                //Het bericht wordt verwijderd
                event.getMessage().delete().queue();

                //Opbouw van het bericht
                eb.setTitle("VERBODEN");
                eb.setDescription(event.getMember().getUser().getName() + ", \n \n Ik wil je er op wijzen  dat het \n niet de bedoeling is deze woorden \n in deze discord te gebruiken !");
                eb.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
                eb.setColor(Color.yellow);

                //Bericht wordt verstuurd
                event.getChannel().sendMessage(eb.build()).queue();
        }
            //Controle op het gebande woord
            else if (messageSent.contains("Kk")){
                //Het bericht wordt verwijderd
                event.getMessage().delete().queue();

                //Opbouw van het bericht
                eb.setTitle("VERBODEN");
                eb.setDescription(event.getMember().getUser().getName() + ", \n \n Ik wil je er op wijzen  dat het \n niet de bedoeling is deze woorden \n in deze discord te gebruiken !");
                eb.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
                eb.setColor(Color.yellow);

                //Bericht wordt verstuurd
                event.getChannel().sendMessage(eb.build()).queue();
            }
            //Controle op het gebande woord
            else if (messageSent.contains("kankerzooi")){
                //Het bericht wordt verwijderd
                event.getMessage().delete().queue();

                //Opbouw van het bericht
                eb.setTitle("VERBODEN");
                eb.setDescription(event.getMember().getUser().getName() + ", \n \n Ik wil je er op wijzen  dat het \n niet de bedoeling is deze woorden \n in deze discord te gebruiken !");
                eb.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
                eb.setColor(Color.yellow);

                //Bericht wordt verstuurd
                event.getChannel().sendMessage(eb.build()).queue();
            }
            //Controle op het gebande woord
            else if (messageSent.contains("kkrzooi")){
                //Het bericht wordt verwijderd
                event.getMessage().delete().queue();

                //Opbouw van het bericht
                eb.setTitle("VERBODEN");
                eb.setDescription(event.getMember().getUser().getName() + ", \n \n Ik wil je er op wijzen  dat het \n niet de bedoeling is deze woorden \n in deze discord te gebruiken !");
                eb.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
                eb.setColor(Color.yellow);

                //Bericht wordt verstuurd
                event.getChannel().sendMessage(eb.build()).queue();
            }
            //Controle op het gebande woord
            else if (messageSent.contains("kkrjoch")){
                //Het bericht wordt verwijderd
                event.getMessage().delete().queue();

                //Opbouw van het bericht
                eb.setTitle("VERBODEN");
                eb.setDescription(event.getMember().getUser().getName() + ", \n \n Ik wil je er op wijzen  dat het \n niet de bedoeling is deze woorden \n in deze discord te gebruiken !");
                eb.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
                eb.setColor(Color.yellow);

                //Bericht wordt verstuurd
                event.getChannel().sendMessage(eb.build()).queue();
            }

    }
}
