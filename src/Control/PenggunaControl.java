/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Galang Sri Nalendra
 */
import DAO.PenggunaDAO;
import Entity.Pengguna;


public class PenggunaControl {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    PenggunaDAO PD = new PenggunaDAO();

    public void createPengguna(Pengguna P) {
        PD.makeConnection();
        PD.createPengguna(P);
        PD.closeConnection();
    }
    
    public void editPengguna(Pengguna P, String username){
        PD.makeConnection();
        PD.updatePengguna(P, username);
        PD.closeConnection();
    }
    
    public void deletePengguna(String username){
        PD.makeConnection();
        PD.deletePengguna(username);
        PD.closeConnection();
    }
    
    public Pengguna searchPengguna(String username){
        Pengguna p = null;
        PD.makeConnection();
        p = PD.searchPengguna(username);
        PD.closeConnection();
        
        return p;
    }
    
    public boolean cekUsername(String username) {
        PD.makeConnection();
        boolean tampung = PD.cekPengguna(username);
        PD.closeConnection();

        return tampung;
    }
    
    public Pengguna cekLogin(String username, String password) {
        PD.makeConnection();
        Pengguna tampung = PD.cekLogin(username,password);
        PD.closeConnection();

        return tampung;
    }
}
