import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;


public class Vertex<V> {
    private V data;

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}


