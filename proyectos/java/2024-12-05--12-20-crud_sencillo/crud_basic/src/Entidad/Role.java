package Entidad;

public class Role {
    private int roleId;
    private String roleName;

    // Constructor vacío
    public Role() {}

    // Constructor con parámetros
    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Getters y Setters
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // Método para representar el objeto como cadena (útil para el JComboBox)
    @Override
    public String toString() {
        return roleName;
    }
}
