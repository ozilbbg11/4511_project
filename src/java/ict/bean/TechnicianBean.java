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
public class TechnicianBean implements Serializable{
    
    private String uid;
    private String pwd;
    private String name;
    private String email;
    private String rank;

    public TechnicianBean() {
    }

    public TechnicianBean(String uid, String pwd, String name, String email, String rank) {
        this.uid = uid;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.rank = rank;
    }

    
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    
    
}
