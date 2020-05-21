import events.HelloEvent;
import events.Userinfo;
import events.WelcomeMessage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDA jda = new JDABuilder("TheToken").build();

        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new WelcomeMessage());
        jda.addEventListener(new Userinfo());
    }
}
