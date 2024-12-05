package Datos;

import Entidad.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Método para guardar un usuario
    public int saveUser(User user) {
        int status = 0;
        String sql = "INSERT INTO users(name, email, country, role_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getRoleId()); // Nuevo campo
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    // Método para actualizar un usuario
    public int updateUser(User user) {
        int status = 0;
        String sql = "UPDATE users SET name=?, email=?, country=?, role_id=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getRoleId()); // Nuevo campo
            ps.setInt(5, user.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    // Método para eliminar un usuario
    public int deleteUser(int id) {
        int status = 0;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Método para obtener todos los usuarios
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT u.*, r.role_name FROM users u LEFT JOIN roles r ON u.role_id = r.role_id";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                user.setRoleId(rs.getInt("role_id"));
                user.setRoleName(rs.getString("role_name")); // Nombre del rol
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    // Método para obtener un usuario por ID
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT u.*, r.role_name FROM users u LEFT JOIN roles r ON u.role_id = r.role_id WHERE u.id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setCountry(rs.getString("country"));
                    user.setRoleId(rs.getInt("role_id"));
                    user.setRoleName(rs.getString("role_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
