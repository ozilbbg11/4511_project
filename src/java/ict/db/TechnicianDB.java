/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.TechnicianBean;
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
public class TechnicianDB {
    private String url = "";
    private String username = "";
    private String password = "";
    
    public TechnicianDB(String url, String username, String password) {
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
            String sql = "CREATE  TABLE  TECHNICIAN  ("
                    + "uid  VARCHAR(20)  CONSTRAINT  PK_TECHNICIAN  PRIMARY  KEY,  "
                    + "pwd  VARCHAR(20),  name  VARCHAR(20),  email  VARCHAR(50), rank VARCHAR(10))";
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
    
    
    public boolean addRecord(String uid, String pwd, String name, String email, String rank) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = 
                    "INSERT  INTO  TECHNICIAN  VALUES  (?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, uid);
            pStmnt.setString(2, pwd);
            pStmnt.setString(3, name);
            pStmnt.setString(4, email);
            pStmnt.setString(5, rank);
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
    
    public int delRecord(String uid) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM TECHNICIAN WHERE uid=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, uid);


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
    
    public int editRecord(TechnicianBean cb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE TECHNICIAN SET pwd=? ,name=? ,email=? ,rank=? WHERE uid=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, cb.getPwd());
            pStmnt.setString(2, cb.getName());
            pStmnt.setString(3, cb.getEmail());
            pStmnt.setString(4, cb.getRank());
            pStmnt.setString(5, cb.getUid());
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
            String preQueryStatement = "DROP TABLE TECHNICIAN";
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
            String preQueryStatement = "SELECT * FROM  TECHNICIAN";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                TechnicianBean tb = new TechnicianBean();
                tb.setUid(rs.getString(1));
                tb.setPwd(rs.getString(2));
                tb.setName(rs.getString(3));
                tb.setEmail(rs.getString(4));
                tb.setRank(rs.getString(5));
                list.add(tb);
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
    
    public TechnicianBean isValidUser(String sid, String pwd, String rank){
        //boolean isValid = false;
        TechnicianBean tb = new TechnicianBean();
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM TECHNICIAN WHERE uid=? and pwd=? and rank=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, sid);
            pStmnt.setString(2, pwd);
            pStmnt.setString(3, rank);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            
            if(rs.next()){
                //isValid = true;
                tb.setUid(rs.getString(1));
                tb.setPwd(rs.getString(2));
                tb.setName(rs.getString(3));
                tb.setEmail(rs.getString(4));
                tb.setRank(rs.getString(5));
            }
            
            pStmnt.close();
            cnnct.close();
        }catch(SQLException ex){
            while(ex !=null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        return tb;
    }
    
    public TechnicianBean queryCustByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        TechnicianBean cb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  TECHNICIAN WHERE uid=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setString(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                cb = new TechnicianBean();
                // set the record detail to the customer bean
                cb = new TechnicianBean();
                cb.setUid(rs.getString(1));
                cb.setPwd(rs.getString(2));
                cb.setName(rs.getString(3));
                cb.setEmail(rs.getString(4));
                cb.setRank(rs.getString(5));
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
        return cb;
    }
    
}
