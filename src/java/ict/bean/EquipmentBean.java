/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

/**
 *
 * @author raymo
 */
public class EquipmentBean implements Serializable{
    private String e_id;
    private String name;
    private String description;
    private int usage;

    public EquipmentBean() {
    }

    public EquipmentBean(String e_id, String name, String description, int usage) {
        this.e_id = e_id;
        this.name = name;
        this.description = description;
        this.usage = usage;
    }

    
    
    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }
    
    
}
