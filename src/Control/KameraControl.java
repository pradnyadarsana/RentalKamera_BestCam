/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.KameraDAO;
import Entity.Kamera;
import java.util.List;
/**
 *
 * @author Smith
 */
public class KameraControl {
    KameraDAO KD = new KameraDAO();
    
    public void insertKamera(Kamera K)
    {
        KD.makeConnection();
        KD.insertKamera(K);
        KD.closeConnection();
    }
    
    public void editKamera(Kamera K, String nama){
        KD.makeConnection();
        KD.editKamera(K, nama);
        KD.closeConnection();
    }
    
    public void deleteKamera(String nama){
        KD.makeConnection();
        KD.deleteKamera(nama);
        KD.closeConnection();
    }
    
    public List<Kamera> showDataKamera(){
        KD.makeConnection();
        List<Kamera> userData = KD.showKamera();
        KD.closeConnection();
        
        return userData;
    }
    
    public Kamera searchKamera(String nama){
        Kamera km = null;
        KD.makeConnection();
        km = KD.searchKamera(nama);
        KD.closeConnection();
        
        return km;
    }
}
