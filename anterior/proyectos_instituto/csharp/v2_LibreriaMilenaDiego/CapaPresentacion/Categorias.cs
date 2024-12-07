using CapaEntidad;
using CapaNegocio;
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
    public partial class Categorias : Form
    {
        // ClassUsuario obUsuario = new ClassUsuario();
        // ClassNegocio objneg = new ClassNegocio();
        // ClassECategoria objecategoria = new ClassECategoria();
        public Categorias(/*ClassUsuario objUsuario*/)
        {
            InitializeComponent();
            // this.obUsuario = objUsuario;
        }

        private void btnRegresar_Click(object sender, EventArgs e)
        {
            // Modulos obj_modulo = new Modulos(this.obUsuario);
            // this.Hide();
            // obj_modulo.Show();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            // int fila = dataGridView1.CurrentCell.RowIndex;
            // lbl_id_categoria.Text   = dataGridView1[0, fila].Value.ToString();
            // txt_descripcion.Text    = dataGridView1[1, fila].Value.ToString();
            // chk_estado.Checked      = Convert.ToBoolean(dataGridView1[2, fila].Value.ToString());


        }

        private void Categorias_Load(object sender, EventArgs e)
        {
            // dataGridView1.DataSource = objneg.N_listar_categorias();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            // if (txtbuscar.Text != "")
            // {
            //     objecategoria.descripcion = txtbuscar.Text;
            //     DataTable dt = new DataTable();
            //     dt = objneg.N_buscar_categoria(objecategoria);
            //     dataGridView1.DataSource = dt;
            // }
            // else
            // {
            //     dataGridView1.DataSource = objneg.N_listar_categorias();
            // }
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            // limpiar();
        }

        void limpiar()
        {
            // lbl_id_categoria.Text = "";
            // txt_descripcion.Text = "";
            // chk_estado.Checked = true;
            // txtbuscar.Text = "";
            // dataGridView1.DataSource = objneg.N_listar_categorias();
        }
        void mantenimiento(String accion)
        {
            // objecategoria.id_categoria = lbl_id_categoria.Text;
            // objecategoria.descripcion = txt_descripcion.Text;
            // objecategoria.estado = chk_estado.Checked;
            // objecategoria.accion = accion;
            // String men = objneg.N_mantenimiento_categoria(objecategoria);
            // MessageBox.Show(men, "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {
            // if (lbl_id_categoria.Text != "-")
            // {
            //     if (MessageBox.Show("¿Deseas modificar a " + txt_descripcion.Text + "?",
            //    "Mensaje",
            //     MessageBoxButtons.YesNo, MessageBoxIcon.Information) ==
            //    System.Windows.Forms.DialogResult.Yes)
            //     {
            //         mantenimiento("2");
            //         limpiar();
            //     }
            // }
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            // if (lbl_id_categoria.Text != "")
            // {
            //     if (MessageBox.Show("¿Deseas eliminar a " + txt_descripcion.Text + "?",
            //    "Mensaje",
            //     MessageBoxButtons.YesNo, MessageBoxIcon.Information) ==
            //    System.Windows.Forms.DialogResult.Yes)
            //     {
            //         mantenimiento("3");
            //         limpiar();
            //     }
            // }
        }
    }
}
