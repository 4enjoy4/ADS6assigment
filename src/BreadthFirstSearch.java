import java.util.*;

public class BreadthFirstSearch<V> {
    private WeightedGraph<V> graph;

    // Constructs a BreadthFirstSearch object with the specified graph.
    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    // Performs a breadth-first search starting from the specified source vertex.
    public void breadthFirstSearch(Vertex<V> source) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            List<Edge<Vertex<V>>> neighbors = graph.getNeighbors(currentVertex);
            for (Edge<Vertex<V>> edge : neighbors) {
                Vertex<V> neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }
}


