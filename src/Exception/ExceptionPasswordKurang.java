/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Galang Sri Nalendra
 */
public class ExceptionPasswordKurang extends Exception{
    public String showMessageKurang()
    {
        return "Password Tidak boleh kurang dari 8 digit";
    }
}
