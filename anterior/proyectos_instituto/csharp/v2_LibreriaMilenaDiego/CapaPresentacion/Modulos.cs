using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
// using CapaEntidad;

namespace CapaPresentacion
{
    public partial class Modulos : Form
    {
        // ClassUsuario obUsuario = new ClassUsuario();
        public Modulos(/*ClassUsuario objUsuario*/)
        {
            InitializeComponent();
            // this.obUsuario = objUsuario;
        }

        private void Modulos_Load(object sender, EventArgs e)
        {
            
            // lblNombre.Text = this.obUsuario.nombre;
            // lblRol.Text = this.obUsuario.rol_descripcion;
        }

        private void btnVenta_Click(object sender, EventArgs e)
        {

        }

        private void btnProductos_Click(object sender, EventArgs e)
        {
            // Productos obj_prueba_conexion = new Productos(this.obUsuario);
            // this.Hide();
            // obj_prueba_conexion.Show();
        }

        private void btnCategoria_Click(object sender, EventArgs e)
        {
            // Categorias obj_categorias = new Categorias(this.obUsuario);
            // this.Hide();
            // obj_categorias.Show();
        }

        private void btnClientes_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void btnProveedores_Click(object sender, EventArgs e)
        {

        }

        private void Prueba_Click(object sender, EventArgs e)
        {
            // Prueba_conexion obj_prueba_conexion = new Prueba_conexion(this.obUsuario);
            // this.Hide();
            // obj_prueba_conexion.Show();
        }
    }
}
