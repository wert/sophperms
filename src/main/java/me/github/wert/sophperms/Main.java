package me.github.wert.sophperms;

import me.github.wert.sophperms.commands.setrank;
import me.github.wert.sophperms.database.mongoConnect;
import me.github.wert.sophperms.listeners.inventoryClick;
import me.github.wert.sophperms.listeners.onChat;
import me.github.wert.sophperms.listeners.onJoin;
import me.github.wert.sophperms.models.User;
import me.github.wert.sophperms.utils.message;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private static Main instance;
    public mongoConnect mongoConnect;

    public HashMap<UUID, PermissionAttachment> perms = new HashMap<>();

    public static HashMap<UUID,String> prefixes = new HashMap<UUID, String>();


    @Override
    public void onEnable() {
        instance = this;

        configuration();

        instanceClasses();
        mongoConnect.connect();


        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new onChat(), this);
        getServer().getPluginManager().registerEvents(new inventoryClick(), this);
        getCommand("setrank").setExecutor(new setrank());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    void configuration() {
        saveDefaultConfig();
    }


    public void setupPerms(Player player) {
        PermissionAttachment att = player.addAttachment(this);
        this.perms.put(player.getUniqueId(), att);
        permsSetter(player.getUniqueId());
    }

    public void permsSetter(UUID uuid) {
        PermissionAttachment att = this.perms.get(uuid);
        String group = User.getRank(uuid).getName();
        for(String permissions : this.getConfig().getStringList("groups." + group + ".permissions")) {
            message.consoleInfo(permissions);
            att.setPermission(permissions,true);
        };
    }

    public static HashMap<UUID, String> getPrefixes() { return prefixes; }

    public static void setPrefixes(HashMap<UUID, String> prefixes) { Main.prefixes = prefixes; }

    private void instanceClasses() {
        mongoConnect = new mongoConnect();
    }

    public static Main getInstance() {
        return instance;
    }
}
