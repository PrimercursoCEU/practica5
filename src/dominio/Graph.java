import java.util.*;

public class Graph<V> {
    // Lista de adyacencia.
    private Map<V, Map<V, Integer>> adjacencyList = new HashMap<>();

    // Añade el vértice `v` al grafo.
    public boolean addVertex(V v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new HashMap<>());
            return true;
        }
        return false;
    }

    // Añade un arco entre los vértices `v1` y `v2` al grafo.
    public boolean addEdge(V v1, V v2, int weight) {
        addVertex(v1);
        addVertex(v2);
        adjacencyList.get(v1).put(v2, weight);
        adjacencyList.get(v2).put(v1, weight); // Para grafos no dirigidos
        return true;
    }

    // Obtiene el conjunto de vértices adyacentes a `v`.
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (adjacencyList.containsKey(v)) {
            return adjacencyList.get(v).keySet();
        }
        throw new Exception("Vertex not found");
    }

    // Comprueba si el grafo contiene el vértice dado.
    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    // Método `toString` para la clase `Grafo`.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<V, Map<V, Integer>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    // Obtiene, en caso de que exista, el camino más corto entre `v1` y `v2`.
    public List<V> shortestPath(V v1, V v2) {
        Map<V, Integer> distances = new HashMap<>();
        Map<V, V> previous = new HashMap<>();
        PriorityQueue<V> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<V> visited = new HashSet<>();

        // Inicialización
        for (V vertex : adjacencyList.keySet()) {
            if (vertex.equals(v1)) {
                distances.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            previous.put(vertex, null);
            queue.add(vertex);
        }

        // Algoritmo de Dijkstra
        while (!queue.isEmpty()) {
            V u = queue.poll();
            visited.add(u);
            for (V v : adjacencyList.get(u).keySet()) {
                if (visited.contains(v)) {
                    continue;
                }
                int alt = distances.get(u) + adjacencyList.get(u).get(v);
                if (alt < distances.get(v)) {
                    distances.put(v, alt);
                    previous.put(v, u);
                    queue.remove(v);
                    queue.add(v);
                }
            }
        }

        // Reconstruir el camino más corto
        List<V> path = new LinkedList<>();
        V u = v2;
        while (previous.get(u) != null) {
            path.add(0, u);
            u = previous.get(u);
        }
        if (path.isEmpty() || !path.get(0).equals(v1)) {
            return null; // No hay camino desde v1 a v2
        }
        path.add(0, v1);
        return path;
    }

    
}
