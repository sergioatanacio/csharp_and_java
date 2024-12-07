

namespace TodoList.Entities
{
    public class TodoItem
    {
        public int Id { get; set; }
        public string Descripcion { get; set; }
        public bool Completado { get; set; }

        public TodoItem(int id, string descripcion)
        {
            Id = id;
            Descripcion = descripcion;
            Completado = false;
        }
    }
}
