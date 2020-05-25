package events;

import com.sun.tools.javac.file.PathFileObject;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.Objects;

public class ReactionRoleAssign extends ListenerAdapter {

    private Member Member;

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){
        //Controle of je een bot bent
        if (!event.getMember().getUser().isBot()){
            //Controle op tekstkanaal
            if (event.getChannel().getId().equals("713481426766397491")){
                //Controle op ID van het bericht
                if (event.getMessageId().equals("713482313773613146")){
                    //Controle op welke Emote
                    if (event.getReactionEmote().getId().equals("712378632529772633")){
                        EmbedBuilder eb = new EmbedBuilder();
                        //De rol wordt toegewezen
                        event.getGuild().addRoleToMember((event.getMember()), (Role) Objects.requireNonNull(event.getGuild().getRoleById("704436775971717171"))).queue();
                        //Opbouw van het bericht
                        eb.setDescription("+ De rol is succesvol gegeven aan \n" + event.getMember().getUser().getName());
                        eb.setColor(Color.green);
                        eb.setTitle("League of Legends");
                        eb.setTimestamp(Instant.now());
                        eb.setFooter("Rol toegewezen");
                        eb.setThumbnail("https://casinosites.be/wp-content/uploads/2019/05/checkk.png");
                        //Sturen van het bericht -> de rol is succesvol gegeven
                        event.getChannel().sendMessage(eb.build()).complete();
                    }
                    //Controle op welke Emote
                    else if (event.getReactionEmote().getId().equals("712378394397900882")){
                        EmbedBuilder eb = new EmbedBuilder();
                        //De rol wordt toegewezen
                        event.getGuild().addRoleToMember((event.getMember()), (Role) Objects.requireNonNull(event.getGuild().getRoleById("710122202216923238"))).queue();
                        //Opbouw van het bericht
                        eb.setDescription("+ De rol is succesvol gegeven aan \n" + event.getMember().getUser().getName());
                        eb.setColor(Color.green);
                        eb.setTitle("Valorant");
                        eb.setTimestamp(Instant.now());
                        eb.setFooter("Rol toegewezen");
                        eb.setThumbnail("https://casinosites.be/wp-content/uploads/2019/05/checkk.png");
                        //Sturen van het bericht -> de rol is succesvol gegeven
                        event.getChannel().sendMessage(eb.build()).complete();
                    }
                    //Controle op welke Emote
                    else if (event.getReactionEmote().getId().equals("712378105674596373")){
                        EmbedBuilder eb = new EmbedBuilder();
                        //De rol wordt toegewezen
                        event.getGuild().addRoleToMember((event.getMember()), (Role) Objects.requireNonNull(event.getGuild().getRoleById("634530182438322206"))).queue();
                        //Opbouw van het bericht
                        eb.setDescription("+ De rol is succesvol gegeven aan \n" + event.getMember().getUser().getName());
                        eb.setColor(Color.green);
                        eb.setTitle("MC");
                        eb.setTimestamp(Instant.now());
                        eb.setFooter("Rol toegewezen");
                        eb.setThumbnail("https://casinosites.be/wp-content/uploads/2019/05/checkk.png");
                        //Sturen van het bericht -> de rol is succesvol gegeven
                        event.getChannel().sendMessage(eb.build()).complete();
                    }
                    //Controle op welke Emote
                    else if (event.getReactionEmote().getId().equals("712378884519231518")){
                        EmbedBuilder eb = new EmbedBuilder();
                        //De rol wordt toegewezen
                        event.getGuild().addRoleToMember((event.getMember()), (Role) Objects.requireNonNull(event.getGuild().getRoleById("705505491148865536"))).queue();
                        //Opbouw van het bericht
                        eb.setDescription("+ De rol is succesvol gegeven aan \n" + event.getMember().getUser().getName());
                        eb.setColor(Color.green);
                        eb.setTitle("Netflix");
                        eb.setTimestamp(Instant.now());
                        eb.setFooter("Rol toegewezen");
                        eb.setThumbnail("https://casinosites.be/wp-content/uploads/2019/05/checkk.png");
                        //Sturen van het bericht -> de rol is succesvol gegeven
                        event.getChannel().sendMessage(eb.build()).complete();
                    }
                }
            }
        }
    }

}
