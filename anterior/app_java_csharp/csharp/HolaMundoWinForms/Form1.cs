using System;
using System.Windows.Forms;

namespace HolaMundoWinForms
{
    public partial class Form1 : Form
    {
        private Label labelHolaMundo;

        public Form1()
        {
            InitializeComponent();
            InitializeCustomComponents();
        }

        private void InitializeCustomComponents()
        {
            // Crear y configurar el Label
            this.labelHolaMundo = new Label();
            this.labelHolaMundo.Text = "Hola Mundo";
            this.labelHolaMundo.AutoSize = true;
            this.labelHolaMundo.Font = new System.Drawing.Font("Segoe UI", 14F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.labelHolaMundo.Location = new System.Drawing.Point(100, 100);

            // Añadir el Label al formulario
            this.Controls.Add(this.labelHolaMundo);
        }
    }
}
