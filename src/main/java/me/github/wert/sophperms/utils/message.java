package me.github.wert.sophperms.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class message {

    private static final String prefix = "&cRanks &8» &7";

    public static String chat(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static void consoleInfo(String s) {
        Bukkit.getConsoleSender().sendMessage(chat(prefix + "&a" + s));
    }

    public static void consoleError(String s) {
        Bukkit.getConsoleSender().sendMessage(chat(prefix + "&7" + s));
    }

    public static void playerInfo(Player player, String s) {
        player.sendMessage(chat(prefix + "&7" + s));
    }

    public static void playerError(Player player, String s) {
        player.sendMessage(chat(prefix + "&7" + s));
    }
}

