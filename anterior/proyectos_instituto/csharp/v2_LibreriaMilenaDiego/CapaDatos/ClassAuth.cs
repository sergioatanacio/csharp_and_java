using MySql.Data.MySqlClient;
using System;
using System.Configuration;
using System.Data;
using CapaEntidad;

namespace CapaDatos
{
    public class ClassAuth
    {
        MySqlConnection cn = new MySqlConnection(ConfigurationManager.ConnectionStrings["mysql"].ConnectionString);

        public ClassUsuario D_sp_Login(ClassUsuario obje)
        {
            ClassUsuario usuario = new ClassUsuario(); // Crear la instancia vacía

            try
            {
                MySqlCommand cmd = new MySqlCommand("sp_Login", cn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("p_correo", obje.correo);
                cmd.Parameters.AddWithValue("p_contrasena", obje.password);

                if (cn.State == ConnectionState.Closed) cn.Open();

                MySqlDataReader reader = cmd.ExecuteReader();
                if (reader.Read()) // Si hay resultados
                {
                    // Asignar los valores a las propiedades directamente
                    usuario.id_usuario = reader["id_usuario"].ToString();
                    usuario.nombre = reader["nombre"].ToString();
                    usuario.apellido_p = reader["apellido_p"].ToString();
                    usuario.apellido_m = reader["apellido_m"].ToString();
                    usuario.id_rol = reader["id_rol"].ToString();
                    usuario.rol_descripcion = reader["rol_descripcion"].ToString();
                }
                reader.Close(); // Cerramos el reader después de usarlo
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error en D_sp_Login: " + ex.Message);
            }
            finally
            {
                if (cn.State == ConnectionState.Open) cn.Close(); // Aseguramos cerrar la conexión
            }
            return usuario;
        }

            
    }
}
