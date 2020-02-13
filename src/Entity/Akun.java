/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Galang Sri Nalendra
 */
public class Akun {
    protected String nama;
    protected String username;
    protected String password;

    public Akun(){};
    
    public Akun(String nama, String username, String password){
       // this.id=id;
        this.nama=nama;
        this.username=username;
        this.password=password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}