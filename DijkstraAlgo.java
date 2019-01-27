package labworkswing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Vertex {

    int node;
    long distance;
    int parent;
}

public class DijkstraAlgo {

    int V;
    int E;
    int adjacencyMatrix[][];
    Vertex vertices[];
    ArrayList<Vertex> result;

    Queue<Vertex> minPQ;

    public DijkstraAlgo(int V, int E) {
        this.V = V;
        this.E = E;
        adjacencyMatrix = new int[V][V];
        vertices = new Vertex[V];
    }

    public void initializeSingleSource(int src) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex();
            vertices[i].distance = Integer.MAX_VALUE;
            vertices[i].parent = -1;

        }
        vertices[src].distance = 0;
    }

    public void findSSSP(int src) {
        initializeSingleSource(src);
        result = new ArrayList();

        minPQ = new PriorityQueue<>(V, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return (int) (o1.distance - o2.distance);
            }
        });

        for (int i = 0; i < vertices.length; i++) {
            minPQ.add(vertices[i]);

        }

        while (!minPQ.isEmpty()) {
            Vertex u = minPQ.poll();
            result.add(u);

            for (int v = 0; v < adjacencyMatrix[u.node].length; v++) {
                if (adjacencyMatrix[u.node][v] == 0) {
                    continue;
                }
                
                relax(u.node, v);

            }
        }

    }

    public void relax(int u, int v) {

        if(vertices[v].distance > vertices[u].distance + adjacencyMatrix[u][v]){
            vertices[v].distance = vertices[u].distance + adjacencyMatrix[u][v];
            vertices[v].parent = u; 
        }
    }

    public static void main(String[] args) {

    }

}
