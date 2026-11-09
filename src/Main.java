import controlador.ColeccionClientes;
import controlador.ControladorClientes;
import vista.VentanaPrincipal;
import java.time.LocalDate;
import modelo.Cliente;

public class Main {

    public static void main(String[] args) {

        ColeccionClientes coleccion = new ColeccionClientes();
        
        coleccion.anadirCliente(new Cliente(3, "Carlos", 250, LocalDate.of(1995, 4, 12)));
        coleccion.anadirCliente(new Cliente(1, "Ana", 500, LocalDate.of(1990, 8, 20)));
        coleccion.anadirCliente(new Cliente(2, "Lucia", 750, LocalDate.of(2000, 2, 15)));

        coleccion.ordenarPorNumero();

        VentanaPrincipal vista = new VentanaPrincipal();

        ControladorClientes controlador = new ControladorClientes(coleccion, vista);

        controlador.actualizarVista();

        vista.setVisible(true);
    }
}
