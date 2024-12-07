package datos;

import entidad.TodoItem;
import java.util.ArrayList;
import java.util.List;

public class TodoData {
    private List<TodoItem> todoList;
    private int currentId;

    public TodoData() {
        this.todoList = new ArrayList<>();
        this.currentId = 1;
    }

    public List<TodoItem> getAllTodos() {
        return todoList;
    }

    public void addTodo(String description) {
        TodoItem item = new TodoItem(currentId++, description);
        todoList.add(item);
    }

    public void removeTodo(int id) {
        todoList.removeIf(item -> item.getId() == id);
    }

    public void updateTodoStatus(int id, boolean completed) {
        for (TodoItem item : todoList) {
            if (item.getId() == id) {
                item.setCompleted(completed);
                break;
            }
        }
    }
}
