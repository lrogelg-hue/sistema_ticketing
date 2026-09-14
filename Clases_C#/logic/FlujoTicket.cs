namespace TicketsSoporte.logica
{
    public class FlujoTicket
    {
        public bool puedeCambiarEstado(string strEstadoActual, string strNuevoEstado)
        {
            if (strEstadoActual == "Abierto" && strNuevoEstado == "Asignado") return true;
            if (strEstadoActual == "Asignado" && strNuevoEstado == "Resuelto") return true;
            if (strEstadoActual == "Resuelto" && strNuevoEstado == "Cerrado") return true;
            return false;
        }

        public void mostrarFlujo()
        {
            Console.WriteLine("\n=== FLUJO DE ESTADOS DEL TICKET ===");
            Console.WriteLine("Abierto ──► Asignado ──► Resuelto ──► Cerrado");
        }
    }
}