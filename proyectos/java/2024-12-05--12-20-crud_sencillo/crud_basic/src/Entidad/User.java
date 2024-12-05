package Entidad;

public class User {
    private int id;
    private String name;
    private String email;
    private String country;
    private int roleId;      // Nuevo atributo
    private String roleName; // Para mostrar el nombre del rol

    // Constructor vacío
    public User() {}

    // Constructor con parámetros
    public User(int id, String name, String email, String country, int roleId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.roleId = roleId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public void setId(int id) {
		this.id = id;
	}

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    
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
    
    
    
}
