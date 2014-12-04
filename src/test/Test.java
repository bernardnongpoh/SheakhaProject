/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.Set;

/**
 *
 * @author sheakha
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        
        MongoClient mongoclient=new MongoClient("localhost", 27017);
         DB db=mongoclient.getDB("test");
        Set<String> colls = db.getCollectionNames();

        for (String s : colls) {
            System.out.println(s);
        }

        DBCollection coll = db.getCollection("datame.school");
        
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
        .append("type", "database")
        .append("count", 1)
        .append("info", new BasicDBObject("x", 203).append("y", 102));
        coll.insert(doc);
        
        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);


        
    }
    

    
}
