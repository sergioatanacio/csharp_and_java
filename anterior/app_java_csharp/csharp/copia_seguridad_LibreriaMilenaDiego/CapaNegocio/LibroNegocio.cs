using System.Collections.Generic;
using CapaDatos;
using CapaEntidad;

namespace CapaNegocio
{
    public class LibroNegocio
    {
        private LibroDatos libroDatos = new LibroDatos();

        public List<Libro> ObtenerTodosLosLibros()
        {
            return libroDatos.ObtenerLibros();
        }

        // Métodos adicionales para validar, procesar lógica de negocio
    }
}
