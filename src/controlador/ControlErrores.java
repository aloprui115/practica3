package controlador;

import java.time.LocalDate;
import javax.swing.JLabel;
import java.awt.Color;

public class ControlErrores {
    
    public static boolean validarFecha(LocalDate fecha, JLabel error) {

    if (fecha == null || fecha.getYear() < 1900 || fecha.getYear() > 2015) {
        error.setText("La fecha debe estar entre 1900 y 2015");
        error.setForeground(Color.RED);
        return false;
    }

    error.setText("");
    return true;
    }
    
    public static boolean validarPuntos(float puntos, JLabel error) {

    if (puntos < 0 || puntos > 1000) {
        error.setText("Los puntos deben estar entre 0 y 1000");
        error.setForeground(Color.RED);
        return false;
    }

    error.setText("");
    return true;
    }
}
