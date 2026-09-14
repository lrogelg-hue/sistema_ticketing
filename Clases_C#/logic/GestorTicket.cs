using System;
using System.Collections.Generic;
using System.Linq;

namespace TicketsSoporte.logica
{
    public class GestorTickets
    {
        public List<Tecnico> lstTecnicos { get; set; }
        public List<Solicitante> lstSolicitantes { get; set; }
        public List<Ticket> lstTickets { get; set; }
        private int intCorrelativo;

        public GestorTickets()
        {
            lstTecnicos = new List<Tecnico>();
            lstSolicitantes = new List<Solicitante>();
            lstTickets = new List<Ticket>();
            intCorrelativo = 1;
        }

        public Ticket crearTicket(string strTitulo, string strDescripcion, string strCategoria, string strPrioridad, Solicitante objSolicitante)
        {
            Ticket objTicket = new Ticket(intCorrelativo++, strTitulo, strDescripcion, strCategoria, strPrioridad, objSolicitante);

            Tecnico objTecnicoApto = lstTecnicos.FirstOrDefault(t => t.puedeAtender(strCategoria));
            if (objTecnicoApto != null)
            {
                objTicket.asignarTecnico(objTecnicoApto);
            }

            lstTickets.Add(objTicket);
            return objTicket;
        }

        public Ticket buscarTicket(int intNumero)
        {
            Ticket t = lstTickets.FirstOrDefault(x => x.intNumero == intNumero);
            if (t == null) throw new KeyNotFoundException($"No se encontró el ticket #{intNumero}.");
            return t;
        }

        public void mostrarTickets()
        {
            Console.WriteLine("\n=== LISTADO DE TICKETS ===");
            if (lstTickets.Count == 0) Console.WriteLine("No hay tickets registrados.");
            foreach (var t in lstTickets) t.mostrarResumen();
        }

        public void generarResumenControl()
        {
            Console.WriteLine("\n=== RESUMEN DE CONTROL DE SISTEMA ===");
            Console.WriteLine($"Total Tickets: {lstTickets.Count}");
            Console.WriteLine($"Tickets Resueltos/Cerrados: {lstTickets.Count(t => t.strEstado == "Resuelto" || t.strEstado == "Cerrado")}");
            Console.WriteLine($"Tickets Escalados: {lstTickets.Count(t => t.blnEscalado)}");
        }
    }
}