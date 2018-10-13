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
public class Book {

    
    public static void insertBook(String bookName, String ISBN, String author, String publisher, Connection con) throws SQLException {
        String sql = "insert into book values(null, ?, ?, ?, ?);";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bookName);
            ps.setString(2, ISBN);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.executeUpdate();
        }
               
    }
    
    public void getBook(Connection con) throws SQLException  {
        String sql = "select * from book;";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }
            rs.close();
        }
    }
    
}