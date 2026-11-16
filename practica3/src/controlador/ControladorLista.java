package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import modelo.Cliente;

/**
 *
 * @author erlop
 */
public class ControladorLista extends ArrayList<Cliente>{
    private int actual;
    
    public ControladorLista(){
        this.add(new Cliente(104,"Carlos Gómez",500.5f,LocalDate.of(2011,5,12)));
        this.add(new Cliente(101, "Ana López", 320.0f, LocalDate.of(2001, 11, 28)));
        this.add(new Cliente(105, "Luis Martínez", 450.0f, LocalDate.of(2005, 2, 14)));
        this.add(new Cliente(102, "María Rodríguez", 890.0f, LocalDate.of(2002, 8, 5)));
        ordenarPorNumero();
        actual = 0;
    }
    
    public void ordenarPorNumero(){
        Collections.sort(this);
    }
    
    public boolean estaVacia(){
        return this.isEmpty();
    }
    
    public boolean esPrimero(){
        return actual == 0 && !estaVacia();
    }
    
    public boolean esUltimo(){
        return actual == this.size()-1 && !estaVacia();
    }
    
    public void avanzar(){
        if (!estaVacia() && !esUltimo()){
            actual++;
        }
    }
    
    public void retroceder(){
        if (!estaVacia() && !esPrimero()){
            actual--;
        }
    }
    
    public void irPrimero(){
        if (!estaVacia())
            actual = 0;
    }
    
    public void irUltimo() {
        if (!estaVacia())
            actual = this.size()-1;
    }
    
    public Cliente obtenerClienteActual(){
        if (estaVacia() || actual < 0 || actual >= this.size()){
            return null;
        }
        
        return this.get(actual);
    }
    
    public void anadirCliente(Cliente c){
        this.add(c);
        ordenarPorNumero();
        actual = this.indexOf(c);
    }
    
    public void borrarCliente(){
        if (!estaVacia()){
            this.remove(actual);
            if (estaVacia()){
                actual = -1;
            } else if (actual >= this.size()){
                actual = this.size()-1;
            }
        }
    }
}
