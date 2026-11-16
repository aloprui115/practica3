/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author erlop
 */
public class Validaciones {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static boolean comprobarFecha(String textofecha){
        try {
            LocalDate fecha = LocalDate.parse(textofecha,FORMATO);
            return fecha.getYear() >= 1900 && fecha.getYear() <= 2015;
        } catch (DateTimeException e) {
            return false;
        }
    }
    
    public static LocalDate convertirFecha(String textofecha){
        return LocalDate.parse(textofecha, FORMATO);
    }
    
    public static boolean comprobarPuntos(String textoPuntos){
        try {
            float puntos = Float.parseFloat(textoPuntos);
            return puntos >= 0 && puntos <= 1000;
        } catch (NumberFormatException e){
            return false;
        }
    }
    
    public static boolean comprobarNumero(String textoNumero){
        try {
            Integer.parseInt(textoNumero);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    
    
}
