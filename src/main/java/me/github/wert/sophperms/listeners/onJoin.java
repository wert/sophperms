package me.github.wert.sophperms.listeners;

import me.github.wert.sophperms.Main;
import me.github.wert.sophperms.database.createRankPlayer;
import me.github.wert.sophperms.models.User;
import me.github.wert.sophperms.utils.NameTag;
import me.github.wert.sophperms.utils.Rank;
import me.github.wert.sophperms.utils.message;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    private final Main instance = Main.getInstance();



    @EventHandler
    public void join(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();

        if (!User.hasRank(p.getUniqueId().toString())) {
            new createRankPlayer(p.getUniqueId().toString());
            User.setRank(p.getUniqueId().toString(),Rank.MEMBER.getName());
        }
        User.setPrefix(p);
        setAboveHeadPrefix(p,message.chat(Main.prefixes.get(p.getUniqueId()) + " &f"));
        p.setPlayerListName(message.chat(Main.prefixes.get(p.getUniqueId()) + " &f") + p.getDisplayName());
        event.setJoinMessage(null);
        Main.getInstance().setupPerms(p);
    }

    public void setAboveHeadPrefix(Player player, String prefix) {
        NameTag.set(player, NameTag.NametagType.PREFIX, prefix, ChatColor.GRAY);
    }

}
