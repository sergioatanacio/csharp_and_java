using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CapaEntidad;

namespace CapaDatos
{
    public class ClassDCategoria
    {
        MySqlConnection cn = new MySqlConnection(ConfigurationManager.ConnectionStrings["mysql"].ConnectionString);
        public DataTable D_listar_categorias()
        {
            MySqlCommand cmd = new MySqlCommand("sp_listar_categorias", cn);
            cmd.CommandType = CommandType.StoredProcedure;
            // cmd.Parameters.AddWithValue("nombre_cliente", obje.nombre);
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            da.Fill(dt);
            return dt;
        }


        public DataTable D_buscar_categoria(ClassECategoria obje)
        {
            MySqlCommand cmd = new MySqlCommand("sp_buscar_categoria", cn);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("descripcion_param", obje.descripcion);
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            da.Fill(dt);
            return dt;
        }

        public string D_mantenimiento_categoria(ClassECategoria obje)
        {
            string accion = "";
            MySqlCommand cmd = new MySqlCommand("sp_mantenimiento_categoria", cn);
            cmd.CommandType = CommandType.StoredProcedure;

            // Ajustar nombres de parámetros según el procedimiento almacenado
            cmd.Parameters.AddWithValue("id_categoria_param", obje.id_categoria);
            cmd.Parameters.AddWithValue("descripcion_param", obje.descripcion);
            cmd.Parameters.AddWithValue("estado_param", obje.estado);
            // cmd.Parameters.AddWithValue("accion_param", obje.accion);
            cmd.Parameters.Add("accion_param", MySqlDbType.VarChar, 50).Value = obje.accion;
            cmd.Parameters["accion_param"].Direction = ParameterDirection.InputOutput;

            try
            {
                if (cn.State == ConnectionState.Closed)
                    cn.Open();

                cmd.ExecuteNonQuery();
                accion = cmd.Parameters["accion_param"].Value.ToString();
            }
            catch (Exception ex)
            {
                // Manejo de excepciones
                throw ex;
            }
            finally
            {
                cn.Close();
            }

            return accion;
        }





    }
}
