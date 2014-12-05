/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.smcs.parse;

import com.google.code.geocoder.AdvancedGeoCoder;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpClientParams;



/**
 *
 * @author cs12shea8
 */
public class GeoCoderTest {
    public static void main(String[] args) throws IOException {
   
HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
httpClient.getHostConfiguration().setProxy("85.25.109.152", 3128);


Geocoder geocoder = new AdvancedGeoCoder(httpClient);GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").getGeocoderRequest();
GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
        System.out.println(geocoderResponse);

       

        
        
    }
    
}
