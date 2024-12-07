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
        for (TodoItem item : todoData.getAllTodos()) {
            if (item.getId() == id) {
                todoData.updateTodoStatus(id, !item.isCompleted());
                break;
            }
        }
    }
}
