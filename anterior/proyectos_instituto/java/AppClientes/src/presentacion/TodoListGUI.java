package presentacion;

import negocio.TodoService;
import entidad.TodoItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TodoListGUI extends JFrame {
    private TodoService todoService;
    private DefaultListModel<String> listModel;
    private JList<String> todoList;
    private JTextField inputField;
    private JButton addButton;
    private JButton removeButton;
    private JButton toggleButton;

    public TodoListGUI() {
        todoService = new TodoService();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("To-Do List");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Lista de tareas
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);
        todoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(todoList);
        panel.add(listScrollPane, BorderLayout.CENTER);

        // Panel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        addButton = new JButton("Agregar");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        removeButton = new JButton("Eliminar");
        toggleButton = new JButton("Marcar/Desmarcar");
        buttonPanel.add(toggleButton);
        buttonPanel.add(removeButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        // Eventos
        addButton.addActionListener(e -> addTodo());
        removeButton.addActionListener(e -> removeTodo());
        toggleButton.addActionListener(e -> toggleTodo());

        // Doble clic para marcar/desmarcar
        todoList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    toggleTodo();
                }
            }
        });

        refreshList();
    }

    private void addTodo() {
        String description = inputField.getText();
        if (description != null && !description.trim().isEmpty()) {
            todoService.addTodo(description);
            inputField.setText("");
            refreshList();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una descripción válida.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void removeTodo() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            TodoItem item = todoService.getAllTodos().get(selectedIndex);
            todoService.removeTodo(item.getId());
            refreshList();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para eliminar.", "Sin Selección", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void toggleTodo() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            TodoItem item = todoService.getAllTodos().get(selectedIndex);
            todoService.toggleTodoStatus(item.getId());
            refreshList();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para marcar/desmarcar.", "Sin Selección", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void refreshList() {
        List<TodoItem> todos = todoService.getAllTodos();
        listModel.clear();
        for (TodoItem item : todos) {
            listModel.addElement(item.toString());
        }
    }
}
