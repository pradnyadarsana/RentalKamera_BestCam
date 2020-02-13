/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.LensaDAO;
import Entity.Lensa;
import java.util.List;

/**
 *
 * @author Smith
 */
public class LensaControl {
    LensaDAO KD = new LensaDAO();
    
    public void insertLensa(Lensa K)
    {
        KD.makeConnection();
        KD.insertLensa(K);
        KD.closeConnection();
    }
    
    public void editLensa(Lensa K, String nama){
        KD.makeConnection();
        KD.editLensa(K, nama);
        KD.closeConnection();
    }
    
    public void deleteLensa(String nama){
        KD.makeConnection();
        KD.deleteLensa(nama);
        KD.closeConnection();
    }
    
    public List<Lensa> showDataLensa(){
        KD.makeConnection();
        List<Lensa> userData = KD.showLensa();
        KD.closeConnection();
        
        return userData;
    }
    
    public Lensa searchLensa(String nama){
        Lensa km = null;
        KD.makeConnection();
        km = KD.searchLensa(nama);
        KD.closeConnection();
        
        return km;
    }
}
