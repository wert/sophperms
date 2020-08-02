package me.github.wert.sophperms.models;

import me.github.wert.sophperms.Main;
import me.github.wert.sophperms.utils.Rank;
import org.bson.Document;
import org.bukkit.entity.Player;

import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

public class User {



    public static boolean hasRank(String uuid) {
        Document data = (Document) Main.getInstance().mongoConnect.getRanks().find(eq("uuid", uuid)).first();
        return data != null;
    }

    public static void setRank(String uuid, String rank) {
        Main.getInstance().mongoConnect.setRankDoc(rank,"rank",uuid);
    }

    public static Rank getRank(UUID uuid) {
        Document data = (Document) Main.getInstance().mongoConnect.getRanks().find(eq("uuid", uuid.toString())).first();
        Rank r = Rank.valueOf(data.getString("rank"));
        Main.prefixes.put(uuid,r.getPrefix());

        return Rank.valueOf(data.getString("rank"));
    }

    public static void setPrefix(Player p) {
        UUID uuid = p.getUniqueId();
        Document data = (Document) Main.getInstance().mongoConnect.getRanks().find(eq("uuid", uuid.toString())).first();
        Rank r = Rank.valueOf(data.getString("rank"));
        Main.prefixes.put(uuid,r.getPrefix());
    }



}
