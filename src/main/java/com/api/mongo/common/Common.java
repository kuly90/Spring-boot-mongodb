package com.api.mongo.common;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Common {

    public MongoDatabase getDatabase(String schema) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(schema);
        return database;

    }
}
