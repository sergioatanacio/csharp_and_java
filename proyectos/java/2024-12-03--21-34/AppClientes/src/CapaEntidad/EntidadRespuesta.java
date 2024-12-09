package CapaEntidad;

import java.util.List;

public class EntidadRespuesta<T> {
    private boolean success; // Indica si la operación fue exitosa (true) o fallida (false)
    private String mensaje;  // Mensaje descriptivo del resultado
    private List<T> datos;   // Datos opcionales, puede contener una lista de objetos genéricos

    // Constructor por defecto
    public EntidadRespuesta() {}

    // Constructor con parámetros
    public EntidadRespuesta(boolean success, String mensaje, List<T> datos) {
        this.success = success;
        this.mensaje = mensaje;
        this.datos = datos;
    }

    // Getters y Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<T> getDatos() {
        return datos;
    }

    public void setDatos(List<T> datos) {
        this.datos = datos;
    }

    // Método para mostrar información como texto
    @Override
    public String toString() {
        return "EntidadRespuesta{" +
                "success=" + success +
                ", mensaje='" + mensaje + '\'' +
                ", datos=" + datos +
                '}';
    }
}



/* 
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntidadRespuesta<String> respuesta = new EntidadRespuesta<>();
        respuesta.setSuccess(true);
        respuesta.setMensaje("Operación realizada con éxito");
        respuesta.setDatos(Arrays.asList("Objeto1", "Objeto2", "Objeto3"));

        System.out.println(respuesta);
    }
}
*/