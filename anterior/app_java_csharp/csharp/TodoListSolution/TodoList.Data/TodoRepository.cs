
using System.Collections.Generic;
using System.Linq;
using TodoList.Entities;

namespace TodoList.Data
{
    public class TodoRepository
    {
        private readonly List<TodoItem> _todos;
        private int _nextId = 1;

        public TodoRepository()
        {
            _todos = new List<TodoItem>();
        }

        public List<TodoItem> GetAll()
        {
            return _todos.ToList();
        }

        public void Add(TodoItem item)
        {
            item.Id = _nextId++;
            _todos.Add(item);
        }

        public void Update(TodoItem item)
        {
            var existing = _todos.FirstOrDefault(t => t.Id == item.Id);
            if (existing != null)
            {
                existing.Descripcion = item.Descripcion;
                existing.Completado = item.Completado;
            }
        }

        public void Delete(int id)
        {
            var item = _todos.FirstOrDefault(t => t.Id == id);
            if (item != null)
            {
                _todos.Remove(item);
            }
        }
    }
}
