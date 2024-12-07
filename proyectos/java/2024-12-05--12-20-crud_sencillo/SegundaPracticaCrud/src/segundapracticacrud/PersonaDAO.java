package segundapracticacrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonaDAO {
    // Insertar persona con departamento_id
    public boolean insertar(Persona p){
        String sql = "INSERT INTO persona (nombre, apellido, departamento_id) VALUES (?,?,?)";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getDepartamento().getId());
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar persona con departamento_id
    public boolean actualizar(Persona p){
        String sql = "UPDATE persona SET nombre = ?, apellido = ?, departamento_id = ? WHERE id = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getDepartamento().getId());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar persona (sin cambios)
    public boolean eliminar(int id){
        String sql = "DELETE FROM persona WHERE id = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // Listar personas incluyendo departamento
    public List<Persona> listar(){
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.nombre, p.apellido, d.id AS dept_id, d.nombre AS dept_nombre " +
                     "FROM persona p LEFT JOIN departamento d ON p.departamento_id = d.id";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Departamento d = new Departamento();
                d.setId(rs.getInt("dept_id"));
                d.setNombre(rs.getString("dept_nombre"));

                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDepartamento(d);
                lista.add(p);
            }
        } catch(SQLException e){
            e.printStackTrace();            
        }
        return lista;
    }

    // Buscar persona por ID incluyendo departamento
    public Persona buscarPorId(int id){
        String sql = "SELECT p.id, p.nombre, p.apellido, d.id AS dept_id, d.nombre AS dept_nombre " +
                     "FROM persona p LEFT JOIN departamento d ON p.departamento_id = d.id " +
                     "WHERE p.id = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Departamento d = new Departamento();
                    d.setId(rs.getInt("dept_id"));
                    d.setNombre(rs.getString("dept_nombre"));

                    Persona p = new Persona();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setApellido(rs.getString("apellido"));
                    p.setDepartamento(d);
                    return p;
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
