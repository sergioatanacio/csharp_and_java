namespace TodoList.Presentation
{
    partial class Form1
    {
        private System.ComponentModel.IContainer components = null;
        private System.Windows.Forms.ListBox lstTodos;
        private System.Windows.Forms.TextBox txtDescripcion;
        private System.Windows.Forms.Button btnAgregar;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Label lblDescripcion;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }        

        private void InitializeComponent()
        {
            this.lstTodos = new System.Windows.Forms.ListBox();
            this.txtDescripcion = new System.Windows.Forms.TextBox();
            this.btnAgregar = new System.Windows.Forms.Button();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.lblDescripcion = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lstTodos
            // 
            this.lstTodos.FormattingEnabled = true;
            this.lstTodos.ItemHeight = 15;
            this.lstTodos.Location = new System.Drawing.Point(12, 12);
            this.lstTodos.Name = "lstTodos";
            this.lstTodos.Size = new System.Drawing.Size(360, 199);
            this.lstTodos.TabIndex = 0;
            this.lstTodos.DoubleClick += new System.EventHandler(this.lstTodos_DoubleClick);
            // 
            // txtDescripcion
            // 
            this.txtDescripcion.Location = new System.Drawing.Point(12, 237);
            this.txtDescripcion.Name = "txtDescripcion";
            this.txtDescripcion.Size = new System.Drawing.Size(260, 23);
            this.txtDescripcion.TabIndex = 1;
            // 
            // btnAgregar
            // 
            this.btnAgregar.Location = new System.Drawing.Point(278, 236);
            this.btnAgregar.Name = "btnAgregar";
            this.btnAgregar.Size = new System.Drawing.Size(94, 23);
            this.btnAgregar.TabIndex = 2;
            this.btnAgregar.Text = "Agregar";
            this.btnAgregar.UseVisualStyleBackColor = true;
            this.btnAgregar.Click += new System.EventHandler(this.btnAgregar_Click);
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(12, 266);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(360, 23);
            this.btnEliminar.TabIndex = 3;
            this.btnEliminar.Text = "Eliminar Seleccionado";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // lblDescripcion
            // 
            this.lblDescripcion.AutoSize = true;
            this.lblDescripcion.Location = new System.Drawing.Point(12, 219);
            this.lblDescripcion.Name = "lblDescripcion";
            this.lblDescripcion.Size = new System.Drawing.Size(75, 15);
            this.lblDescripcion.TabIndex = 4;
            this.lblDescripcion.Text = "Descripción:";
            // 
            // Form1
            // 
            this.ClientSize = new System.Drawing.Size(384, 301);
            this.Controls.Add(this.lblDescripcion);
            this.Controls.Add(this.btnEliminar);
            this.Controls.Add(this.btnAgregar);
            this.Controls.Add(this.txtDescripcion);
            this.Controls.Add(this.lstTodos);
            this.Name = "Form1";
            this.Text = "To-Do List";
            this.ResumeLayout(false);
            this.PerformLayout();
        }
    }
}
