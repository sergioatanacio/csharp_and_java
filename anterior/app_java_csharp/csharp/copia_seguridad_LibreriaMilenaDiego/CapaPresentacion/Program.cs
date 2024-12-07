using System;
using System.Windows.Forms;

namespace CapaPresentacion
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
