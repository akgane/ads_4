import javax.management.openmbean.InvalidKeyException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<Vertex>> map = new HashMap<>();

    public MyGraph(){
        this(true);
    }
    public MyGraph(boolean undirected){
        this.undirected = undirected;
    }

    public void addVertex(Vertex v){
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest){
        if(!hasVertex(source)) addVertex(source);
        if(!hasVertex(dest)) addVertex(dest);

        if(hasEdge(source, dest) || source.equals(dest)) return;

        map.get(source).add(dest);

        if(undirected) map.get(dest).add(source);
    }

    public int getVerticesCount(){
        return map.size();
    }

    public boolean hasVertex(Vertex v){
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest){
        if(!hasVertex(source) || !hasVertex(dest)) return false;
        return map.get(source).contains(dest);
    }

    public List<Vertex> getNeighbours(Vertex v){
        if(!hasVertex(v)) throw new InvalidKeyException();
        return map.get(v);
    }

    //TODO: not finished
    public void removeVertex(Vertex v){
        if(!hasVertex(v)) throw new InvalidKeyException();
        if(undirected){
            for(Vertex neighbour : map.get(v)) map.get(neighbour).remove(v);
            map.remove(v);
        }
    }

    public Iterable<Vertex> adj(){
        return null;
    }
}
