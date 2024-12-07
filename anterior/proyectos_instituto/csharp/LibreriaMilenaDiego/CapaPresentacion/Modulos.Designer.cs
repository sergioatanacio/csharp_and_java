
namespace CapaPresentacion
{
    partial class Modulos
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
            this.lblNombre = new System.Windows.Forms.Label();
            this.lblRol = new System.Windows.Forms.Label();
            this.btnCategoria = new System.Windows.Forms.Button();
            this.btnProductos = new System.Windows.Forms.Button();
            this.btnVenta = new System.Windows.Forms.Button();
            this.btnClientes = new System.Windows.Forms.Button();
            this.btnProveedores = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.btnVentas = new System.Windows.Forms.Button();
            this.Prueba = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(64, 34);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(54, 13);
            this.lblNombre.TabIndex = 0;
            this.lblNombre.Text = "lblNombre";
            // 
            // lblRol
            // 
            this.lblRol.AutoSize = true;
            this.lblRol.Location = new System.Drawing.Point(239, 34);
            this.lblRol.Name = "lblRol";
            this.lblRol.Size = new System.Drawing.Size(33, 13);
            this.lblRol.TabIndex = 1;
            this.lblRol.Text = "lblRol";
            // 
            // btnCategoria
            // 
            this.btnCategoria.Location = new System.Drawing.Point(31, 76);
            this.btnCategoria.Name = "btnCategoria";
            this.btnCategoria.Size = new System.Drawing.Size(106, 23);
            this.btnCategoria.TabIndex = 2;
            this.btnCategoria.Text = "Categorias";
            this.btnCategoria.UseVisualStyleBackColor = true;
            this.btnCategoria.Click += new System.EventHandler(this.btnCategoria_Click);
            // 
            // btnProductos
            // 
            this.btnProductos.Location = new System.Drawing.Point(143, 76);
            this.btnProductos.Name = "btnProductos";
            this.btnProductos.Size = new System.Drawing.Size(112, 23);
            this.btnProductos.TabIndex = 3;
            this.btnProductos.Text = "Productos";
            this.btnProductos.UseVisualStyleBackColor = true;
            this.btnProductos.Click += new System.EventHandler(this.btnProductos_Click);
            // 
            // btnVenta
            // 
            this.btnVenta.Location = new System.Drawing.Point(389, 76);
            this.btnVenta.Name = "btnVenta";
            this.btnVenta.Size = new System.Drawing.Size(109, 23);
            this.btnVenta.TabIndex = 4;
            this.btnVenta.Text = "Generar Venta";
            this.btnVenta.UseVisualStyleBackColor = true;
            this.btnVenta.Click += new System.EventHandler(this.btnVenta_Click);
            // 
            // btnClientes
            // 
            this.btnClientes.Location = new System.Drawing.Point(31, 130);
            this.btnClientes.Name = "btnClientes";
            this.btnClientes.Size = new System.Drawing.Size(106, 23);
            this.btnClientes.TabIndex = 5;
            this.btnClientes.Text = "Clientes";
            this.btnClientes.UseVisualStyleBackColor = true;
            this.btnClientes.Click += new System.EventHandler(this.btnClientes_Click);
            // 
            // btnProveedores
            // 
            this.btnProveedores.Location = new System.Drawing.Point(143, 130);
            this.btnProveedores.Name = "btnProveedores";
            this.btnProveedores.Size = new System.Drawing.Size(112, 23);
            this.btnProveedores.TabIndex = 6;
            this.btnProveedores.Text = "Proveedores";
            this.btnProveedores.UseVisualStyleBackColor = true;
            this.btnProveedores.Click += new System.EventHandler(this.btnProveedores_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(389, 130);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(109, 23);
            this.button1.TabIndex = 7;
            this.button1.Text = "Button";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // btnVentas
            // 
            this.btnVentas.Location = new System.Drawing.Point(265, 76);
            this.btnVentas.Name = "btnVentas";
            this.btnVentas.Size = new System.Drawing.Size(109, 23);
            this.btnVentas.TabIndex = 8;
            this.btnVentas.Text = "Ventas";
            this.btnVentas.UseVisualStyleBackColor = true;
            // 
            // Prueba
            // 
            this.Prueba.Location = new System.Drawing.Point(265, 130);
            this.Prueba.Name = "Prueba";
            this.Prueba.Size = new System.Drawing.Size(109, 23);
            this.Prueba.TabIndex = 9;
            this.Prueba.Text = "Prueba";
            this.Prueba.UseVisualStyleBackColor = true;
            this.Prueba.Click += new System.EventHandler(this.Prueba_Click);
            // 
            // Modulos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(663, 397);
            this.Controls.Add(this.Prueba);
            this.Controls.Add(this.btnVentas);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnProveedores);
            this.Controls.Add(this.btnClientes);
            this.Controls.Add(this.btnVenta);
            this.Controls.Add(this.btnProductos);
            this.Controls.Add(this.btnCategoria);
            this.Controls.Add(this.lblRol);
            this.Controls.Add(this.lblNombre);
            this.Name = "Modulos";
            this.Text = "Modulos";
            this.Load += new System.EventHandler(this.Modulos_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblNombre;
        private System.Windows.Forms.Label lblRol;
        private System.Windows.Forms.Button btnCategoria;
        private System.Windows.Forms.Button btnProductos;
        private System.Windows.Forms.Button btnVenta;
        private System.Windows.Forms.Button btnClientes;
        private System.Windows.Forms.Button btnProveedores;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button btnVentas;
        private System.Windows.Forms.Button Prueba;
    }
}