package me.github.wert.sophperms.listeners;

import me.github.wert.sophperms.Main;
import me.github.wert.sophperms.models.User;
import me.github.wert.sophperms.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static me.github.wert.sophperms.utils.NameTag.setAboveHeadPrefix;

public class inventoryClick implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        String title = ChatColor.stripColor(event.getView().getTitle());
        if(!title.contains("Ranks")) {return;}
        event.setCancelled(true);
        Player p = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if(item == null || item.getType().equals(Material.AIR)) {return;}

        if(item.getType().name().equals("GRAY_DYE")) {
            message.playerError(p,"Insufficient permission(s)");
        } else if(item.getType().name().equals("LIME_DYE")) {
            String name = title.replace("Ranks","")
                    .replace("Set","")
                    .replace("'s","")
                    .replace("Rank","")
                    .replace(" ","")
                    .replace("»","");
            OfflinePlayer t = Bukkit.getOfflinePlayer(name);
            String rank = ChatColor.stripColor(item.getItemMeta().getDisplayName()).toUpperCase().replace(" ","");
            User.setRank(t.getUniqueId().toString(),rank);

            if(t.isOnline()) {
                Player ta = Bukkit.getPlayer(name);
                ta.removeAttachment(Main.getInstance().perms.get(ta.getUniqueId()));
                Main.getInstance().perms.remove(ta.getUniqueId());
                Main.getInstance().setupPerms(ta);
                setAboveHeadPrefix(ta,message.chat(Main.prefixes.get(ta.getUniqueId()) + " &f"));
                ta.setPlayerListName(message.chat(Main.prefixes.get(ta.getUniqueId()) + " &f") + ta.getDisplayName());
            };
        }


    }


}
