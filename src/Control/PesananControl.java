/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.PesananDAO;
import Entity.Pesanan; 
import java.util.List;
/**
 *
 * @author Smith
 */
public class PesananControl {
    PesananDAO KD = new PesananDAO();
    
    public void insertPesanan(Pesanan K)
    {
        KD.makeConnection();
        KD.insertPesanan(K);
        KD.closeConnection();
    }
    
    public void editPesananPengguna(Pesanan K, String nama, int id){
        KD.makeConnection();
        KD.editPesananPengguna(K, nama, id);
        KD.closeConnection();
    }
    
    public void editPesananAdmin(Pesanan K, String nama, int id){
        KD.makeConnection();
        KD.editPesananAdmin(K, nama, id);
        KD.closeConnection();
    }
    
    public void deletePesananPengguna(String nama, int id){
        KD.makeConnection();
        KD.deletePesananPengguna(nama, id);
        KD.closeConnection();
    }
    
    public List<Pesanan> showPesanan(){
        KD.makeConnection();
        List<Pesanan> userData = KD.showPesanan();
        KD.closeConnection();
        
        return userData;
    }
    
    public List<Pesanan> showPesananUser(String username){
        KD.makeConnection();
        List<Pesanan> userData = KD.showPesananUser(username);
        KD.closeConnection();
        
        return userData;
    }
    
    public Pesanan searchPesananAdmin(int id){
        Pesanan km = null;
        KD.makeConnection();
        km = KD.searchPesananAdmin(id);
        KD.closeConnection();
        
        return km;
    }
}
