using System;
using System.Windows.Forms;
using CapaNegocio;
using CapaEntidad;
using System.Collections.Generic;

namespace CapaPresentacion
{
    public partial class Form1 : Form
    {
        private LibroNegocio libroNegocio = new LibroNegocio();

        public Form1()
        {
            InitializeComponent();
            CargarLibros();
        }

        private void CargarLibros()
        {
            List<Libro> libros = libroNegocio.ObtenerTodosLosLibros();
            dataGridViewLibros.DataSource = libros;
        }
    }
}
