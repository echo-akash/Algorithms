package prim;

import java.util.ArrayList;
import java.util.Scanner;

public class Prim {

    int Graph[][];          //matrix to store graph
    int parent[];
    int key[];
    boolean visitted[];     //indication array(bool type) whether vertex is visitted or not
    int vertex;
    int edges;

    //Constructor
    public Prim(int vertex, int edges) {
        Graph = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                Graph[i][j] = 0;
            }
        }

        this.vertex = vertex;
        this.edges = edges;
        parent = new int[vertex];
        key = new int[vertex];
        visitted = new boolean[vertex];

    }

    public void graph_input() {
        System.out.println("Draw Graph");
        Scanner graph_scan = new Scanner(System.in);
        for (int i = 0; i < edges; i++) {
            int x, y, z;
            x = graph_scan.nextInt();
            y = graph_scan.nextInt();
            z = graph_scan.nextInt();
            Graph[x][y] = z;
            Graph[y][x] = z;
        }
    }

    public int minimum_vertex() {
        int temp_min = 9999;    //infinity
        int index_of_min = 0;       //variable to store index of minimum vertex
        for (int i = 0; i < vertex; i++) {
            if (visitted[i] == false && key[i] < temp_min) {
                temp_min = key[i];
                index_of_min = i;
            }
        }
        return index_of_min;
    }

    public void do_prim() {

        for (int i = 0; i < vertex; i++) {
            key[i] = 9999;          //infinity
            visitted[i] = false;    //means none of the vertices have visitted
        }

        parent[0] = -1;  //means first er tar kono parent nai
        key[0] = 0;      //since ekn theke start so its key made zero

        int count_vertex_prim = 0;          //variable to control operation and count vertex in prim

        while (count_vertex_prim < vertex - 1) {    //since number of vertex in prim mst will be less than 1 of total vertex of main graph
            int temp = minimum_vertex();        //variable temp contains the index of minimum vertex
            visitted[temp] = true;              //extracted and visitted

            for (int i = 0; i < vertex; i++) {
                if (Graph[temp][i] != 0 && visitted[i] == false && Graph[temp][i] < key[i]) {   //if weight to next vertex is lesser than key
                    parent[i] = temp;       //then that vertex will get the previously got min vertex as parent
                    key[i] = Graph[temp][i];        //nd its key will get the weight of that min vertex to the next vertex
                }
            }

            count_vertex_prim++;
        }

    }

    public void print_prim() {
        System.out.println("Prim_Edges_");
        for (int i = 1; i < vertex; i++) {

            System.out.println(Graph[i][parent[i]]);        //the edges included in prim mst is printed
        }
    }

    public static void main(String[] args) {

        Scanner p_scan = new Scanner(System.in);

        System.out.println("Number of edges_");
        int vertex = p_scan.nextInt();

        System.out.println("Number of edges_");
        int edges = p_scan.nextInt();

        Prim p = new Prim(vertex, edges);

        //input
        p.graph_input();

        //main prim task
        p.do_prim();

        //print prim mst
        p.print_prim();

    }

}
