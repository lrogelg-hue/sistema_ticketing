public class Solicitante extends Usuario {
    private String strDepartamento;
    private String strExtension;

    public Solicitante(String strCodigo, String strNombre, String strCorreo, String strDepartamento, String strExtension) {
        super(strCodigo, strNombre, strCorreo);
        this.strDepartamento = strDepartamento;
        this.strExtension = strExtension;
    }

    @Override
    public String obtenerRol() {
        return "Solicitante";
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println(" Departamento: " + strDepartamento + " | Extension: " + strExtension);
    }
}
