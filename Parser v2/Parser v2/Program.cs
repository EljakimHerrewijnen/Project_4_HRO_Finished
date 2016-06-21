using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Parser_v2;
using System.IO;
using System.Windows.Forms;

namespace Parser_v2
{
    class Program
    {
        [STAThread]
        static void Main(string[] args)
        {
            Application.Run(new ParserGUI());
        }
    }
}
