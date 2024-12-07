import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de listas de listas (List<List<List<Integer>>>)
        List<List<List<Integer>>> listOfLists3D = new ArrayList<>();
        
        // Crear sublistas más profundas
        List<List<Integer>> list2D1 = new ArrayList<>();
        list2D1.add(List.of(1, 2, 3));
        list2D1.add(List.of(4, 5, 6));
        
        List<List<Integer>> list2D2 = new ArrayList<>();
        list2D2.add(List.of(7, 8, 9));
        list2D2.add(List.of(10, 11, 12));
        
        listOfLists3D.add(list2D1);
        listOfLists3D.add(list2D2);
        
        // Imprimir el contenido de la lista de listas de listas usando toString()
        System.out.println(listOfLists3D);
    }
}
