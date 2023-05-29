import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;


public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge<>(destination, weight));
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge<>(source, weight));
    }

    public List<Edge<Vertex<V>>> getNeighbors(Vertex<V> vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public List<Vertex<V>> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }
}
