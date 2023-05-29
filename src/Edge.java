public class Edge<T> {
    private T destination;
    private double weight;

    // Constructs an Edge object with the given destination and weight.
    public Edge(T destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    // Returns the destination of the edge.
    public T getDestination() {
        return destination;
    }

    // Returns the weight of the edge.
    public double getWeight() {
        return weight;
    }
}


