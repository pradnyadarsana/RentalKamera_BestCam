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
public class Pengguna extends Akun{
    private int umur;
    private String email;
    private String alamat;
    private String telepon;

    public Pengguna() {}

    public Pengguna(String username, String nama, String password, int umur, String telepon, String email, String alamat) {
        super(nama, username, password);
        this.umur = umur;
        this.email = email;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public int getUmur() {
        return umur;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
