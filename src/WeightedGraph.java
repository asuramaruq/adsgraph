import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new Vertex<>(v));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjacent(new Vertex<>(dest),weight);

        if (undirected)
            map.get(dest).addAdjacent(new Vertex<>(source),weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).countAdjacent();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(new Vertex<>(dest));
    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        return map.get(v).getAdjacent();
    }
    public Vertex<V> getVertex(V v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }
}