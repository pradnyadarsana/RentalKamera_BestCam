/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Lensa;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Smith
 */
public class LensaDAO {
    public static Connection CON;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "D:"+File.separator+"DB_rentalkamera.mdb";
    
    public void makeConnection(){
        System.out.println("Opening database...");
        try{
            CON = DriverManager.getConnection(url+path);
            System.out.println("Success!");
        }catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
    }
    
    public void closeConnection(){
        System.out.println("Closing database...");
        try{
            CON.close();;
            System.out.println("Success!");
        }catch(Exception e){
            System.out.println("Error closing database...");
            System.out.println(e);
        }
    }
    
    public void insertLensa(Lensa K){
        String sql = "insert into LENSA (NamaLensa,Jumlah,Harga)"
                     +"values('"+K.getNama()+"','"+K.getJumlah()+"','"+K.getHarga()+"')";
        
        System.out.println("Adding Lensa...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added"+result+"Lensa\n");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding lensa...");
            System.out.println(e);
        }
    }
    
    public void editLensa(Lensa K, String nama){
        String sql = "UPDATE LENSA SET Jumlah = '"+K.getJumlah()+"', Harga='"+K.getHarga()+"' where NamaLensa = '"+nama+"'";
        
        System.out.println("Editing lensa...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit "+result+" Lensa\n"+nama);
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing lensa...");
            System.out.println(e);
        }
    }
    
    public void deleteLensa(String nama){
        String sql = "DELETE FROM LENSA where NamaLensa = '"+nama+"'";
        System.out.println("Deleting lensa...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete "+result+" Lensa\n");
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting lensa...");
            System.out.println(e);
        }
    }
    
    public Lensa searchLensa(String nama){
        String sql="SELECT * FROM LENSA where NamaLensa = '"+nama+"'";
        System.out.println("Searching Lensa...");
        
        Lensa k = null;
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    k = new Lensa(rs.getString("NamaLensa"), Integer.parseInt(rs.getString("Jumlah")),
                            Integer.parseInt(rs.getString("Harga")));
                }
            }
            System.out.println("Searching Lensa success!");
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        return k;
    }
    
    public List<Lensa> showLensa() {
        String sql="select * from LENSA";
        System.out.println("Daftar Lensa...");
        
        List<Lensa> list = new ArrayList<>();
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Lensa k = new Lensa(rs.getString("NamaLensa"),Integer.parseInt(rs.getString("Jumlah")),
                                    Integer.parseInt(rs.getString("Harga")));
                    list.add(k);
                }
            }
            System.out.println("Success reading database..");
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database..");
            System.out.println(e);
        }
        return list;
    }
}
