import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDA jda = new JDABuilder("NzEyMjQwODc2ODM5MjM5NzIw.Xsad2w.o0-YF4Yi3tvrW19kYUbiyIb1Hfg").build();

        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new WelcomeMessage());
        jda.addEventListener(new Userinfo());
        jda.addEventListener(new ReactionMessage());
        jda.addEventListener(new ReactionRoleAssign());
        jda.addEventListener(new ReactionRoleUnassign());
        jda.addEventListener(new MuteEvent());
        jda.addEventListener(new BannedWords());
    }
}
