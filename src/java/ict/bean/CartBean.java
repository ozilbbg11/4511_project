/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raymo
 */
public class CartBean implements Serializable{

    String customerId;
    ArrayList<String> contents;
    
    public void initialize(String person) {
        customerId = person;
        contents = new ArrayList<String>();
    }
    
    public void addCart(String i_id) {
        contents.add(i_id);
    }
    
    public void removeCart(String i_id){
        boolean result = contents.remove(i_id);
        if (result == false) {
        }
    }
    
    public ArrayList<String> getContents() {
        return contents;
    }

    public void remove() {
        contents = null;
    }
}
