package greedyproblems;


import java.util.Scanner;

public class AllPairShortestPath {

    public static final int INFINITY = 1 << 30;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices = input.nextInt();
        int edges = input.nextInt();
        int adjMatrix[][] = new int[vertices + 1][vertices + 1];

        for (int i = 1; i < adjMatrix.length; i++) {
            for (int j = 1; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = INFINITY;
            }
            adjMatrix[i][i] = 0;

        }
        for (int i = 0; i < edges; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int length = input.nextInt();
            adjMatrix[u][v] = length;
        }
        for (int k = 1; k < adjMatrix.length; k++) {
            for (int i = 1; i < adjMatrix.length; i++) {
                for (int j = 1; j < adjMatrix.length; j++) {
                        
                    adjMatrix[i][j] = 
                            Math.min(adjMatrix[i][j], 
                                    adjMatrix[i][k] + adjMatrix[k][j]);
                }

            }

        }
        
        System.out.println("OUTPUT\n\n\n");
        for (int i = 1; i < adjMatrix.length; i++) {
            for (int j = 1; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] +" ");
                
            }
            System.out.println("");
        }

    }

}

/*
3
5
1 2 4
1 3 11
2 3 2
2 1 6
3 1 3


 */
