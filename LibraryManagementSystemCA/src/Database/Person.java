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
public class Person {
    
    public int person_id;
    public String person_name;
    public String email;
    public String address;
     
    public Person(String person_name, String email, String address){
        this.person_name=person_name;
        this.email=email;
        this.address=address;
    }
    
    public void insertPerson(Connection con) throws SQLException {
        String sql = "insert into person values(null, ?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, person_name);
        ps.setString(2, email);
        ps.setString(3, address);
        ps.executeUpdate();
        ps.close();
               
    }
    
    public void getPerson(Connection con) throws SQLException  {
        String sql = "select * from person;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
        }
        rs.close();
        ps.close();
    }
}
