package segundapracticacrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    public List<Departamento> listar() {
        List<Departamento> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM departamento";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
