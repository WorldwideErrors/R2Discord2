package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.Objects;

public class ReactionMessage extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        EmbedBuilder eb = new EmbedBuilder();

        //Controle of het bericht met !roles begint en je de rol "Sir." hebt
        if (args[0].equalsIgnoreCase("!roles") && event.getMember().getRoles().contains(event.getGuild().getRoleById("634528948365164544"))) {
            //Opbouw bericht
            eb.setDescription("Welkom in de Zhyra & Friends Discord! Je kan bepaalde rollen aanvragen met het klikken op de emoji!");
            eb.setColor(Color.cyan);
            eb.setFooter("Rollen", event.getAuthor().getAvatarUrl());
            //Reactie emotes toevoegen aan het bericht
            event.getChannel().sendMessage(eb.build()).queue(message -> {
                //League of Legends emoji
                message.addReaction(":lol:712378632529772633").queue();
                //Valorant emoji
                message.addReaction(":valorant:712378394397900882").queue();
                //Minecraft emoji
                message.addReaction(":mc:712378105674596373").queue();
                //Netflix emoji
                message.addReaction(":netflix:712378884519231518").queue();
            });
            //Geen permissies-melding
        } else if (args[0].equalsIgnoreCase("!roles") && !event.getMember().getRoles().contains(event.getGuild().getRoleById("634528948365164544"))  ) {
            event.getChannel().sendMessage("Je hebt geen permissies om dit commando uit te voeren.").queue();
        }
    }
}