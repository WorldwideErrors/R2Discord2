package events;

import net.dv8tion.jda.annotations.ReplaceWith;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Userinfo extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event){

        String messageSent = event.getMessage().getContentRaw();

        if(messageSent.toLowerCase().startsWith("!userinfo")){
            if (!event.getMessage().getMentionedMembers().isEmpty()) {
                Member Mentioned = null;
                Mentioned = event.getMessage().getMentionedMembers().get(0);
                //remember to call queue()
                // otherwise our message will never be sent
                EmbedBuilder info = new EmbedBuilder();
                info.setDescription(Mentioned.getUser().getName() +  " is de server gejoined op " + Mentioned.getTimeJoined().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "." +
                        "\r \n" + ":white_small_square: Status: "+ Mentioned.getOnlineStatus().name().replace("IDLE", "inactief")
                        .replace("DO_NOT_DISTURB", "niet storen").replace("OFFLINE", "offline").replace("ONLINE", "online") +
                        "\n" + ":white_small_square: Rank: " + Mentioned.getRoles().get(0).getName().toLowerCase() +
                        "\n" + ":white_small_square: " + (Mentioned.getActivities().isEmpty() ? "Speelt: -" : "Speelt: " + Mentioned.getActivities().get(1).getName().toLowerCase()) +
                        "\n" + ":white_small_square: ID: " + Mentioned.getId());

                info.setColor(Color.cyan);
                info.setThumbnail(Mentioned.getUser().getAvatarUrl());
                info.setAuthor("Informatie over " + Mentioned.getUser().getName(), "https://discord.js.org", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Circle-information.svg/1200px-Circle-information.svg.png");

                String dmj = "dd/MM/YYYY";
                String pattern = "HH:mm";
                DateFormat df = new SimpleDateFormat(pattern);
                DateFormat daf = new SimpleDateFormat(dmj);

                Date today = Calendar.getInstance().getTime();
                String todayAsString = df.format(today);
                String todayasstring = daf.format(today);

                info.setFooter(todayasstring + " om " + todayAsString + " - online via " + Mentioned.getActiveClients().toString().replace("[]","[NONE]"));

                event.getChannel().sendMessage(info.build()).queue();

                }
            else {
                System.out.println("there is no mention");
            }
        }

    }
}
