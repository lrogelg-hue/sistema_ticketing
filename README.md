# Sistema de Ticketing y Soporte Técnico Corporativo

Este proyecto implementa un sistema para la gestión, seguimiento, escalado y resolución de tickets de soporte técnico. Incluye diseño orientado a objetos con polimorfismo, lógica de negocio avanzada y paridad entre código y diagramas arquitectónicos.

---

## 📁 Estructura del Repositorio

- `/Clases_Bluej`: Proyecto completo adaptado e implementado en Java (BlueJ).
- `/Clases_C#`: Código fuente completo implementado en C# (.NET).
- `/Diagramas`: Diagramas UML (Casos de Uso, Flujos de Proceso y Fuente Draw.io).

---

## 📐 Documentación de Diagramas UML y Flujos

Todos los diagramas fueron diseñados en **Draw.io** utilizando código **PlantUML** y **Mermaid** para garantizar paridad con la arquitectura del sistema.

### Diagrama de Casos de Uso
![Casos de Uso](Diagramas/Caso%20de%20uso.drawio.png)

### Diagramas de Flujo de Procesos
1. **Creación y Asignación Automática:**
   ![Flujo 1](Diagramas/Creaci%C3%B3n%20y%20asignaci%C3%B3n.drawio.png)

2. **Registro de Errores y Escalado:**
   ![Flujo 2](Diagramas/Registro%20y%20Escalado%20de%20Errores.drawio.png)

3. **Resolución de Tickets:**
   ![Flujo 3](Diagramas/Resoluci%C3%B3n%20de%20Tickets.drawio.png)

4. **Cierre y Liberación de Carga:**
   ![Flujo 4](Diagramas/Cierre%20y%20Liberaci%C3%B3n%20de%20Carga.drawio.png)

5. **Consultas y Control del Sistema:**
   ![Flujo 5](Diagramas/Consultas%20y%20Control%20de%20Sistema.drawio.png)

---

## 🚀 Características Principales

- **Gestión de Usuarios:** Polimorfismo mediante la clase base abstracta `Usuario` y subclases `Solicitante` y `Tecnico`.
- **Asignación Automática:** Asignación inteligente de tickets analizando especialidad y control de capacidad máxima de carga (`intCargaActual`).
- **Ciclo de Vida Controlado:** Validación de transiciones de estado (`Abierto` → `Asignado` → `Resuelto` → `Cerrado`) gestionado por `FlujoTicket`.
- **Escalado Dinámico:** Registro de eventos en lista centralizada (`lstBitacora`) y escalado automático a prioridad *Crítica* ante errores de alto impacto.
- **Liberación de Recursos:** Reducción de la carga de trabajo del técnico al cerrar el ticket.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguajes:** C#, Java
- **IDE / Entornos:** Visual Studio / VS Code, BlueJ
- **Modelado / Diagramación:** Draw.io, PlantUML, Mermaid