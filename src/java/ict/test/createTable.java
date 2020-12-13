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
 
/**
 *
 * @author raymo
 */
public class createTable {
    
    
    public static void main(String[] arg){
      
        String url = DbMetaInfo.url;
        String username = DbMetaInfo.username;
        String password = DbMetaInfo.password;
        StudentDB stuDB = new StudentDB(url, username, password);
        stuDB.createTable();
        
        TechnicianDB techDB = new TechnicianDB(url, username, password);
        techDB.createTable();
        
        EquipmentDB equipDB = new EquipmentDB(url, username, password);
        equipDB.createTable();
        
        InventoryDB invenDB = new InventoryDB(url, username, password);
        invenDB.createTable();
        
        RecordDB reDB = new RecordDB(url, username, password);
        reDB.createTable();
        
        
    }
}
