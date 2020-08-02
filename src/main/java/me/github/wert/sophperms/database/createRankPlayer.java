package me.github.wert.sophperms.database;

import me.github.wert.sophperms.Main;
import org.bson.Document;
import me.github.wert.sophperms.database.mongoConnect;

public class createRankPlayer {

    private final Main instance = Main.getInstance();


    public createRankPlayer(String uuid) {

        Document document = new Document("uuid",uuid);
        mongoConnect mongoConnect = instance.mongoConnect;
        mongoConnect.getRanks().insertOne(document);

    }
}
