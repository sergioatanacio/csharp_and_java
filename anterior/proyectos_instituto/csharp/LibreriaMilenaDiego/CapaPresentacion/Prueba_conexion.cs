using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using CapaEntidad;
using CapaNegocio;

namespace CapaPresentacion
{
    public partial class Prueba_conexion : Form
    {
        ClassNegocio objdat = new ClassNegocio();
        ClassUsuario obUsuario = new ClassUsuario();
        public Prueba_conexion(ClassUsuario objUsuario)
        {
            InitializeComponent();
            this.obUsuario = objUsuario;
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            
        }

        private void Login_Load(object sender, EventArgs e)
        {
            dataGridView1.DataSource = objdat.N_listar_usuarios();
        }

        private void btnRegresar_Click(object sender, EventArgs e)
        {
            Modulos obj_modulo = new Modulos(this.obUsuario);
            this.Hide();
            obj_modulo.Show();

        }
    }
}
