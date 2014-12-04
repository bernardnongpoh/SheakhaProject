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
public class Address {
    
    private String school_name;
    private String vill_name;
    private String block_name;
    private String district_name;
    private String pin_code;

//    public Address(String school_name, String vill_name, String block_name, String district_name, String pin_code) {
//        this.school_name = school_name;
//        this.vill_name = vill_name;
//        this.block_name = block_name;
//        this.district_name = district_name;
//        this.pin_code = pin_code;
//    }
    public Address(){}

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getVill_name() {
        return vill_name;
    }

    public void setVill_name(String vill_name) {
        this.vill_name = vill_name;
    }

    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }
    
    
    
    
    
}
