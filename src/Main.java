import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph(8);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(6, 7);
        myGraph.addEdge(0, 2);
        myGraph.printEdge();
        System.out.println(myGraph.HaveEdge(2,3));
        System.out.println(myGraph.getNeighbor(2));
        myGraph.DFS(2);
        WeightedGraph<String> graph = new WeightedGraph<>();
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexA, vertexC, 2);
        graph.addEdge(vertexB, vertexD, 3);
        graph.addEdge(vertexC, vertexD, 1);
        graph.addEdge(vertexC, vertexE, 4);
        graph.addEdge(vertexD, vertexE, 2);

        DijkstraSearch<String> dijkstraSearch = new DijkstraSearch<>(graph);

        // Find shortest paths from vertex A to all other vertices
        Vertex<String> source = vertexA;
        Map<Vertex<String>, Double> distances = dijkstraSearch.shortestPaths(source);
        System.out.println("Shortest paths from " + source + ":");
        for (Vertex<String> vertex : graph.getVertices()) {
            double distance = distances.get(vertex);
            System.out.println("To " + vertex + ": " + distance);
        }

        // Find shortest path from vertex A to vertex E
        Vertex<String> destination = vertexE;
        List<Vertex<String>> shortestPath = dijkstraSearch.shortestPathTo(source, destination);
        System.out.println("Shortest path from " + source + " to " + destination + ":");
        for (Vertex<String> vertex : shortestPath) {
            System.out.print(vertex + " ");
        }
    }
}