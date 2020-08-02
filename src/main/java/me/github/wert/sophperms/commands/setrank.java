package me.github.wert.sophperms.commands;

import me.github.wert.sophperms.Main;
import me.github.wert.sophperms.gui.setRankGUI;
import me.github.wert.sophperms.models.User;
import me.github.wert.sophperms.utils.Rank;
import me.github.wert.sophperms.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.github.wert.sophperms.utils.NameTag.setAboveHeadPrefix;

public class setrank implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            if(args.length != 2) {
                message.consoleError("Usage: /setrank <player> <rank>");
                return false;
            }

            OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
            String rank = Rank.valueOf(args[1].toUpperCase()).getName();
            User.setRank(t.getUniqueId().toString(),rank);

            if(t.isOnline()) {
                Player ta = Bukkit.getPlayer(args[0]);
                ta.removeAttachment(Main.getInstance().perms.get(ta.getUniqueId()));
                Main.getInstance().perms.remove(ta.getUniqueId());
                Main.getInstance().setupPerms(ta);
                setAboveHeadPrefix(ta,message.chat(Main.prefixes.get(ta.getUniqueId()) + " &f"));
                ta.setPlayerListName(message.chat(Main.prefixes.get(ta.getUniqueId()) + " &f") + ta.getDisplayName());
            };
            message.consoleInfo("Sucessfully put &a"+t.getName()+ "&7 to " + rank);
            return false;
        };

        Player p = (Player) sender;
        if(!p.hasPermission("sophperms.setrank")) {
            message.playerError(p,"Invalid permission(s)");
            return false;
        }
        if(args.length != 1) {
            message.playerError(p,"Usage: /setrank <player>");
            return false;
        }

        OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);

        if(!t.hasPlayedBefore()) {
            message.playerError(p,"That player has never joined..");
            return false;
        }

        setRankGUI.openInv(p,t);

        return false;
    }

}
