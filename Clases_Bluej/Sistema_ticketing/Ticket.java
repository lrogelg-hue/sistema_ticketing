import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private int intNumero;
    private String strTitulo;
    private String strDescripcion;
    private String strCategoria;
    private String strPrioridad;
    private String strEstado;
    private boolean blnEscalado;
    private Solicitante objSolicitante;
    private Tecnico objTecnicoAsignado;
    private List<String> lstBitacora;
    private List<String> lstErrores;

    public Ticket(int intNumero, String strTitulo, String strDescripcion, String strCategoria, String strPrioridad, Solicitante objSolicitante) {
        this.intNumero = intNumero;
        this.strTitulo = strTitulo;
        this.strDescripcion = strDescripcion;
        this.strCategoria = strCategoria;
        this.strPrioridad = strPrioridad;
        this.objSolicitante = objSolicitante;
        this.strEstado = "Abierto";
        this.blnEscalado = false;
        this.lstBitacora = new ArrayList<>();
        this.lstErrores = new ArrayList<>();
        registrarBitacora("Ticket creado");
    }

    public void registrarBitacora(String strEvento) {
        lstBitacora.add(strEvento);
    }

    public void asignarTecnico(Tecnico objTecnico) {
        if (objTecnico == null) {
            throw new IllegalArgumentException("No se puede asignar un tecnico nulo.");
        }
        if (!objTecnico.puedeAtender(strCategoria)) {
            throw new IllegalStateException("El tecnico no esta disponible o no atiende esta categoria.");
        }
        this.objTecnicoAsignado = objTecnico;
        objTecnico.aumentarCarga();
        this.strEstado = "Asignado";
        registrarBitacora("Asignado a tecnico");
    }

    public void registrarError(String strTipo, String strDescripcion, String strImpacto) {
        String strError = strTipo + ": " + strDescripcion + " | Impacto: " + strImpacto;
        lstErrores.add(strError);
        registrarBitacora("Error registrado - " + strError);

        if (strImpacto.equalsIgnoreCase("Alto") || strImpacto.equalsIgnoreCase("Critico")) {
            escalar("Error de alto impacto");
        }
    }

    public void resolver(String strSolucion) {
        if (objTecnicoAsignado == null || !strEstado.equals("Asignado")) {
            throw new IllegalStateException("Solo se puede resolver un ticket asignado.");
        }
        this.strEstado = "Resuelto";
        registrarBitacora("Solucion registrada: " + strSolucion);
    }

    public void cerrar() {
        if (!strEstado.equals("Resuelto")) {
            throw new IllegalStateException("Solo se puede cerrar un ticket resuelto.");
        }
        this.strEstado = "Cerrado";
        if (objTecnicoAsignado != null) {
            objTecnicoAsignado.liberarCarga();
        }
        registrarBitacora("Ticket cerrado");
    }

    public void escalar(String strMotivo) {
        this.blnEscalado = true;
        if (!strPrioridad.equalsIgnoreCase("Critica")) {
            this.strPrioridad = "Critica";
        }
        registrarBitacora("Ticket escalado: " + strMotivo);
    }

    public void mostrarResumen() {
        System.out.println("#" + intNumero + " | " + strTitulo + " | Estado: " + strEstado + " | Prioridad: " + strPrioridad + " | Categoria: " + strCategoria);
        System.out.println(" Solicitante: " + objSolicitante.strNombre);
        System.out.println(" Tecnico: " + (objTecnicoAsignado != null ? objTecnicoAsignado.strNombre : "Sin asignar") + " | Escalado: " + blnEscalado);
    }

    public void mostrarBitacora() {
        System.out.println("\nBitacora del ticket #" + intNumero);
        for (String evento : lstBitacora) {
            System.out.println("- " + evento);
        }
    }
}