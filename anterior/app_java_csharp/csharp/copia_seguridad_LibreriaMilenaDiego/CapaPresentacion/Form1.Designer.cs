namespace CapaPresentacion
{
    partial class Form1
    {
        private System.ComponentModel.IContainer components = null;
        private System.Windows.Forms.DataGridView dataGridViewLibros;

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
            this.dataGridViewLibros = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewLibros)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridViewLibros
            // 
            this.dataGridViewLibros.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewLibros.Location = new System.Drawing.Point(12, 12);
            this.dataGridViewLibros.Name = "dataGridViewLibros";
            this.dataGridViewLibros.Size = new System.Drawing.Size(760, 437);
            this.dataGridViewLibros.TabIndex = 0;
            // 
            // Form1
            // 
            this.ClientSize = new System.Drawing.Size(784, 461);
            this.Controls.Add(this.dataGridViewLibros);
            this.Name = "Form1";
            this.Text = "Libreria Milena Diego - Lista de Libros";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewLibros)).EndInit();
            this.ResumeLayout(false);

        }
    }
}
