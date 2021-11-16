package com.api.mongo.service;

import com.mongodb.client.MongoDatabase;

import java.util.Map;

public interface CreateCollectionService {
    public void createCollection(MongoDatabase database, String collName, Map<String, Object> documents);
}
