/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Smith
 */
public class ExceptionPesananKosong extends Exception{
    public String showMessage(){
        return "Tidak ada barang yang akan disewa!";
    }
    
}
