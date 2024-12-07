using CapaEntidad;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CapaPresentacion
{
    public partial class Productos : Form
    {


        ClassUsuario obUsuario = new ClassUsuario();

        public Productos(ClassUsuario objUsuario)
        {
            InitializeComponent();
            this.obUsuario = objUsuario;
        }

        private void btnRegresar_Click(object sender, EventArgs e)
        {
            Modulos obj_modulo = new Modulos(this.obUsuario);
            this.Hide();
            obj_modulo.Show();
        }

        private void cbx_id_categoria_SelectedIndexChanged(object sender, EventArgs e)
        {
            //
        }
    }
}
