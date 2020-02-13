/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Galang Sri Nalendra
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;
import Entity.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class PenggunaDAO {
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "D:"+File.separator+"DB_rentalkamera.mdb";
    private Connection con;
    
    public PenggunaDAO(){}
    public void makeConnection(){
        System.out.println("Opening database...");
        try{
            con = DriverManager.getConnection(url + path);
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
    
    public void createPengguna(Pengguna P){
        if(P.getNama().equals("")){
            System.out.println("Tidak boleh kosong.");
        }else{
            String sql = "INSERT INTO AKUN_PENGGUNA(Username,Nama,Password,Umur,Telepon,Email,Alamat) VALUES ('" + P.getUsername() + "','" + P.getNama() + "','" + P.getPassword() + "','" + P.getUmur() + "','" + P.getTelepon() + "','" + P.getEmail() + "','" + P.getAlamat() +"')";
            //makeConnection();
            System.out.println(sql);
            System.out.println("Nambah pengguna...");
            try{
                Statement statement = con.createStatement();
                int result = statement.executeUpdate(sql);
                System.out.println("Added " + result + " pengguna\n");
                statement.close();
            }catch(Exception ex){
                System.out.println("Error Nambah pengguna lur...");
                System.out.println(ex);
            }
            //closeConnection();
        }
    }
    
    public Pengguna searchPengguna(String username){
        String sql="SELECT * FROM AKUN_PENGGUNA where Username = '"+username+"'";
        System.out.println("Searching pengguna..");
        
        Pengguna pny = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    pny = new Pengguna(rs.getString("Username"), rs.getString("Nama"),
                                rs.getString("Password"), Integer.parseInt(rs.getString("Umur")),
                                rs.getString("Telepon"), rs.getString("Email"),rs.getString("Alamat"));    
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database..");
            System.out.println(e);
        }
        return pny;
    }
    
    public void updatePengguna(Pengguna P, String username) {
        
        String sql = "UPDATE AKUN_PENGGUNA SET Nama = '"+P.getNama()+"',Password = '"+P.getPassword()
                +"',Umur = "+P.getUmur()+",Telepon = '"+P.getTelepon()+"',Email = '"+P.getEmail()
                +"',Alamat = '"+P.getAlamat()+"' WHERE Username = '"+username+"'";       
        //System.out.println(sql);
        //makeConnection();
        System.out.println(sql);
        try {
           Statement statement = con.createStatement();
           int result = statement.executeUpdate(sql);
            statement.close();
        }
        catch (Exception ex) {
            System.out.println("Error updating pengguna ...\n");
            System.out.println(ex);
        }
        //closeConnection();
    }
    
    public void deletePengguna(String username) {
        
        String sql = "DELETE FROM AKUN_PENGGUNA WHERE Username = '" + username + "'";
        //makeConnection();
        System.out.println(sql);
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            statement.close();
        }
        catch (Exception ex) {
            System.out.println("Error deleting pengguna...\n");
            System.out.println(ex);
        }
        //closeConnection();
    }
    
    public boolean cekPengguna(String username) {
        boolean temp = false;
        String sql = "SELECT Username FROM AKUN_PENGGUNA";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("Username").toString().compareTo(username) == 0) {
                        temp = true;
                    }
                }
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error reading database information...\n");
            System.out.println(e);
        }
        return temp;
    }
    
    public Pengguna cekLogin(String username, String password) {
        Pengguna temp = null;
        String sql = "SELECT * FROM AKUN_PENGGUNA WHERE Username = '"+username+"' AND Password = '"+password+"'";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                        temp = new Pengguna(rs.getString("Username"),rs.getString("Nama"),rs.getString("Password"),Integer.parseInt(rs.getString("Umur")),rs.getString("Telepon"),rs.getString("Email"),rs.getString("Alamat"));
                }
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error reading database information...\n");
            System.out.println(e);
        }
        return temp;
    }
}
