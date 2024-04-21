package aplicacion;
import dominio.Graph;
import java.util.List;

public class Principal{

    // Prueba del método shortestPath
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2, 7);
        g.addEdge(1, 3, 9);
        g.addEdge(1, 6, 14);
        g.addEdge(2, 3, 10);
        g.addEdge(2, 4, 15);
        g.addEdge(3, 4, 11);
        g.addEdge(3, 6, 2);
        g.addEdge(4, 5, 6);
        g.addEdge(5, 6, 9);
        System.out.println("Graph:");
        System.out.println(g);

        // Probando el método shortestPath
        System.out.println("Shortest path from 1 to 5:");
        List<Integer> shortestPath = g.shortestPath(1, 5);
        System.out.println(shortestPath);
    }
}