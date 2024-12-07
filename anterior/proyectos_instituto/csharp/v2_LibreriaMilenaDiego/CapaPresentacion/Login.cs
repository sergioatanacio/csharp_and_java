using System;
using System.Windows.Forms;
// using CapaNegocio;
// using CapaEntidad;

namespace CapaPresentacion
{
    public partial class Login : Form
    {
        // ClassNegocio datos = new ClassNegocio();
        // ClassUsuario usuarioLogin = new ClassUsuario();
        public Login()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {

            Modulos ventanaModulos = new Modulos();
            this.Hide();
            ventanaModulos.Show();


            // usuarioLogin.correo = txtUsuario.Text;
            // usuarioLogin.password = txtPassword.Text;

            // try
            // {
            //     ClassUsuario usuario = datos.N_sp_Login(usuarioLogin);

            //     if (!string.IsNullOrEmpty(usuario.id_usuario))
            //     {
            //         lblResultado.Text = usuario.nombre + " " + usuario.rol_descripcion;
            //         Modulos ventanaModulos = new Modulos(usuario);
            //         this.Hide();
            //         ventanaModulos.Show();
            //     }
            //     else
            //     {
            //         lblResultado.Text = "Correo o contraseña incorrectos.";
            //     }
            // }
            // catch (Exception ex)
            // {
            //     lblResultado.Text = "Ocurrió un error al intentar iniciar sesión.";
            //     Console.WriteLine(ex.Message);
            // }
        }

        private void Login_Load(object sender, EventArgs e)
        {
            // usuarioLogin.correo = "juan.perez@melina.com";
            // usuarioLogin.password = "password123";

            // txtUsuario.Text = usuarioLogin.correo;
            // txtPassword.Text = usuarioLogin.password;
        }
    }
}
