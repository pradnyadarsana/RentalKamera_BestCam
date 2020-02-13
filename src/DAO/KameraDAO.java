/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Kamera;
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
public class KameraDAO {
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
    
    public void insertKamera(Kamera K){
        String sql = "insert into KAMERA (NamaKamera,Jumlah,Harga)"
                     +"values('"+K.getNama()+"','"+K.getJumlah()+"','"+K.getHarga()+"')";
        
        System.out.println("Adding Kamera...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added"+result+"Kamera\n");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding kamera...");
            System.out.println(e);
        }
    }
    
    public void editKamera(Kamera K, String nama){
        String sql = "UPDATE KAMERA SET Jumlah = '"+K.getJumlah()+"', Harga='"+K.getHarga()+"' where NamaKamera = '"+nama+"'";
        
        System.out.println("Editing kamera...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit "+result+" Kamera\n"+nama);
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing kamera...");
            System.out.println(e);
        }
    }
    
    public void deleteKamera(String nama){
        String sql = "DELETE FROM KAMERA where NamaKamera = '"+nama+"'";
        System.out.println("Deleting kamera...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete "+result+" Kamera\n");
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting kamera...");
            System.out.println(e);
        }
    }
    
    public Kamera searchKamera(String nama){
        String sql="SELECT * FROM KAMERA where NamaKamera = '"+nama+"'";
        System.out.println("Searching kamera...");
        
        Kamera k = null;
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    k = new Kamera(rs.getString("NamaKamera"), Integer.parseInt(rs.getString("Jumlah")),
                            Integer.parseInt(rs.getString("Harga")));
                }
            }
            System.out.println("Searching Kamera success!");
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        return k;
    }
    
    public List<Kamera> showKamera() {
        String sql="select * from KAMERA";
        System.out.println("Daftar kamera...");
        
        List<Kamera> list = new ArrayList<>();
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Kamera k = new Kamera(rs.getString("NamaKamera"),Integer.parseInt(rs.getString("Jumlah")),
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
