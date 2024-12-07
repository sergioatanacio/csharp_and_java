package segundapracticacrud;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Departamento departamento; // Nuevo atributo
    
    public Persona(){        
    }    
    public Persona(int id, String nombre, String apellido, Departamento departamento){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
    }    
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public Departamento getDepartamento(){
        return this.departamento;
    }
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }
}
