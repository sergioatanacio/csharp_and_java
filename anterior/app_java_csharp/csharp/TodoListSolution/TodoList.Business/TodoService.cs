
using System.Collections.Generic;
using TodoList.Entities;
using TodoList.Data;

namespace TodoList.Business
{
    public class TodoService
    {
        private readonly TodoRepository _repository;

        public TodoService()
        {
            _repository = new TodoRepository();
        }

        public List<TodoItem> ObtenerTodos()
        {
            return _repository.GetAll();
        }

        public void AgregarTodo(string descripcion)
        {
            var nuevoTodo = new TodoItem(0, descripcion);
            _repository.Add(nuevoTodo);
        }

        public void ActualizarTodo(TodoItem item)
        {
            _repository.Update(item);
        }

        public void EliminarTodo(int id)
        {
            _repository.Delete(id);
        }
    }
}
