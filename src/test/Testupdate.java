 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.smcs.model.Document;
import org.smcs.model.Location;
import org.smcs.utility.Utility;

/**
 *
 * @author cs12shea8
 */
public class Testupdate {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException, IOException, InterruptedException{
    
       /*
        Proxy Settings
        
        */
        System.getProperties().put("http.proxyHost", "192.168.0.2");
        System.getProperties().put("http.proxyPort", "8080");
        System.getProperties().put("http.proxyUser", "csshea8");
        System.getProperties().put("http.proxyPassword", "belrich1994");
        /*
        Emd of Proxy Setting
        */
        
      
        
        Gson gson = new Gson();
        
        MongoClient mongoclient=new MongoClient("localhost", 27017);
        
        DB db=mongoclient.getDB("schoolDB");

        DBCollection coll = db.getCollection("schoolDataSet");
        //DBCollection collection = db.getCollection("schoolDataSet");
        
       BasicDBObject query = new BasicDBObject();
       BasicDBObject field = new BasicDBObject();
        field.put("address", 1);
        DBCursor cursor = coll.find(query,field);
        
        while (cursor.hasNext()) {
              String address;
              BasicDBObject obj = (BasicDBObject) cursor.next();
              //System.out.println(obj.toString());
              Document doc = gson.fromJson(obj.toString(), Document.class);
              System.out.println(obj.toString());
        
              address=doc.getAddress().getSchool_name()+" ,"+doc.getAddress().getVill_name()+ " ,"+doc.getAddress().getBlock_name()+" ,"+doc.getAddress().getDistrict_name()+ ","+ doc.getAddress().getPin_code();
              Location location; 
         if((location=Utility.getCoordinate(address))==null){
            System.out.println("1");
            address=doc.getAddress().getVill_name()+ " ,"+doc.getAddress().getBlock_name()+" ,"+doc.getAddress().getDistrict_name()+ ","+ doc.getAddress().getPin_code();
            
            if((location=Utility.getCoordinate(address))==null){
               address=doc.getAddress().getBlock_name()+" ,"+doc.getAddress().getDistrict_name()+ ","+ doc.getAddress().getPin_code();
               System.out.println("2");
               
               if((location=Utility.getCoordinate(address))==null){
                   System.out.println("3");
                   address=doc.getAddress().getDistrict_name()+ ","+ doc.getAddress().getPin_code();
                   location=Utility.getCoordinate(address);
               }
            }
        }
            //doc.getId();
            //System.out.println("Lat:"+location.getLat() + "Long:" + location.getLng());
              
              
              
              
//              BasicDBObject newdocument = new BasicDBObject();
//              newdocument.put(doc.getCoordinate()+"longitude",location.getLng());
//              newdocument.put(doc.getCoordinate()+"latitude",location.getLat());
              
              BasicDBObject updatedoc = new BasicDBObject();
              updatedoc.append("$set",new BasicDBObject().append("longitude",location.getLng()).append("latitude",location.getLat()));
              System.out.println(updatedoc.toString());
              System.out.println("ID" +doc.getId().get$oid());
              BasicDBObject searchQuery = new BasicDBObject().append("_id",doc.getId().get$oid());
              
              coll.update(searchQuery, updatedoc);
            
            }
    }
}
    
