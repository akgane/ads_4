import java.util.List;

public class MyApplication {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();

        graph.addVertex("Astana");
        graph.addVertex("Almaty");
        graph.addVertex("Karaganda");
        graph.addVertex("Pavlodar");
        graph.addVertex("Shymkent");
        graph.addVertex("Semey");

        graph.addEdge("Astana", "Almaty");
        graph.addEdge("Karaganda", "Astana");
        graph.addEdge("Semey", "Pavlodar");
        graph.addEdge("Shymkent", "Semey");
        graph.addEdge("Shymkent", "Astana");

        System.out.println(graph.hasEdge("Astana", "Shymkent"));
        System.out.println(graph.hasEdge("Astana", "Almaty"));
        System.out.println(graph.hasEdge("Karaganda", "Pavlodar"));
    }
}
