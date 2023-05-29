import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
public class DijkstraSearch<V> {
    private WeightedGraph<V> graph;
    private Map<Vertex<V>, Vertex<V>> previous;

    // Constructs a DijkstraSearch object with the specified weighted graph.
    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
        this.previous = new HashMap<>();
    }

    // Finds the shortest paths from a source vertex to all other vertices in the graph using Dijkstra's algorithm.
    public Map<Vertex<V>, Double> shortestPaths(Vertex<V> source) {
        Map<Vertex<V>, Double> distance = new HashMap<>();
        PriorityQueue<DijkstraNode<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(DijkstraNode::getDistance));

        // Initialization
        for (Vertex<V> vertex : graph.getVertices()) {
            if (vertex.equals(source))
                distance.put(vertex, 0.0);
            else
                distance.put(vertex, Double.POSITIVE_INFINITY);
            previous.put(vertex, null);
            priorityQueue.add(new DijkstraNode<>(vertex, distance.get(vertex)));
        }

        // Dijkstra's algorithm
        while (!priorityQueue.isEmpty()) {
            DijkstraNode<V> current = priorityQueue.poll();
            Vertex<V> currentVertex = current.getVertex();
            double currentDistance = current.getDistance();

            if (currentDistance > distance.get(currentVertex))
                continue;

            List<Edge<Vertex<V>>> neighbors = graph.getNeighbors(currentVertex);
            for (Edge<Vertex<V>> edge : neighbors) {
                Vertex<V> neighbor = edge.getDestination();
                double newDistance = currentDistance + edge.getWeight();

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, currentVertex);
                    priorityQueue.add(new DijkstraNode<>(neighbor, newDistance));
                }
            }
        }

        return distance;
    }

    // Retrieves the shortest path from a source vertex to a destination vertex.
    public List<Vertex<V>> shortestPathTo(Vertex<V> source, Vertex<V> destination) {
        Map<Vertex<V>, Double> distance = shortestPaths(source);
        List<Vertex<V>> path = new ArrayList<>();

        Vertex<V> current = destination;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);

        return path;
    }

    private class DijkstraNode<T> implements Comparable<DijkstraNode<T>> {
        private Vertex<T> vertex;
        private double distance;

        // Constructs a DijkstraNode object with the specified vertex and distance.
        public DijkstraNode(Vertex<T> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        // Returns the vertex associated with this DijkstraNode.
        public Vertex<T> getVertex() {
            return vertex;
        }

        // Returns the distance from the source vertex to the associated vertex.
        public double getDistance() {
            return distance;
        }

        // Compares this DijkstraNode with another DijkstraNode based on their distances.
        @Override
        public int compareTo(DijkstraNode<T> other) {
            return Double.compare(distance, other.distance);
        }
    }
}







