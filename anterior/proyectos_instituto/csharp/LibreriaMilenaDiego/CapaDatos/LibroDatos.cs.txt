using System;
using System.Collections.Generic;
using CapaEntidad;
using MySql.Data.MySqlClient;

namespace CapaDatos
{
    public class LibroDatos
    {
        private string cadenaConexion = "server=localhost;database=MILENADIEGO;user=root;password=;";

        public List<Libro> ObtenerLibros()
        {
            List<Libro> libros = new List<Libro>();
            using (MySqlConnection conexion = new MySqlConnection(cadenaConexion))
            {
                try
                {
                    conexion.Open();
                    string consulta = "SELECT Id, Titulo, Autor, ISBN, Precio FROM Libros";
                    MySqlCommand comando = new MySqlCommand(consulta, conexion);
                    MySqlDataReader lector = comando.ExecuteReader();

                    while (lector.Read())
                    {
                        Libro libro = new Libro
                        {
                            Id = lector.GetInt32("Id"),
                            Titulo = lector.GetString("Titulo"),
                            Autor = lector.GetString("Autor"),
                            ISBN = lector.GetString("ISBN"),
                            Precio = lector.GetDecimal("Precio")
                        };
                        libros.Add(libro);
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error al obtener libros: {ex.Message}");
                }
            }
            return libros;
        }

        // Métodos adicionales para Insertar, Actualizar, Eliminar
    }
}
