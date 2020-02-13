/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import Entity.*;
/**
 *
 * @author Smith
 */
public class AdminDAO {
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "D:"+File.separator+"DB_rentalkamera.mdb";
    private Connection con;
    
    public void makeConnection(){
        System.out.println("Opening database...");
        try{
            con = DriverManager.getConnection(url+path);
            System.out.println("Success!\n");
        } catch(Exception ex){
            System.out.println("Error opening the database...");
            System.out.println(ex);
        }
    }
    
    public void closeConnection(){
        System.out.println("Closing database...");
        try{
            con.close();
            System.out.println("Success !\n");
        }catch(Exception ex){
            System.out.println("Error Closing the database...");
            System.out.println(ex);
        }
    }
    
    public Admin searchAdmintoShow(String username){
        String sql="SELECT*FROM AKUN_ADMIN where Username = '"+username+"'";
        System.out.println("Searching Admin Account...");
        
        Admin ad = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    ad = new Admin(rs.getString("Nama"),rs.getString("Username"),rs.getString("Password"));
                }
            }
            System.out.println("Searching Admin Success!");
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        return ad;
    }
    
    public Admin searchAdmin(String username, String password){
        String sql="SELECT*FROM AKUN_ADMIN where Username = '"+username+"' Password = '"+password+"'";
        System.out.println("Searching Admin Account...");
        
        Admin ad = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    ad = new Admin(rs.getString("Nama"),rs.getString("Username"),rs.getString("Password"));
                }
            }
            System.out.println("Searching Admin Success!");
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        return ad;
    }
    
    public Admin cekLogin(String username, String password)
    {
        String sql="SELECT*FROM AKUN_ADMIN WHERE Username = '"+username+"' AND Password = '"+password+"'";
        System.out.println("Searching Admin Account...");
        
        Admin ad = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    ad = new Admin(rs.getString("Nama"),rs.getString("Username"),rs.getString("Password"));
                }
            }
            System.out.println("Searching Admin Success!");
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Opening Database...");
            System.out.println(e);
        }
        return ad;
    }
    
}
