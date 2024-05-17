package main.java.util;

import java.util.*;

public class Graph<V> {
    //un hashmap es como una estanteria cada cajon tiene un valor y cada valor una llave , con la llave accedes al valor 
    // Lista de adyacencia:forma de representar un grafo en el que sus vertices tienen asociada una lista con sus adyacentes
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /**
     * Añade un vértice al grafo si no está presente y si lo esta no hace nada .
     *
     * @param v el vértice a añadir.
     * @return `true` si el vértice se añadió correctamente, `false` si ya estaba presente.
     */
    //la V es el tipo (vertex) y la v seria el nombre dle parametro que se va a meter 
    public boolean addVertex(V v) {
        if (!adjacencyList.containsKey(v)) { // Verifica si el vértice ya está presente
            //aqui ha metido un nuevo cajon con clave v que guarda el valor de sus vertices adyacentes
            adjacencyList.put(v, new HashSet<>()); // Añade el vértice al mapa
            return true; // Indica que se añadió el vértice correctamente
        }
        return false; // Indica que el vértice ya estaba presente
    }

    /**
     * Añade un arco entre dos vértices al grafo. Si alguno de los vértices no está presente, se añade.
     *
     * @param v1 el primer vértice.
     * @param v2 el segundo vértice.
     * @return `true` si se añadió el arco correctamente, `false` si el arco ya estaba presente.
     */
    public boolean addEdge(V v1, V v2) {
        this.addVertex(v1); // Añade el primer vértice si no está presente
        this.addVertex(v2); // Añade el segundo vértice si no está presente
        if (!adjacencyList.get(v1).contains(v2)) { // Verifica si el arco ya está presente
            adjacencyList.get(v1).add(v2); // Añade el arco desde v1 a v2
            adjacencyList.get(v2).add(v1); // Añade el arco desde v2 a v1 (grafo no dirigido)
            return true; // Indica que se añadió el arco correctamente
        }
        return false; // Indica que el arco ya estaba presente
    }

    /**
     * Obtiene el conjunto de vértices adyacentes a un vértice dado.
     *
     * @param v el vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     */
    public Set<V> obtainAdjacents(V v) {
        //getordefault lo que hace es que si no encuentra la clave v en el mapa devuelve un conjunto vacio y si la encuentra de la lista de adyacentes
        return adjacencyList.getOrDefault(v, Collections.emptySet()); // Retorna los vértices adyacentes o un conjunto vacío si el vértice no está presente
    }

    /**
     * Comprueba si el grafo contiene el vértice dado.
     *
     * @param v el vértice para el que se realiza la comprobación.
     * @return `true` si el vértice está presente en el grafo, `false` si no lo está.
     */
    public boolean containsVertex(V v) {
        return true && adjacencyList.containsKey(v); // Verifica si el vértice está presente en el mapa
    }

    /**
     * Método `toString()` reescrito para la clase `Graph`.
     *
     * @return una cadena de caracteres con la lista de adyacencia del grafo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V v : adjacencyList.keySet()) {
            sb.append(v.toString()).append(": ").append(adjacencyList.get(v).toString()).append("\n"); 
            // Construye la representación de cadena de la lista de adyacencia
        }
        return sb.toString();
    }

    /**
     * Obtiene el camino más corto entre dos vértices en el grafo utilizando BFS.
     * 
     * @param v1 el vértice de origen.
     * @param v2 el vértice de destino.
     * @return lista con la secuencia de vértices del camino más corto entre `v1` y `v2`, o `null` si no existe un camino.
     **/
    public List<V> shortestPath(V v1, V v2) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return null; // Si alguno de los vértices no está presente, no hay camino
        }

        //la linked list guarda nodos que tienen un valor y un puntero al siguiente nodo
        Queue<V> queue = new LinkedList<>();
        //el predecesor de ese vertice
        Map<V, V> predecessors = new HashMap<>();
        Set<V> visited = new HashSet<>();

        queue.add(v1);
        visited.add(v1);
        predecessors.put(v1, null); // El vértice de inicio no tiene predecesor

        //mientras la cola no este vacia
        while (!queue.isEmpty()) {
            //poll devuelve el primer elemento de la cola y lo elimina
            V current = queue.poll();

            if (current.equals(v2)) {
                return buildPath(predecessors, v2); // Si se encuentra el vértice de destino, construye el camino y lo retorna
            }

            for (V neighbor : obtainAdjacents(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    predecessors.put(neighbor, current);
                }
            }
        }
        return null; // No se encontró camino
    }

    // Método privado para construir el camino a partir de los predecesores
    private List<V> buildPath(Map<V, V> predecessors, V goal) {
        LinkedList<V> path = new LinkedList<>();
        for (V v = goal; v != null; v = predecessors.get(v)) {
            path.addFirst(v); // Agrega el vértice al principio de la lista para obtener el camino en orden correcto
        }
        return path;
    }
}
