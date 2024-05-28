package classes;

import classes.interfaces.GraphInterface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<Vertex> implements GraphInterface<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<MyEdge<Vertex>>> map;

    public WeightedGraph(){
        this(true);
    }

    public WeightedGraph(boolean undirected){
        this.undirected = undirected;
        map = new HashMap<>();
    }

    @Override
    public void addVertex(Vertex v) {
        if(hasVertex(v)) return;

        map.put(v, new LinkedList<>());
    }

    @Override
    public void addEdge(Vertex s, Vertex d) {
        throw new UnsupportedOperationException("addEdge(classes.Vertex, classes.Vertex) not supported for weighted graph. Use addEdge(classes.Vertex, classes.Vertex, Double).");
    }

    public void addEdge(Vertex s, Vertex d, Double weight){
        if(!hasVertex(s)) addVertex(s);
        if(!hasVertex(d)) addVertex(d);

        if(hasEdge(s, d) || s.equals(d)) return;

        map.get(s).add(new MyEdge<>(s, d, weight));
        if(undirected) map.get(d).add(new MyEdge<>(d, s, weight));
    }

    @Override
    public int getVerticesCount() {
        return map.size();
    }

    @Override
    public int getEdgesCount() {
        int count = 0;
        for(Vertex v : map.keySet()) count += map.get(v).size();
        return undirected ? count / 2 : count;
    }

    @Override
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    @Override
    public boolean hasEdge(Vertex s, Vertex d) {
        if(!hasVertex(s)) return false;
        return map.get(s).contains(new MyEdge<>(s, d));
    }

    @Override
    public List<Vertex> adjacencyList(Vertex v) {
        if(!hasVertex(v)) return null;

        List<Vertex> vertices = new LinkedList<>();
        for(MyEdge<Vertex> e : map.get(v)) vertices.add(e.getDest());

        return vertices;
    }

    public Iterable<MyEdge<Vertex>> getEdges(Vertex v) {
        if(!hasVertex(v)) return null;

        return map.get(v);
    }
}
