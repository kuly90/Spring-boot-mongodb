package com.api.mongo.service.impl;

import com.api.mongo.service.CreateCollectionService;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreateCollectionImpl implements CreateCollectionService {

    @Override
    public void createCollection(MongoDatabase database, String collName, Map<String, Object> documents) {
        database.createCollection(collName,
                new CreateCollectionOptions().capped(true).sizeInBytes(0x100000));

        // Pass BasicDBObject.class as the second argument
        MongoCollection<BasicDBObject> collection = database.getCollection(collName, BasicDBObject.class);
        BasicDBObject document = new BasicDBObject();
        for(Map.Entry<String, Object> doc : documents.entrySet()) {
            // insert a document
            document.append(doc.getKey(), doc.getValue());
        }
        collection.insertOne(document);
    }

}

