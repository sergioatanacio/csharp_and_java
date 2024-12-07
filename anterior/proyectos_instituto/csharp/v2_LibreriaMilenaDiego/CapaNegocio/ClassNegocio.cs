using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CapaDatos;
using CapaEntidad;

namespace CapaNegocio
{
    public class ClassNegocio
    {
        ClassAuth obj_ClassDatos = new ClassAuth();
        ClassDCategoria obj_Categoria = new ClassDCategoria();
        Conexion objd = new Conexion();
        public DataTable N_listar_usuarios()
        {
            return objd.D_listar_usuarios();
        }
        public ClassUsuario N_sp_Login(ClassUsuario obje)
        {
            return obj_ClassDatos.D_sp_Login(obje);
        }
        public DataTable N_listar_categorias()
        {
            return obj_Categoria.D_listar_categorias();
        }

        public DataTable N_buscar_categoria(ClassECategoria obje)
        {
            return obj_Categoria.D_buscar_categoria(obje);
        }

        public String N_mantenimiento_categoria(ClassECategoria obje)
        {
            return obj_Categoria.D_mantenimiento_categoria(obje);
        }

    }
}
