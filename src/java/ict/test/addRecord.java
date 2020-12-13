/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;
import ict.db.EquipmentDB;
import ict.db.InventoryDB;
import ict.db.RecordDB;
import ict.db.StudentDB;
import ict.db.TechnicianDB;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author raymo
 */
public class addRecord {

    public static void main(String[] arg) {

//        String url = DbMetaInfo.url;
//        String username = DbMetaInfo.username;
//        String password = DbMetaInfo.password;
//        StudentDB stuDB = new StudentDB(url, username, password);
//
//        boolean isAdded = stuDB.addRecord("180000001", "pwd123", "Chan Tai Man", "ctm18@vtc.hk");
//        if (isAdded) {
//            System.out.println("Chan Tai Man is added");
//        } else {
//            System.out.println("added failed");
//        }
//
//        
//        isAdded = stuDB.addRecord("180000002", "pwd123", "Chan Siu Ming", "csm18@vtc.hk");
//        if (isAdded) {
//            System.out.println("Chan Siu Ming is added");
//        } else {
//            System.out.println("added failed");
//        }
//        
//        
//        TechnicianDB techDB = new TechnicianDB(url, username, password);
//        
//        isAdded = techDB.addRecord("admin01", "pwd123", "admin01", "admin01@vtc.hk","senior");
//        if (isAdded) {
//            System.out.println("admin01 is added");
//        } else {
//            System.out.println("added failed");
//        }
//        
//        
//        EquipmentDB equipDB = new EquipmentDB(url, username, password);
//        
//        isAdded = equipDB.addRecord("ip001", "ipad", "ipad colour: black", 0);
//        if (isAdded) {
//            System.out.println("ipad is added");
//        } else {
//            System.out.println("added failed");
//        }
//        
//        InventoryDB invenDB = new InventoryDB(url, username, password);
//
//        isAdded = invenDB.addRecord("ip001001", "ip001", "available");
//        if (isAdded) {
//            System.out.println("ip001001 is added");
//        } else {
//            System.out.println("added failed");
//        }
//        
//        RecordDB reDB = new RecordDB(url, username, password);
//        Date date = new Date(new Date().getTime() + 14 * 86400000);  
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//        String strDate = formatter.format(date);  
//        
//        
//        isAdded = reDB.addRecord("00000001", "180000001", "ip001001", strDate, "reserved");
//        if (isAdded) {
//            System.out.println("00000001 is added");
//        } else {
//            System.out.println("added failed");
//        }
        for (int i = 0; i < 10; i++) {
                Date date = new Date(new Date().getTime() + 14 * 86400000);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                // 4.1 call  the database operations  db.addRecord(id, name, tel, ag
                String due_date = formatter.format(date);
                Date dNow = new Date((new Date().getTime() + i*1000));
                formatter = new SimpleDateFormat("yyMMddhhmmssMs");
                String record_id = formatter.format(dNow);
                System.out.println(due_date+"  and  "+ record_id);
        }
//
    }
}
