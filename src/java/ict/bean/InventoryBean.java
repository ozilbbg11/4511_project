/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

/**
 *
 * @author raymo
 */
public class InventoryBean {

    String i_id;
    String e_id;
    String availability;
    String name;
    String description;

    public InventoryBean() {
    }

    public InventoryBean(String i_id, String availability) {
        this.i_id = i_id;
        this.availability = availability;
    }

    public InventoryBean(String i_id, String e_id, String availability) {
        this.i_id = i_id;
        this.e_id = e_id;
        this.availability = availability;
    }

    public InventoryBean(String i_id, String e_id, String availability, String name, String description) {
        this.i_id = i_id;
        this.e_id = e_id;
        this.availability = availability;
        this.name = name;
        this.description = description;
    }

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
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

}
