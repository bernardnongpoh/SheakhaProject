/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.smcs.utility;

import org.smcs.model.Location;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author cs12shea8
 */
public class Utility {

    
    public static Location getCoordinate(String address) throws MalformedURLException, IOException{
        Location location=null;
        String url= "http://maps.google.com/maps/api/geocode/json?address="+address+"&sensor=false" ;
        URL loc = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(loc.openStream()));
        StringBuilder str = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null){
        str.append(inputLine);
        }
        JsonParser parser = new JsonParser();
        JsonObject rootObj = parser.parse(str.toString()).getAsJsonObject();
        String status = rootObj.get("status").getAsString();
        
        if(status.equals("OK")){
             location=new Location();
              JsonObject res = parser.parse(str.toString()).getAsJsonObject();
             // System.out.println(res.toString());
              JsonObject s=res.get("results").getAsJsonArray().get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject();
              //System.out.println(s.toString());
              String lat=s.get("lat").getAsString();
              String lng=s.get("lng").getAsString();
              
              //System.out.println(lat);
             // System.out.println(lng);
              location.setLat(Double.parseDouble(lat));
              location.setLng(Double.parseDouble(lng));
             
        }
       
        in.close();
        return location;
    }
}
