/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.InventoryBean;
import ict.bean.RecordBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author raymo
 */
public class RecordDB {
    private String url = "";
    private String username = "";
    private String password = "";
    
    public RecordDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }
    public void createTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();  // the connection 
            stmnt = cnnct.createStatement();  // create statement
            String sql = "CREATE  TABLE  RECORD  ("
                    + "record_id  VARCHAR(20)  CONSTRAINT  PK_RECORD  PRIMARY  KEY,  "
                    + "sid  VARCHAR(20) CONSTRAINT sid_FK REFERENCES STUDENT ON DELETE CASCADE ON UPDATE RESTRICT,  i_id  VARCHAR(20) CONSTRAINT i_id_FK REFERENCES INVENTORY ON DELETE CASCADE ON UPDATE RESTRICT, due_date DATE, status VARCHAR(10))";
            stmnt.execute(sql);

            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean addRecord(String record_id, String sid, String i_id, String due_date, String status) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = 
                    "INSERT  INTO  RECORD  VALUES  (?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, record_id);
            pStmnt.setString(2, sid);
            pStmnt.setString(3, i_id);
            pStmnt.setString(4, due_date);
            pStmnt.setString(5, status);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public int delRecord(String record_id, String i_id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM RECORD WHERE record_id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, record_id);
            int rs = pStmnt.executeUpdate();
            preQueryStatement = "UPDATE INVENTORY SET availability=?  WHERE i_id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "available");
            pStmnt.setString(2, i_id);
            rs = pStmnt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return 0;
    }
    
    public int editRecord(RecordBean cb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE RECORD SET due_date=?, status=?  WHERE record_id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, cb.getDue_date());
            pStmnt.setString(2, cb.getStatus());
            pStmnt.setString(3, cb.getRecord_id());
            //Statement s = cnnct.createStatement();
            int rs = pStmnt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return 0;
    }
    
    public int dropTable() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DROP TABLE RECORD";
            Statement s = cnnct.createStatement();
            int rs = s.executeUpdate(preQueryStatement);
            return rs;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return 0;
    }
    
    public ArrayList queryCust() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  RECORD";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                RecordBean sb = new RecordBean();
                sb.setRecord_id(rs.getString(1));
                sb.setSid(rs.getString(2));
                sb.setI_id(rs.getString(3));
                sb.setDue_date(rs.getString(4));
                sb.setStatus(rs.getString(5));
                list.add(sb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public ArrayList<RecordBean> queryCustByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        ArrayList<RecordBean> list = new ArrayList();
        RecordBean cb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT RECORD.RECORD_ID, RECORD.SID ,RECORD.I_ID, RECORD.DUE_DATE , RECORD.STATUS, EQUIPMENT.\"NAME\", EQUIPMENT.DESCRIPTION   FROM  INVENTORY,EQUIPMENT,RECORD WHERE INVENTORY.E_ID = EQUIPMENT.E_ID AND RECORD.I_ID = INVENTORY.I_ID AND RECORD.SID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setString(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                // set the record detail to the customer bean
                cb = new RecordBean();
                cb.setRecord_id(rs.getString(1));
                cb.setSid(rs.getString(2));
                cb.setI_id(rs.getString(3));
                cb.setDue_date(rs.getString(4));
                cb.setStatus(rs.getString(5));
                cb.setName(rs.getString(6));
                cb.setDescription(rs.getString(7));
                list.add(cb);
            }
            pStmnt.close();
            cnnct.close();
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
