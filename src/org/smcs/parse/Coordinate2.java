/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.smcs.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author cs12shea8
 */
public class Coordinate2 {
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        
                
        System.getProperties().put("http.proxyHost", "192.168.0.2");
        System.getProperties().put("http.proxyPort", "8080");
        System.getProperties().put("http.proxyUser", "csshea8");
        System.getProperties().put("http.proxyPassword", "belrich1994");
        


       // String address = "St Mary's College, Shillong";
        
        URL loc = new URL("http://maps.google.com/maps/api/geocode/json?address=Laitumkhrah,793003,shillong&sensor=false");
        BufferedReader in = new BufferedReader(new InputStreamReader(loc.openStream()));
        StringBuilder str = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        str.append(inputLine);
        in.close();
        
        System.out.println(str);
        
        
    }
    
}
