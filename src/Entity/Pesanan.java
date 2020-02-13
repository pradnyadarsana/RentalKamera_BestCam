/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Smith
 */
public class Pesanan {
    private int id;
    private String username;
    private String namaKamera;
    private int jumlahKamera;
    private String namaLensa;
    private int jumlahLensa;
    private int lamaSewa;
    private float totalHarga;
    private int status;

    public Pesanan(String username, String namaKamera, int jumlahKamera, String namaLensa, int jumlahLensa, int lamaSewa, float totalHarga, int status) {
        this.username = username;
        this.namaKamera = namaKamera;
        this.jumlahKamera = jumlahKamera;
        this.namaLensa = namaLensa;
        this.jumlahLensa = jumlahLensa;
        this.lamaSewa = lamaSewa;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    public Pesanan(int id, String username, String namaKamera, int jumlahKamera, String namaLensa, int jumlahLensa, int lamaSewa, float totalHarga, int status) {
        this.id = id;
        this.username = username;
        this.namaKamera = namaKamera;
        this.jumlahKamera = jumlahKamera;
        this.namaLensa = namaLensa;
        this.jumlahLensa = jumlahLensa;
        this.lamaSewa = lamaSewa;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamaKamera() {
        return namaKamera;
    }

    public void setNamaKamera(String namaKamera) {
        this.namaKamera = namaKamera;
    }

    public int getJumlahKamera() {
        return jumlahKamera;
    }

    public void setJumlahKamera(int jumlahKamera) {
        this.jumlahKamera = jumlahKamera;
    }

    public String getNamaLensa() {
        return namaLensa;
    }

    public void setNamaLensa(String namaLensa) {
        this.namaLensa = namaLensa;
    }

    public int getJumlahLensa() {
        return jumlahLensa;
    }

    public void setJumlahLensa(int jumlahLensa) {
        this.jumlahLensa = jumlahLensa;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public float getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(float totalHarga) {
        this.totalHarga = totalHarga;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
