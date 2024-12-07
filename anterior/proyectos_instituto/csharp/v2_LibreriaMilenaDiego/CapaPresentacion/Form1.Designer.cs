using System;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;

namespace CapaPresentacion
{
    // Clase parcial generada por el Diseñador de Windows Forms
    partial class Form1
    {
        /// <summary>
        /// Contenedor de los componentes utilizados en el formulario.
        /// </summary>
        private IContainer components = null;

        // Declaración de los controles de la interfaz de usuario
        private Label labelUsername;
        private TextBox textBoxUsername;
        private Label labelPassword;
        private TextBox textBoxPassword;
        private Button buttonLogin;

        /// <summary>
        /// Método para limpiar los recursos utilizados.
        /// </summary>
        /// <param name="disposing">Indica si se deben liberar los recursos administrados.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para soportar el Diseñador. No se debe modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            // Inicialización del contenedor de componentes
            this.components = new Container();

            // Creación y configuración de la etiqueta para el nombre de usuario
            this.labelUsername = new Label();
            this.labelUsername.AutoSize = true;
            this.labelUsername.Location = new Point(50, 50); // Posición en el formulario
            this.labelUsername.Name = "labelUsername";
            this.labelUsername.Size = new Size(111, 15);
            this.labelUsername.TabIndex = 0; // Orden de tabulación
            this.labelUsername.Text = "Nombre de usuario";

            // Creación y configuración del cuadro de texto para el nombre de usuario
            this.textBoxUsername = new TextBox();
            this.textBoxUsername.Location = new Point(180, 47);
            this.textBoxUsername.Name = "textBoxUsername";
            this.textBoxUsername.Size = new Size(200, 23);
            this.textBoxUsername.TabIndex = 1;

            // Creación y configuración de la etiqueta para la contraseña
            this.labelPassword = new Label();
            this.labelPassword.AutoSize = true;
            this.labelPassword.Location = new Point(50, 100);
            this.labelPassword.Name = "labelPassword";
            this.labelPassword.Size = new Size(70, 15);
            this.labelPassword.TabIndex = 2;
            this.labelPassword.Text = "Contraseña";

            // Creación y configuración del cuadro de texto para la contraseña
            this.textBoxPassword = new TextBox();
            this.textBoxPassword.Location = new Point(180, 97);
            this.textBoxPassword.Name = "textBoxPassword";
            this.textBoxPassword.Size = new Size(200, 23);
            this.textBoxPassword.TabIndex = 3;
            this.textBoxPassword.UseSystemPasswordChar = true; // Oculta la contraseña ingresada

            // Creación y configuración del botón de inicio de sesión
            this.buttonLogin = new Button();
            this.buttonLogin.Location = new Point(180, 150);
            this.buttonLogin.Name = "buttonLogin";
            this.buttonLogin.Size = new Size(100, 30);
            this.buttonLogin.TabIndex = 4;
            this.buttonLogin.Text = "Iniciar sesión";
            this.buttonLogin.UseVisualStyleBackColor = true;
            // Asignación del manejador de eventos para el clic del botón
            this.buttonLogin.Click += new EventHandler(this.buttonLogin_Click);

            // Adición de los controles al formulario
            this.Controls.Add(this.labelUsername);
            this.Controls.Add(this.textBoxUsername);
            this.Controls.Add(this.labelPassword);
            this.Controls.Add(this.textBoxPassword);
            this.Controls.Add(this.buttonLogin);

            // Configuración de las propiedades del formulario
            this.AutoScaleMode = AutoScaleMode.Font;
            this.ClientSize = new Size(450, 250); // Tamaño del formulario
            this.Name = "Form1";
            this.Text = "Librería Milena y Diego"; // Título del formulario

            this.StartPosition = FormStartPosition.CenterScreen;

        }

        #endregion
    }
}
