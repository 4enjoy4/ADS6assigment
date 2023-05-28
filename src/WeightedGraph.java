import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> map;

    public WeightedGraph() {
        map = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        validateVertex(source);
        validateVertex(destination);

        List<Edge<Vertex<V>>> edges = map.get(source);
        edges.add(new Edge<>(destination, weight));

        // If it's a directed graph, comment the line below
        map.get(destination).add(new Edge<>(source, weight));
    }

    public List<Edge<Vertex<V>>> getNeighbors(Vertex<V> vertex) {
        validateVertex(vertex);
        return map.get(vertex);
    }

    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }

    public void printGraph() {
        for (Vertex<V> vertex : map.keySet()) {
            System.out.print("Vertex " + vertex + " connected to: ");
            List<Edge<Vertex<V>>> edges = map.get(vertex);
            for (Edge<Vertex<V>> edge : edges) {
                System.out.print(edge.getDestination() + " (Weight: " + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    private void validateVertex(Vertex<V> vertex) {
        if (!map.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is not in the graph.");
        }
    }
}
