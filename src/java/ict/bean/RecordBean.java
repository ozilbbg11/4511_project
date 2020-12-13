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
public class RecordBean {

    String record_id;
    String sid;
    String i_id;
    String e_id;
    String name;
    String description;
    String due_date;
    String status;

    public RecordBean() {
    }

    public RecordBean(String record_id, String sid, String i_id, String due_date, String status) {
        this.record_id = record_id;
        this.sid = sid;
        this.i_id = i_id;
        this.due_date = due_date;
        this.status = status;
    }

    public RecordBean(String record_id, String sid, String i_id, String e_id, String name, String description, String due_date, String status) {
        this.record_id = record_id;
        this.sid = sid;
        this.i_id = i_id;
        this.e_id = e_id;
        this.name = name;
        this.description = description;
        this.due_date = due_date;
        this.status = status;
    }
    

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}
