import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;


public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> adjacencyList;

    // Constructs an empty WeightedGraph object.
    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Adds a vertex to the graph.
    public void addVertex(Vertex<V> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Adds a weighted edge between the source and destination vertices.
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge<>(destination, weight));
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge<>(source, weight));
    }

    // Returns the list of neighboring edges for the given vertex.
    public List<Edge<Vertex<V>>> getNeighbors(Vertex<V> vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    // Returns the list of vertices in the graph.
    public List<Vertex<V>> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }
}

