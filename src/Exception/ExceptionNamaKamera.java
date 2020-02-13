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
public class ExceptionNamaKamera extends Exception{
    public String showMessageInvalid()
    {
        return "Nama kamera harus 3-15 karakter !";
    }
}
