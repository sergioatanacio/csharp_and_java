using System;
using System.Collections.Generic;
using System.Windows.Forms;
using TodoList.Business;
using TodoList.Entities;

namespace TodoList.Presentation
{
    public partial class Form1 : Form
    {
        private readonly TodoService _todoService;
        private List<TodoItem> _todos;

        public Form1()
        {
            InitializeComponent();
            _todoService = new TodoService();
            CargarTodos();
        }

        private void CargarTodos()
        {
            _todos = _todoService.ObtenerTodos();
            lstTodos.Items.Clear();
            foreach (var todo in _todos)
            {
                lstTodos.Items.Add($"{todo.Id}: {(todo.Completado ? "[X]" : "[ ]")} {todo.Descripcion}");
            }
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            var descripcion = txtDescripcion.Text.Trim();
            if (!string.IsNullOrEmpty(descripcion))
            {
                _todoService.AgregarTodo(descripcion);
                txtDescripcion.Clear();
                CargarTodos();
            }
            else
            {
                MessageBox.Show("Por favor, ingresa una descripción para el TODO.", "Información", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (lstTodos.SelectedItem != null)
            {
                var selected = lstTodos.SelectedItem.ToString();
                var id = int.Parse(selected.Split(':')[0]);
                _todoService.EliminarTodo(id);
                CargarTodos();
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un TODO para eliminar.", "Información", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void lstTodos_DoubleClick(object sender, EventArgs e)
        {
            if (lstTodos.SelectedItem != null)
            {
                var selected = lstTodos.SelectedItem.ToString();
                var id = int.Parse(selected.Split(':')[0]);
                var todo = _todos.Find(t => t.Id == id);
                if (todo != null)
                {
                    todo.Completado = !todo.Completado;
                    _todoService.ActualizarTodo(todo);
                    CargarTodos();
                }
            }
        }
    }
}
