public class Edge<T extends Vertex<?>> {
    private T destination;
    private double weight;

    public Edge(T destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public T getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}

// Search class (base class for different search algorithms)
abstract class Search<T extends Vertex<?>> {
    protected WeightedGraph<T> graph;

    public Search(WeightedGraph<T> graph) {
        this.graph = graph;
    }

    public abstract void search(T startVertex);
}

