/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.AdminDAO;
import Entity.Admin;

/**
 *
 * @author Smith
 */
public class AdminControl {
    AdminDAO AD = new AdminDAO();
    
    public Admin searchAdmin(String username){
        Admin p = null;
        AD.makeConnection();
        p = AD.searchAdmintoShow(username);
        AD.closeConnection();
        
        return p;
    }
    
    public Admin cekLogin(String username, String password)
    {
        AD.makeConnection();
        Admin ad = AD.cekLogin(username, password);
        AD.closeConnection();
        return ad;
    }
}
