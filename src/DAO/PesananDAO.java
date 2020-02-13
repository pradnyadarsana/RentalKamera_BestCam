/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Pesanan;
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
public class PesananDAO {
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
    
    public void insertPesanan(Pesanan P){
        String sql = "insert into PESANAN (Username,NamaKamera,JumlahKamera,NamaLensa,JumlahLensa,LamaSewa,TotalHarga,Status)"
                     +"values('"+P.getUsername()+"','"+P.getNamaKamera()+"','"+
                    P.getJumlahKamera()+"','"+P.getNamaLensa()+"','"+P.getJumlahLensa()+
                    "','"+P.getLamaSewa()+"','"+P.getTotalHarga()+"','0')";
        
        System.out.println("Adding Pesanan...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Pesanan\n");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Pesanan...");
            System.out.println(e);
        }
    }
    
    public void editPesananPengguna(Pesanan P, String username, int id){
        String sql = "UPDATE PESANAN SET NamaKamera = '"+P.getNamaKamera()+"', JumlahKamera='"
                +P.getJumlahKamera()+"', NamaLensa='"+P.getNamaLensa()+"', JumlahLensa='"
                +P.getJumlahLensa()+"', LamaSewa='"+P.getLamaSewa()+"',TotalHarga='"
                +P.getTotalHarga()+"'WHERE Username = '"+username+"' AND ID = "+id+" AND Status = 0";
        
        System.out.println("Editing Pesanan...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit "+result+" Pesanan\n"+username);
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing pesanan...");
            System.out.println(e);
        }
    }
    
    public void editPesananAdmin(Pesanan P, String username, int id){
        String sql = "UPDATE PESANAN SET Status = 1 WHERE Username = '"+username+"' AND ID = "+id+" AND Status = 0";
        
        System.out.println("Editing Pesanan...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit "+result+" Pesanan\n"+username);
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing pesanan...");
            System.out.println(e);
        }
    }
    
    public void deletePesananPengguna(String username, int id){
        String sql = "DELETE FROM PESANAN where Username = '"+username+"' AND ID = '"+id+"' AND Status = 0";
        System.out.println("Deleting pesanan...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete "+result+" Pesanan\n");
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting pesanan...");
            System.out.println(e);
        }
    }
    
    public Pesanan searchPesananAdmin(int id){
        String sql="SELECT * FROM PESANAN WHERE ID = '"+id+"'";
        System.out.println("Searching pesanan...");
        
        Pesanan pes = null;
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    pes = new Pesanan(Integer.parseInt(rs.getString("ID")), rs.getString("Username"),
                            rs.getString("NamaKamera"), Integer.parseInt(rs.getString("JumlahKamera")), 
                            rs.getString("NamaLensa"), Integer.parseInt(rs.getString("JumlahLensa")), 
                            Integer.parseInt(rs.getString("LamaSewa")),Integer.parseInt(rs.getString("TotalHarga")), 
                            Integer.parseInt(rs.getString("Status")));
                }
            }
            System.out.println("Searching Pesanan success!");
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        return pes;
    }
    
    public List<Pesanan> showPesanan() {
        String sql="select * from PESANAN";
        System.out.println("Daftar pesanan...");
        
        List<Pesanan> list = new ArrayList<>();
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Pesanan pes = new Pesanan(Integer.parseInt(rs.getString("ID")), rs.getString("Username"),
                            rs.getString("NamaKamera"), Integer.parseInt(rs.getString("JumlahKamera")), 
                            rs.getString("NamaLensa"), Integer.parseInt(rs.getString("JumlahLensa")), 
                            Integer.parseInt(rs.getString("LamaSewa")),Integer.parseInt(rs.getString("TotalHarga")), 
                            Integer.parseInt(rs.getString("Status")));
                    list.add(pes);
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
    
    public List<Pesanan> showPesananUser(String username) {
        String sql="select * from PESANAN where Username = '"+username+"'";
        System.out.println("Daftar pesanan penyewa...");
        
        List<Pesanan> list = new ArrayList<>();
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Pesanan pes = new Pesanan(Integer.parseInt(rs.getString("ID")), rs.getString("Username"),
                            rs.getString("NamaKamera"), Integer.parseInt(rs.getString("JumlahKamera")), 
                            rs.getString("NamaLensa"), Integer.parseInt(rs.getString("JumlahLensa")), 
                            Integer.parseInt(rs.getString("LamaSewa")),Integer.parseInt(rs.getString("TotalHarga")), 
                            Integer.parseInt(rs.getString("Status")));
                    list.add(pes);
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
