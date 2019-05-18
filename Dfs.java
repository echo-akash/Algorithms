/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs;

import java.util.LinkedList;

/**
 *
 * @author akash
 */
class Graph {

    int v, t = 0;
    LinkedList<Integer> adj[];
    boolean[] visited;
    int[] p;        //parent
    int[] d;        //STarting distance
    int[] f;        //ending distance

    public Graph(int v) {       //code to make graph
        this.v = v;
        visited = new boolean[v];
        p = new int[v];
        d = new int[v];
        f = new int[v];
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int u, int v) {        //add edge to graph
        adj[u].add(v);
    }

    void DFS(int u) {
        if (visited[u] == true) {       //sice visitted so dnt go
            return;
        }

        visited[u] = true;          

        t = t + 1;          

        d[u] = t;           //discovery timing

        System.out.println(u + " ");

        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);

            
            if (visited[v] == false) {
                DFS(v);             //since visit not, so go to dfs to visit
            }

        }
        t = t + 1;
        f[u] = t;       //final timing after finishing event

    }

}

public class Dfs {


    public static void main(String[] args) {

        Graph g = new Graph(14);

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(1, 8);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.addEdge(8, 4);
        g.addEdge(8, 7);
        g.addEdge(6, 7);
        g.addEdge(6, 8);
        g.addEdge(6, 5);
        g.addEdge(7, 4);
        g.addEdge(5, 4);

        System.out.println("DFS--");

        for (int i = 1; i <= 8; i++) {
            g.DFS(i);
        }

        for (int i = 1; i <= 8; i++) {
            System.out.println(i + " " + g.d[i] + " " + g.f[i]);
        }

    }

}
