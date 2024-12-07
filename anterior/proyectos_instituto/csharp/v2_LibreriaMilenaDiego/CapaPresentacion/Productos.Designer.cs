
namespace CapaPresentacion
{
    partial class Productos
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnRegresar = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.btnModificar = new System.Windows.Forms.Button();
            this.btnRegistrar = new System.Windows.Forms.Button();
            this.btnNuevo = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.chk_estado = new System.Windows.Forms.CheckBox();
            this.label1 = new System.Windows.Forms.Label();
            this.lbl_id_producto = new System.Windows.Forms.Label();
            this.txt_nombre_producto = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.txtbuscar = new System.Windows.Forms.TextBox();
            this.txt_descripcion = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.cbx_id_categoria = new System.Windows.Forms.ComboBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.groupBox3.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnRegresar
            // 
            this.btnRegresar.Location = new System.Drawing.Point(12, 12);
            this.btnRegresar.Name = "btnRegresar";
            this.btnRegresar.Size = new System.Drawing.Size(110, 23);
            this.btnRegresar.TabIndex = 2;
            this.btnRegresar.Text = "<= Regresar";
            this.btnRegresar.UseVisualStyleBackColor = true;
            this.btnRegresar.Click += new System.EventHandler(this.btnRegresar_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(12, 252);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(351, 227);
            this.dataGridView1.TabIndex = 3;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.btnEliminar);
            this.groupBox3.Controls.Add(this.btnModificar);
            this.groupBox3.Controls.Add(this.btnRegistrar);
            this.groupBox3.Controls.Add(this.btnNuevo);
            this.groupBox3.Location = new System.Drawing.Point(369, 12);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(85, 148);
            this.groupBox3.TabIndex = 18;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Acciones";
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(4, 105);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(75, 23);
            this.btnEliminar.TabIndex = 8;
            this.btnEliminar.Text = "Eliminar";
            this.btnEliminar.UseVisualStyleBackColor = true;
            // 
            // btnModificar
            // 
            this.btnModificar.Location = new System.Drawing.Point(4, 76);
            this.btnModificar.Name = "btnModificar";
            this.btnModificar.Size = new System.Drawing.Size(75, 23);
            this.btnModificar.TabIndex = 7;
            this.btnModificar.Text = "Modificar";
            this.btnModificar.UseVisualStyleBackColor = true;
            // 
            // btnRegistrar
            // 
            this.btnRegistrar.Location = new System.Drawing.Point(4, 47);
            this.btnRegistrar.Name = "btnRegistrar";
            this.btnRegistrar.Size = new System.Drawing.Size(75, 23);
            this.btnRegistrar.TabIndex = 6;
            this.btnRegistrar.Text = "Registrar";
            this.btnRegistrar.UseVisualStyleBackColor = true;
            // 
            // btnNuevo
            // 
            this.btnNuevo.Cursor = System.Windows.Forms.Cursors.PanWest;
            this.btnNuevo.Location = new System.Drawing.Point(4, 18);
            this.btnNuevo.Name = "btnNuevo";
            this.btnNuevo.Size = new System.Drawing.Size(75, 23);
            this.btnNuevo.TabIndex = 5;
            this.btnNuevo.Text = "Nuevo";
            this.btnNuevo.UseVisualStyleBackColor = true;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.cbx_id_categoria);
            this.groupBox2.Controls.Add(this.txt_descripcion);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.chk_estado);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.lbl_id_producto);
            this.groupBox2.Controls.Add(this.txt_nombre_producto);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Location = new System.Drawing.Point(12, 53);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(351, 183);
            this.groupBox2.TabIndex = 17;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Productos";
            // 
            // chk_estado
            // 
            this.chk_estado.AutoSize = true;
            this.chk_estado.Checked = true;
            this.chk_estado.CheckState = System.Windows.Forms.CheckState.Checked;
            this.chk_estado.Location = new System.Drawing.Point(145, 160);
            this.chk_estado.Name = "chk_estado";
            this.chk_estado.Size = new System.Drawing.Size(59, 17);
            this.chk_estado.TabIndex = 14;
            this.chk_estado.Text = "Estado";
            this.chk_estado.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(19, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(86, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Codigo Producto";
            // 
            // lbl_id_producto
            // 
            this.lbl_id_producto.AutoSize = true;
            this.lbl_id_producto.Location = new System.Drawing.Point(19, 34);
            this.lbl_id_producto.Name = "lbl_id_producto";
            this.lbl_id_producto.Size = new System.Drawing.Size(10, 13);
            this.lbl_id_producto.TabIndex = 13;
            this.lbl_id_producto.Text = "-";
            // 
            // txt_nombre_producto
            // 
            this.txt_nombre_producto.Location = new System.Drawing.Point(114, 34);
            this.txt_nombre_producto.Name = "txt_nombre_producto";
            this.txt_nombre_producto.Size = new System.Drawing.Size(90, 20);
            this.txt_nombre_producto.TabIndex = 8;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(114, 16);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(90, 13);
            this.label2.TabIndex = 9;
            this.label2.Text = "Nombre Producto";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(151, 142);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(43, 13);
            this.label3.TabIndex = 11;
            this.label3.Text = "Estado:";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.txtbuscar);
            this.groupBox1.Location = new System.Drawing.Point(140, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(223, 44);
            this.groupBox1.TabIndex = 16;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Buscar:";
            // 
            // txtbuscar
            // 
            this.txtbuscar.Location = new System.Drawing.Point(6, 18);
            this.txtbuscar.Name = "txtbuscar";
            this.txtbuscar.Size = new System.Drawing.Size(211, 20);
            this.txtbuscar.TabIndex = 4;
            // 
            // txt_descripcion
            // 
            this.txt_descripcion.Location = new System.Drawing.Point(210, 35);
            this.txt_descripcion.Name = "txt_descripcion";
            this.txt_descripcion.Size = new System.Drawing.Size(90, 20);
            this.txt_descripcion.TabIndex = 15;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(210, 17);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(63, 13);
            this.label4.TabIndex = 16;
            this.label4.Text = "Descripción";
            // 
            // cbx_id_categoria
            // 
            this.cbx_id_categoria.FormattingEnabled = true;
            this.cbx_id_categoria.Location = new System.Drawing.Point(6, 86);
            this.cbx_id_categoria.Name = "cbx_id_categoria";
            this.cbx_id_categoria.Size = new System.Drawing.Size(99, 21);
            this.cbx_id_categoria.TabIndex = 17;
            this.cbx_id_categoria.SelectedIndexChanged += new System.EventHandler(this.cbx_id_categoria_SelectedIndexChanged);
            // 
            // Productos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(448, 491);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.btnRegresar);
            this.Name = "Productos";
            this.Text = "Productos";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.groupBox3.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnRegresar;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Button btnModificar;
        private System.Windows.Forms.Button btnRegistrar;
        private System.Windows.Forms.Button btnNuevo;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.CheckBox chk_estado;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lbl_id_producto;
        private System.Windows.Forms.TextBox txt_nombre_producto;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox txtbuscar;
        private System.Windows.Forms.TextBox txt_descripcion;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox cbx_id_categoria;
    }
}