package me.github.wert.sophperms.utils;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NameTag {

    public static void setAboveHeadPrefix(Player player, String prefix) {
        NameTag.set(player, NameTag.NametagType.PREFIX, prefix, ChatColor.GRAY);
    }

    public static void set(Player player, NametagType type, String text, ChatColor nameColour) {
        Scoreboard playerScoreboard = player.getScoreboard();
        for (Player online : Bukkit.getOnlinePlayers()) {
            Scoreboard onlineScoreboard = online.getScoreboard();
            Team playerTeam = getOrCreateTeam(onlineScoreboard, text);
            switch (type) {
                case PREFIX:
                    playerTeam.setPrefix(text);
                    playerTeam.setColor(nameColour);
                    break;
                case SUFFIX:
                    playerTeam.setSuffix(text);
                    playerTeam.setColor(nameColour);
                    break;
                case BOTH:
                    playerTeam.setPrefix(text);
                    playerTeam.setSuffix(text);
                    playerTeam.setColor(nameColour);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid name tag type.");
            }
            if (!playerTeam.getEntries().contains(player.getName()))
                playerTeam.addEntry(player.getName());
            Team onlineTeamSelf = onlineScoreboard.getTeam(online.getName());
            if (onlineTeamSelf != null) {
                Team onlineTeam = getOrCreateTeam(playerScoreboard, text);
                onlineTeam.setPrefix(onlineTeamSelf.getPrefix());
                onlineTeam.setSuffix(onlineTeamSelf.getSuffix());
                if (!onlineTeam.getEntries().contains(text))
                    onlineTeam.addEntry(online.getName());
            }
        }
    }

    private static Team getOrCreateTeam(Scoreboard scoreboard, String name) {
        Team team = scoreboard.getTeam(name);
        if (team == null)
            team = scoreboard.registerNewTeam(name);
        return team;
    }

    public enum NametagType {
        PREFIX, SUFFIX, BOTH;
    }

    public static void emptyScoreboardTeams(Player player) {
        try {
            Scoreboard playerScoreboard = player.getScoreboard();
            for (Team team : playerScoreboard.getTeams()) {
                for (OfflinePlayer OfflinePlayer : Bukkit.getOfflinePlayers())
                    team.removePlayer((OfflinePlayer)player);
                for (Player player1 : Bukkit.getOnlinePlayers())
                    team.removePlayer((OfflinePlayer)player1);
            }
        } catch (Exception e) {
            Bukkit.getLogger().info(" ");
        }
    }
}
