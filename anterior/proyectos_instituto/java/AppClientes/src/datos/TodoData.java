package datos;

import entidad.TodoItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoData {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_todolist?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Deja vacío si no tienes contraseña

    // Constructor para probar la conexión
    public TodoData() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Obtener todas las tareas
    public List<TodoItem> getAllTodos() {
        List<TodoItem> todoList = new ArrayList<>();
        String query = "SELECT * FROM todos";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                boolean completed = rs.getBoolean("completed");
                TodoItem item = new TodoItem(id, description, completed);
                todoList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoList;
    }

    // Agregar una nueva tarea
    public void addTodo(String description) {
        String query = "INSERT INTO todos (description, completed) VALUES (?, FALSE)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, description);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar una tarea por ID
    public void removeTodo(int id) {
        String query = "DELETE FROM todos WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar el estado de una tarea
    public void updateTodoStatus(int id, boolean completed) {
        String query = "UPDATE todos SET completed = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setBoolean(1, completed);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
