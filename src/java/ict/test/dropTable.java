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
public class dropTable {

    public static void main(String[] arg) {
        String url = DbMetaInfo.url;
        String username = DbMetaInfo.username;
        String password = DbMetaInfo.password;

        RecordDB reDB = new RecordDB(url, username, password);
        reDB.dropTable();
        InventoryDB invenDB = new InventoryDB(url, username, password);
        invenDB.dropTable();
        EquipmentDB equipDB = new EquipmentDB(url, username, password);
        equipDB.dropTable();

        TechnicianDB techDB = new TechnicianDB(url, username, password);
        techDB.dropTable();

        StudentDB stuDB = new StudentDB(url, username, password);
        stuDB.dropTable();

    }
}
