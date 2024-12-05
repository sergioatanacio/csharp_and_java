package Datos;

import Entidad.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

    // Método para guardar un rol
    public int saveRole(Role role) {
        int status = 0;
        String sql = "INSERT INTO roles(role_name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, role.getRoleName());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Método para actualizar un rol
    public int updateRole(Role role) {
        int status = 0;
        String sql = "UPDATE roles SET role_name=? WHERE role_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, role.getRoleName());
            ps.setInt(2, role.getRoleId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Método para eliminar un rol
    public int deleteRole(int roleId) {
        int status = 0;
        String sql = "DELETE FROM roles WHERE role_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, roleId);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Método para obtener todos los roles
    public List<Role> getAllRoles() {
        List<Role> list = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Role role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                list.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Método para obtener un rol por ID
    public Role getRoleById(int roleId) {
        Role role = null;
        String sql = "SELECT * FROM roles WHERE role_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, roleId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    role = new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    role.setRoleName(rs.getString("role_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
