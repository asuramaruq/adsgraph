import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>,Double> adjacent;
    public Vertex(V data){
        this.data=data;
        adjacent=new HashMap<>();
    }
    public Double getWeight(Vertex<V> v){
        return adjacent.get(v);
    }
    public void addAdjacent(Vertex<V> dest, double weight){
        this.adjacent.put(dest, weight);
    }
    public Iterable<V> getAdjacent(){
        List<V> list=new LinkedList<>();
        for(var v : adjacent.keySet()){
            list.add(v.data);
        }
        return list;
    }
    public int countAdjacent(){
        return this.adjacent.size();
    }
    public boolean contains(Vertex<V> vert){
        return adjacent.containsKey(vert);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(data, vertex.data);
    }
    @Override
    public int hashCode(){
        return Objects.hash(data);
    }
}
