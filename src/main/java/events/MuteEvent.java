package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MuteEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        //Controle of de zin begint met !mute en je de Sir. rol hebt
        if (args[0].equalsIgnoreCase("!mute") && event.getMember().getRoles().contains(event.getGuild().getRoleById("634528948365164544"))) {
            //Controle of alleen een mention achter staat
            if (args.length > 1 && args.length < 3) {
                Member member = null;
                Role role = event.getGuild().getRoleById("713691003575337010");
                //Controle of er iemand gementioned wordt
                if (!event.getMessage().getMentionedMembers().isEmpty()) {
                    member = event.getMessage().getMentionedMembers().get(0);
                    if (!member.getRoles().contains(role)) {
                        // Mute gebruiker
                        event.getChannel().sendMessage(args[1] + " is gedempt.").queue();
                        event.getGuild().addRoleToMember(member, role).complete();
                    } else {
                        // Unmute gebruiker
                        event.getChannel().sendMessage(args[1] + " is niet meer gedempt.").queue();
                        event.getGuild().removeRoleFromMember(member, role).complete();
                    }
                } else {
                    //Je hebt niemand gementioned
                    event.getChannel().sendMessage("Incorrecte syntax. Use `!mute @[gebruiker] [tijd in minuten {optioneel}]`").complete();
                }
            //Controle of je er een tijd achter gezet hebt
            } else if (args.length == 3) {
                Member member = null;
                Role role = event.getGuild().getRoleById("713691003575337010");
                //Controle of er iemand gementioned is
                if (!event.getMessage().getMentionedMembers().isEmpty()) {
                    member = event.getMessage().getMentionedMembers().get(0);
                    event.getChannel().sendMessage(args[1] + " is gedempt voor " + args[2] + " minuten.").queue();
                    event.getGuild().addRoleToMember(member, role).queue();

                    // Unmute na enkele minuten
                    Member finalMember = member;
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    event.getChannel().sendMessage(args[1] + " is niet meer gedempt.").queue();
                                    event.getGuild().removeRoleFromMember(finalMember, role).complete();
                                }
                            },
                            Integer.parseInt(args[2]) * 60000
                    );
                //Niemand gementioned
                } else {
                    System.out.println("Incorrecte syntax");
                    event.getChannel().sendMessage("Incorrect syntax. Use `!mute [user mention] [time {optional}]`").complete();
                }
            //Als je geen Sir. rol hebt
            }else if (args[0].equalsIgnoreCase("!mute") && !event.getMember().getRoles().contains(event.getGuild().getRoleById("634528948365164544"))  ) {
                System.out.println("Geen permissies");
                event.getChannel().sendMessage("Je hebt geen permissies om dit commando uit te voeren.").complete();
            }
        }
    }
}