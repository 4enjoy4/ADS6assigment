import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;


public class Vertex<V> {
    private V data;
    //Constructs a vertex with the specified data.
    public Vertex(V data) {
        this.data = data;
    }
    //Returns the data stored in the vertex.
    public V getData() {
        return data;
    }
    //Compares this vertex to the specified object. The result is true if and only if the argument is a Vertex object
    //and both objects have equal data values.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }
    //Returns a hash code value for the vertex based on its data value.
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
    //Returns a string representation of the vertex, which is the string representation of its data.
    @Override
    public String toString() {
        return data.toString();
    }
}


