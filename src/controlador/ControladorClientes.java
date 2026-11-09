package controlador;

import vista.VentanaPrincipal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import modelo.Cliente;

public class ControladorClientes {
    private ColeccionClientes coleccion;
    private VentanaPrincipal vista;

    public ControladorClientes(ColeccionClientes coleccion, VentanaPrincipal vista) {
        this.coleccion = coleccion;
        this.vista = vista;
        vista.getPanelVisualizar().setControlador(this);
        vista.getPanelNuevo().setControlador(this);
    }
    
    public void actualizarVista() {
    Cliente cliente = coleccion.obtenerActual();

    if (cliente == null) {
        vista.getPanelVisualizar().mostrarNumero("");
        vista.getPanelVisualizar().mostrarNombre("");
        vista.getPanelVisualizar().mostrarPuntos("");
        vista.getPanelVisualizar().mostrarFechaNacimiento("");
        vista.getPanelVisualizar().mostrarPosicion("Sin clientes");
    } else {
        vista.getPanelVisualizar().mostrarNumero(String.valueOf(cliente.getNumero()));
        vista.getPanelVisualizar().mostrarNombre(cliente.getNombre());
        vista.getPanelVisualizar().mostrarPuntos(String.valueOf(cliente.getPuntos()));
        vista.getPanelVisualizar().mostrarFechaNacimiento(cliente.getFechaNacimiento().toString());

        vista.getPanelVisualizar().mostrarPosicion(
                (coleccion.indexOf(cliente) + 1) + " de " + coleccion.size()
        );
    }  
    }
    
    public void irPrimero() {
        coleccion.irPrimero();
        actualizarVista();
    }

    public void irAnterior() {
        coleccion.retroceder();
        actualizarVista();
    }

    public void irSiguiente() {
        coleccion.avanzar();
        actualizarVista();
    }

    public void irUltimo() {
        coleccion.irUltimo();
        actualizarVista();
    }
    
    public void borrarCliente() {
        coleccion.borrarCliente();
        actualizarVista();
    }
    
    public void anadirCliente() {
        System.out.println("ENTRANDO EN ANADIR CLIENTE");
        try {
            int numero = Integer.parseInt(vista.getPanelNuevo().getNumero());

            String nombre = vista.getPanelNuevo().getNombre();

            float puntos = Float.parseFloat(vista.getPanelNuevo().getPuntos());

            LocalDate fecha = LocalDate.parse(vista.getPanelNuevo().getFechaNacimiento());
            
            
            if (nombre.isEmpty()) {
                vista.getPanelNuevo().mostrarError("El nombre no puede estar vacío");
                return;
            }

            if (!ControlErrores.validarPuntos(puntos, vista.getPanelNuevo().getLblError())) {
                return;
            }

            if (!ControlErrores.validarFecha(fecha, vista.getPanelNuevo().getLblError())) {
                return;
            }

            Cliente cliente = new Cliente(numero, nombre, puntos, fecha);

            coleccion.anadirCliente(cliente);
            coleccion.irUltimo();

            vista.getPanelNuevo().limpiarError();
            actualizarVista();

        } catch (NumberFormatException e) {
            vista.getPanelNuevo().mostrarError("Número o puntos incorrectos");

        } catch (DateTimeParseException e) {
            vista.getPanelNuevo().mostrarError("La fecha debe tener formato AAAA-MM-DD");
        }

    }
}
