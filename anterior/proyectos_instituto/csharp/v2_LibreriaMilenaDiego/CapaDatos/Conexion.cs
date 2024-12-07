using CapaEntidad;
using MySql.Data.MySqlClient;
using System;
using System.Configuration;
using System.Data;


namespace CapaDatos
{
    public class Conexion
    {
        MySqlConnection cn = new MySqlConnection(ConfigurationManager.ConnectionStrings["mysql"].ConnectionString);
        public DataTable D_listar_usuarios()
        {
            MySqlCommand cmd = new MySqlCommand("sp_listar_usuarios", cn);
            cmd.CommandType = CommandType.StoredProcedure;
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            da.Fill(dt);
            return dt;
        }
    }
}
