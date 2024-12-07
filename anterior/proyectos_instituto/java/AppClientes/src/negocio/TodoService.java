package negocio;

import datos.TodoData;
import entidad.TodoItem;
import java.util.List;

public class TodoService {
    private TodoData todoData;

    public TodoService() {
        this.todoData = new TodoData();
    }

    public List<TodoItem> getAllTodos() {
        return todoData.getAllTodos();
    }

    public void addTodo(String description) {
        if (description != null && !description.trim().isEmpty()) {
            todoData.addTodo(description.trim());
        }
    }

    public void removeTodo(int id) {
        todoData.removeTodo(id);
    }

    public void toggleTodoStatus(int id) {
        // Obtener el estado actual de la tarea
        TodoItem item = todoData.getAllTodos().stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);

        if (item != null) {
            todoData.updateTodoStatus(id, !item.isCompleted());
        }
    }
}
