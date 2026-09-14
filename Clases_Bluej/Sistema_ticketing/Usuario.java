public abstract class Usuario {
    protected String strCodigo;
    protected String strNombre;
    protected String strCorreo;
    protected boolean blnActivo;

    public Usuario(String strCodigo, String strNombre, String strCorreo) {
        this.strCodigo = strCodigo;
        this.strNombre = strNombre;
        this.strCorreo = strCorreo;
        this.blnActivo = true;
    }

    public abstract String obtenerRol();

    public void mostrarInformacion() {
        System.out.println("[" + obtenerRol() + "] Codigo: " + strCodigo + " | Nombre: " + strNombre + " | Correo: " + strCorreo + " | Activo: " + blnActivo);
    }
}