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
public class StudentBean implements Serializable{
    
    private String sid;
    private String pwd;
    private String name;
    private String email;
    
    public StudentBean() {
    }

    public StudentBean(String sid, String pwd, String name, String email) {
        this.sid = sid;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
    }
    
    

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
    
    
    
}
