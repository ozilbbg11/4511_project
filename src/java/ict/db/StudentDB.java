/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.StudentBean;
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
public class StudentDB {
    
    private String url = "";
    private String username = "";
    private String password = "";
    
    public StudentDB(String url, String username, String password) {
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
            String sql = "CREATE  TABLE  STUDENT  ("
                    + "SID  VARCHAR(20)  CONSTRAINT  PK_STUDENT  PRIMARY  KEY,  "
                    + "pwd  VARCHAR(20),  name  VARCHAR(20),  email  VARCHAR(50))";
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
    
    public boolean addRecord(String sid, String pwd, String name, String email) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = 
                    "INSERT  INTO  STUDENT  VALUES  (?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, sid);
            pStmnt.setString(2, pwd);
            pStmnt.setString(3, name);
            pStmnt.setString(4, email);
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
    
    public int delRecord(String sid) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM STUDENT WHERE sid=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, sid);


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
    
    public int editRecord(StudentBean cb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE STUDENT SET pwd=? ,name=?, email=? WHERE sid=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, cb.getPwd());
            pStmnt.setString(2, cb.getName());
            pStmnt.setString(3, cb.getEmail());
            pStmnt.setString(4, cb.getSid());
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
            String preQueryStatement = "DROP TABLE STUDENT";
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
            String preQueryStatement = "SELECT * FROM  STUDENT";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                StudentBean sb = new StudentBean();
                sb.setSid(rs.getString(1));
                sb.setPwd(rs.getString(2));
                sb.setName(rs.getString(3));
                sb.setEmail(rs.getString(4));
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
    
    public StudentBean isValidUser(String sid, String pwd){
        //boolean isValid = false;
        StudentBean sb = new StudentBean();
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM STUDENT WHERE sid=? and pwd=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, sid);
            pStmnt.setString(2, pwd);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            
            if(rs.next()){
                //isValid = true;
                sb.setSid(rs.getString(1));
                sb.setPwd(rs.getString(2));
                sb.setName(rs.getString(3));
                sb.setEmail(rs.getString(4));
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
        return sb;
    }
    
    public StudentBean queryCustByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        StudentBean cb = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  STUDENT WHERE sid=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setString(1, id);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                cb = new StudentBean();
                // set the record detail to the customer bean
                cb = new StudentBean();
                cb.setSid(rs.getString(1));
                cb.setPwd(rs.getString(2));
                cb.setName(rs.getString(3));
                cb.setEmail(rs.getString(4));
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
