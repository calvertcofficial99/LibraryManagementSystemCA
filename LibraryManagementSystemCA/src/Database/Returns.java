/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rahul
 */
public class Returns {
    
    public int return_id;
    public int borrow_id;
    public String returned_on;
     
    public Returns(int borrow_id, String returned_on){
        this.borrow_id=borrow_id;
        this.returned_on=returned_on;
    }
    
    public void insertReturns(Connection con) throws SQLException {
        String sql = "insert into returns values(null, ?, null);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, borrow_id);
        ps.executeUpdate();
        ps.close();
               
    }
    
    public void getReturns(Connection con) throws SQLException  {
        String sql = "select * from returns;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }
        rs.close();
        ps.close();
    }
}
