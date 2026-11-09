package controlador;

import java.util.ArrayList;
import modelo.Cliente;

public class ColeccionClientes extends ArrayList<Cliente>{
    private int actual;
    
    public ColeccionClientes(){
        actual = 0;
    }
    
    public boolean esVacia() {
    return isEmpty();
    }
    
    public void avanzar() {
    if (!isEmpty() && actual < size() - 1) {
        actual++;
    }
    }
    
    public void retroceder() {
    if (!isEmpty() && actual > 0) {
        actual--;
    }
    }
    
    public void irPrimero() {
    if (!isEmpty()) {
        actual = 0;
    }
    }

    public void irUltimo() {
    if (!isEmpty()) {
        actual = size() - 1;
    }
    }
    
    public boolean esPrimero() {
    return actual == 0 && !isEmpty();
    }

    public boolean esUltimo() {
    return actual == size() - 1 && !isEmpty();
    }
    
    public Cliente obtenerActual() {
    if (isEmpty()) {
        return null;
    }

    return get(actual);
    }
    
    public void anadirCliente(Cliente cliente) {
    add(cliente);
    }
    
    public void borrarCliente() {
    if (!isEmpty()) {
        remove(actual);

        if (actual >= size() && !isEmpty()) {
            actual = size() - 1;
        }

        if (isEmpty()) {
            actual = 0;
        }
    }
    }
    
    public void ordenarPorNumero() {
    sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));
    actual = 0;
    }
}
