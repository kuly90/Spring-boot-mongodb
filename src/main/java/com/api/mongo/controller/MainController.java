package com.api.mongo.controller;

import com.api.mongo.common.Common;
import com.api.mongo.service.CreateCollectionService;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    CreateCollectionService creCollService;
    @PostMapping(value = "/createTable/{tableName}")
    public String createTable(@PathVariable(value = "tableName") String collName, @RequestBody Map<String, Object> documents) {

        Common common = new Common();
        // remote database
        MongoDatabase database = common.getDatabase("demo");
        // create, insert data input collection
        creCollService.createCollection(database, collName, documents);

        return "Success !!!";
    }
}
