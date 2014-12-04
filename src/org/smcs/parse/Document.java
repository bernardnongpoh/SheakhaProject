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
public class Document {
    private Id _id;
    private Address address;
    private Coordinate coordinate;
    private String region;
    private String school_category;
    private String school_management;
    private int year_estd;
    private int year_recognized;




    public Id getId() {
        return _id;
    }

    public void setId(Id _id) {
        this._id = _id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchool_category() {
        return school_category;
    }

    public void setSchool_category(String school_category) {
        this.school_category = school_category;
    }

    public String getSchool_management() {
        return school_management;
    }

    public void setSchool_management(String school_management) {
        this.school_management = school_management;
    }

    public int getYear_estd() {
        return year_estd;
    }

    public void setYear_estd(int year_estd) {
        this.year_estd = year_estd;
    }

    public int getYear_recognized() {
        return year_recognized;
    }

    public void setYear_recognized(int year_recognized) {
        this.year_recognized = year_recognized;
    }
    
    
    
    
    
    
    
}
