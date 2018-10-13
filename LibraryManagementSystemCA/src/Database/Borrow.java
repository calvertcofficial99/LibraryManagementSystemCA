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
public class Borrow {
    
    public int borrow_id;
    public int person_id;
    public int book_id;
    public String borrowed_on;

    
    public void insertBorrow(Connection con) throws SQLException {
        String sql = "insert into borrow values(null, ?, ?, null);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, person_id);
        ps.setInt(2, book_id);
        ps.executeUpdate();
        ps.close();
               
    }
    
    public void getBorrow(Connection con) throws SQLException  {
        String sql = "select * from borrow;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getInt(2));
            System.out.println(rs.getString(3));
        }
        rs.close();
        ps.close();
    }
}
