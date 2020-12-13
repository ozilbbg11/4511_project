/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.bean.EquipmentBean;
import ict.bean.InventoryBean;
import ict.bean.RecordBean;
import java.util.ArrayList;
import ict.bean.StudentBean;
import ict.bean.TechnicianBean;
import ict.db.EquipmentDB;
import ict.db.InventoryDB;
import ict.db.RecordDB;
import ict.db.StudentDB;
import ict.db.TechnicianDB;
/**
 *
 * @author raymo
 */
public class queryRecord {
    public static void main(String[] arg) {

        String url = DbMetaInfo.url;
        String username = DbMetaInfo.username;
        String password = DbMetaInfo.password;

//        StudentDB stuDB = new StudentDB(url, username, password);
//        ArrayList<StudentBean> list = stuDB.queryCust();
//
//        for (int i = 0; i < list.size(); i++) {
//            StudentBean c = list.get(i);
//
//            System.out.println("SID: " + c.getSid());
//            System.out.println("pwd: " + c.getPwd());
//            System.out.println("name: " + c.getName());
//            System.out.println("email: " + c.getEmail());
//            System.out.println("=================");
//
//        }
//        
//        
//        
//        TechnicianDB techDB = new TechnicianDB(url, username, password);
//        ArrayList<TechnicianBean> list1 = techDB.queryCust();
//        for (int i = 0; i < list1.size(); i++) {
//            TechnicianBean t = list1.get(i);
//            System.out.println("UID: " + t.getUid());
//            System.out.println("pwd: " + t.getPwd());
//            System.out.println("name: " + t.getName());
//            System.out.println("email: " + t.getEmail());
//            System.out.println("rank: " + t.getRank());
//            System.out.println("=================");
//
//        }
//        
//        EquipmentDB eqyipDB = new EquipmentDB(url, username, password);
//        ArrayList<EquipmentBean> list2 = eqyipDB.queryCust();
//        for (int i = 0; i < list2.size(); i++) {
//            EquipmentBean e = list2.get(i);
//            System.out.println("e_id: " + e.getE_id());
//            System.out.println("name: " + e.getName());
//            System.out.println("description: " + e.getDescription());
//            System.out.println("usage: " + e.getUsage());
//            System.out.println("=================");
//
//        }
//        
//        InventoryDB invenDB = new InventoryDB(url, username, password);
//        ArrayList<InventoryBean> list3 = invenDB.queryCust();
//        for (int i = 0; i < list3.size(); i++) {
//            InventoryBean in = list3.get(i);
//            System.out.println("i_id: " + in.getI_id());
//            System.out.println("e_id: " + in.getE_id());
//            System.out.println("availability: " + in.getAvailability());
//            System.out.println("=================");
//
//        }
        
        RecordDB reDB = new RecordDB(url, username, password);
        ArrayList<RecordBean> list4 = reDB.queryCustByID("123");
        for (int i = 0; i < list4.size(); i++) {
            RecordBean re = list4.get(i);
            System.out.println("record_id: " + re.getRecord_id());
            System.out.println("sid: " + re.getSid());
            System.out.println("i_id: " + re.getI_id());
            System.out.println("due_date: " + re.getDue_date());
            System.out.println("status: " + re.getStatus());
            System.out.println("=================");

        }
        
    }
}
