/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.smcs.parse;

/**
 *
 * @author cs12shea8
 */
public class GeoDocument {
    private Result results=null;
    private Status status=null;
    private Geometry geometry=null;

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        if(results!=null){
        this.results = results;
        }
        }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if(status!=null){
        this.status = status;
    }
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        if(geometry!=null){
        this.geometry = geometry;
    }
    }
    
    
    
    
}
