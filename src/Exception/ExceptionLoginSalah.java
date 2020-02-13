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
public class ExceptionLoginSalah extends Exception{
    public String showMessageSalah()
    {
        return "Username dan Password tidak cocok";
    }
}
