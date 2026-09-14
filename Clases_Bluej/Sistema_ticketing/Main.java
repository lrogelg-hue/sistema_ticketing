import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Crear tecnicos y solicitantes
        Tecnico tecSoftware = new Tecnico("T01", "Ana Lopez", "ana@empresa.com", "Software", 2);
        Tecnico tecHardware = new Tecnico("T02", "Carlos Mendez", "carlos@empresa.com", "Hardware", 2);
        Solicitante solVentas = new Solicitante("S01", "Luis Ramirez", "luis@empresa.com", "Ventas", "1201");

        // 2. Probar Polimorfismo
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(tecSoftware);
        usuarios.add(tecHardware);
        usuarios.add(solVentas);

        System.out.println("=== DEMOSTRACION DE POLIMORFISMO ===");
        for (Usuario u : usuarios) {
            u.mostrarInformacion();
            System.out.println();
        }

        // 3. Crear ticket y procesarlo
        System.out.println("=== FLUJO DE TICKET ===");
        Ticket ticket = new Ticket(1, "Error de Red", "Sin conexion a servidor", "Software", "Alta", solVentas);
        
        if (tecSoftware.puedeAtender("Software")) {
            ticket.asignarTecnico(tecSoftware);
        }

        ticket.mostrarResumen();
        ticket.resolver("Se reinicio la interfaz de red.");
        ticket.cerrar();

        System.out.println("\n=== BITACORA DE EVENTOS ===");
        ticket.mostrarBitacora();
    }
}