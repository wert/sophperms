package me.github.wert.sophperms.gui;

import me.github.wert.sophperms.models.User;
import me.github.wert.sophperms.utils.ItemBuilder;
import me.github.wert.sophperms.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class setRankGUI {

    public static void openInv(Player p, OfflinePlayer target) {

        Inventory inv = Bukkit.createInventory(null, 36, message.chat("&cRanks &8» &fSet " + target.getName() + "'s Rank"));
        message.consoleInfo(User.getRank(p.getUniqueId()).getName());
        switch(User.getRank(p.getUniqueId()).getName()) {
            case "OWNER": {
                inv.setItem(10, new ItemBuilder(Material.LIME_DYE)
                        .displayname("&4Owner")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&7Set &f" + target.getName() + "&7's rank to &4Owner",
                                "",
                                "&7&m                                  ")
                        .build());
                inv.setItem(11, new ItemBuilder(Material.GRAY_DYE)
                        .displayname("&4Manager")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&7Set &f" + target.getName() + "&7's rank to &4Manager",
                                "",
                                "&7&m                                  ")
                        .build());
                inv.setItem(12, new ItemBuilder(Material.LIME_DYE)
                        .displayname("&6Admin")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&7Set &f" + target.getName() + "&7's rank to &6Admin",
                                "&7&m                                  ",
                                "",
                                "&7Right click to set")
                        .build());

                inv.setItem(13, new ItemBuilder(Material.LIME_DYE)
                        .displayname("&2&oSr Mod")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                      ",
                                "&7Set &f" + target.getName() + "&7's rank to &2&oSr Mod",
                                "&7&m                                      ",
                                "",
                                "&7Right click to set")
                        .build());
                break;
            }
            case "MANAGER": {
                inv.setItem(10, new ItemBuilder(Material.GRAY_DYE)
                        .displayname("&4Owner")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&cInsufficient permission(s)",
                                "&7&m                                  ")
                        .build());
                inv.setItem(11, new ItemBuilder(Material.GRAY_DYE)
                        .displayname("&4Manager")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&cInsufficient permission(s)",
                                "&7&m                                  ")
                        .build());
                inv.setItem(12, new ItemBuilder(Material.LIME_DYE)
                        .displayname("&6Admin")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&7Set &f" + target.getName() + "&7's rank to &6Admin",
                                "&7&m                                  ",
                                "",
                                "&7Right click to set")
                        .build());

                inv.setItem(13, new ItemBuilder(Material.LIME_DYE)
                        .displayname("&2&oSr Mod")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                      ",
                                "&7Set &f" + target.getName() + "&7's rank to &2&oSr Mod",
                                "&7&m                                      ",
                                "",
                                "&7Right click to set")
                        .build());
                break;
            }
            case "ADMIN": {
                inv.setItem(10, new ItemBuilder(Material.GRAY_DYE)
                        .displayname("&4Owner")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&cInsufficient permission(s)",
                                "&7&m                                  ")
                        .build());
                inv.setItem(11, new ItemBuilder(Material.GRAY_DYE)
                        .displayname("&4Manager")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&cInsufficient permission(s)",
                                "&7&m                                  ")
                        .build());
                inv.setItem(12, new ItemBuilder(Material.GRAY_DYE)
                        .displayname("&6Admin")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                  ",
                                "&cInsufficient permission(s)",
                                "&7&m                                  ")
                        .build());
                inv.setItem(13, new ItemBuilder(Material.GRAY_DYE)
                        .displayname("&2&oSr Mod")
                        .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                        .addLore("&7&m                                      ",
                                "&cInsufficient permission(s)",
                                "&7&m                                      ",
                                "&7Right click to set")
                        .build());
                break;
            }
        }
            inv.setItem(14, new ItemBuilder(Material.LIME_DYE)
                    .displayname("&2Mod")
                    .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .addLore("&7&m                                  ",
                            "&7Set &f" + target.getName() + "&7's rank to &2Mod",
                            "&7&m                                  ",
                            "",
                            "&7Right click to set")
                    .build());
            inv.setItem(15, new ItemBuilder(Material.LIME_DYE)
                    .displayname("&eTrainee")
                    .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .addLore("&7&m                                      ",
                            "&7Set &f" + target.getName() + "&7's rank to &eTrainee",
                            "&7&m                                      ",
                            "",
                            "&7Right click to set")
                    .build());
            inv.setItem(19, new ItemBuilder(Material.LIME_DYE)
                    .displayname("&d⭐⭐⭐")
                    .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .addLore("&7&m                                  ",
                            "&7Set &f" + target.getName() + "&7's rank to &d⭐⭐⭐",
                            "&7&m                                  ",
                            "",
                            "&7Right click to set")
                    .build());
            inv.setItem(20, new ItemBuilder(Material.LIME_DYE)
                    .displayname("&d⭐⭐")
                    .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .addLore("&7&m                                  ",
                            "&7Set &f" + target.getName() + "&7's rank to &d⭐⭐",
                            "&7&m                                  ",
                            "",
                            "&7Right click to set")
                    .build());
            inv.setItem(21, new ItemBuilder(Material.LIME_DYE)
                    .displayname("&d⭐")
                    .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .addLore("&7&m                                  ",
                            "&7Set &f" + target.getName() + "&7's rank to &d⭐",
                            "&7&m                                  ",
                            "",
                            "&7Right click to set")
                    .build());
            inv.setItem(22, new ItemBuilder(Material.LIME_DYE)
                    .displayname("&7Member")
                    .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .addLore("&7&m                                      ",
                            "&7Set &f" + target.getName() + "&7's rank to &7Member",
                            "&7&m                                      ",
                            "",
                            "&7Right click to set")
                    .build());

        p.openInventory(inv);
    }
}
