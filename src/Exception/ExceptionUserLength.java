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
public class ExceptionUserLength extends Exception{
    public String showMessageInvalid()
    {
        return "Username harus 5-15 karakter !";
    }
}
