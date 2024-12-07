using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CapaEntidad
{
    public class ClassUsuario
    {
        public string id_usuario { get; set; }
        public string nombre { get; set; }
        public string apellido_p { get; set; }
        public string apellido_m { get; set; }
        public string id_rol { get; set; }
        public string rol_descripcion { get; set; }
        public string correo { get; set; }
        public string password { get; set; }
    }
}


