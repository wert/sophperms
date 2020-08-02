package me.github.wert.sophperms.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.github.wert.sophperms.Main;
import me.github.wert.sophperms.utils.message;
import org.bson.Document;
import org.bson.conversions.Bson;

public class mongoConnect {
    private MongoDatabase database;
    private MongoCollection ranks;

    private final Main instance = Main.getInstance();

    public void connect(){
        MongoClient client = MongoClients.create(instance.getConfig().getString("mongo.uri"));
        setDatabase(client.getDatabase("server"));
        setRanks(database.getCollection("ranks"));
        message.consoleInfo("Database connected");
    }

    public void setRankDoc(Object value, String identifier, String uuid) {
        Document document = new Document("uuid", uuid);
        Bson newValue = new Document(identifier, value);
        Bson updateOp = new Document("$set", newValue);
        ranks.updateOne(document, updateOp);
    }

    public Object getRankDoc(String identifier, String uuid) {
        Document document = new Document("uuid",uuid);
        if(ranks.find(document).first() != null) {
            Document found = (Document) ranks.find().first();
            return found.get(identifier);
        } else {
            message.consoleError("Document is null for UUID: "+uuid);
            return null;
        }
    };

    public MongoCollection getRanks() {
        return ranks;
    }

    public void setRanks(MongoCollection ranks) {
        this.ranks = ranks;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }
}
