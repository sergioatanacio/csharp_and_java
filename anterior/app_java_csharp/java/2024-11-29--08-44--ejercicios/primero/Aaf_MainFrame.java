import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear un arreglo multidimensional 3D
        int[][][] array3D = {
            {
                {1, 2, 3},
                {4, 5, 6}
            },
            {
                {7, 8, 9},
                {10, 11, 12}
            }
        };

        // Imprimir el contenido del arreglo tridimensional con Arrays.deepToString()
        System.out.println(Arrays.deepToString(array3D));
    }
}
/**
public class Main {
    public static void main(String[] args) {
        System.out.println("Inicio del programa");

        // Llamar a un método que luego decide detener la ejecución
        stopExecution();

        System.out.println("Este código no se ejecutará.");
    }

    public static void stopExecution() {
        System.out.println("Deteniendo la ejecución...");
        System.exit(0);  // Detiene todo el programa
    }
}
 */