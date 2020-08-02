package me.github.wert.sophperms.listeners;

import me.github.wert.sophperms.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

import static me.github.wert.sophperms.utils.message.chat;

public class onChat implements Listener {

    @EventHandler
    public void messageSent(AsyncPlayerChatEvent event)
    {
        Player p = event.getPlayer();


        //TODO.md chat disabler
        //TODO.md Set color in tab list on join and chat on chat.

        String prefix = Main.prefixes.getOrDefault(p.getUniqueId(),"&7");
        String format = "";
        if(prefix.contains("&7")) {
            format = chat(prefix + "&r" + p.getDisplayName() + " &8»&7 ");
        } else if (prefix.contains("&d")) {
            format = chat(prefix + "&r " + p.getDisplayName() + " &8»&f ");
        } else if (prefix.contains("Trainee")) {
            format = chat(prefix + "&r " + p.getDisplayName() + " &8»&a ");
        } else if (prefix.contains("Mod")) {
            format = chat(prefix + "&r " + p.getDisplayName() + " &8»&a ");
        } else if (prefix.contains("Admin")) {
            format = chat(prefix + "&r " + p.getDisplayName() + " &8»&a ");
        } else if (prefix.contains("Dev")) {
            format = chat(prefix + "&r " + p.getDisplayName() + " &8»&a ");
        } else if (prefix.contains("Manager")) {
            format = chat(prefix + "&r " + p.getDisplayName() + " &8»&c ");
        }

        event.setFormat(format + event.getMessage());

    }

}
