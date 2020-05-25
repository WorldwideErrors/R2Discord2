package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class WelcomeMessage extends ListenerAdapter {
        //De berichten voor als je joined
        String[] messages = {
                "[member] is er klaar voor! [member] is er klaar voor! HAHAHAHAHAHHAH!",
                "[member] is met de deur de discord binnen gevallen!",
                "[member] happens...",
                "Het is niet alsof je nu welkom bent [member]",
                "Kom dat zien! Kom dat zien! [member] is ongevraagd de discord binnen geslopen!",
                "Wie heeft jou toestemming gegeven de discord te joinen, [member]?",
                "Hoi [member], wat doeee je?",
                "Zie jij de [member]? *Klik* Jaa daarzo! Goed dat jij [member] hebt gevonden!",
                "Bonjour [member]! Est-ce que je parle Baguette?"
        };

        public void onGuildMemberJoin(GuildMemberJoinEvent event){

            //Kiest een van de bovenstaande zinnen
            Random rand = new Random();
            int number = rand.nextInt(messages.length);

            //Opbouw van bericht
            EmbedBuilder join = new EmbedBuilder();
            join.setColor(0x66d8ff);
            join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

            //sturen van het bericht
            event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

            //De rol krijgt een "Gast" rol toegewezen
            event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Gast", true)).complete();
        }
    }
