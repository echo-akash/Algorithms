/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author akash
 */




public class Bfs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n=8;          //number of vertices
      
        LinkedList <Integer> adj[];         //create adjacency list for graph
        adj = new LinkedList[n];
        
        for (int i=0; i<n; ++i)
            adj[i] = new LinkedList();
        
        
        
        adj[1].add(2);          //add edge
        adj[1].add(4);
        adj[2].add(3);
        adj[2].add(5);
        adj[3].add(5);
        adj[4].add(3);
        adj[4].add(5);
        adj[5].add(4);
        adj[6].add(3);
        adj[6].add(7);
        adj[7].add(3);
        
        int s=1;        //source
        
        int parent[] = new int[100];
        int dist[] = new int[100];
    //    int color[] = new int[10];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=n;i++)
        {
            if(n!=1)
            {
                parent[i]=0;        //
                dist[i]=-1;         //infinity is -1
            }
        }
        
        
        parent[s]=0;    
        dist[s]=0;   
        
        q.add(s);
        
        while(!q.isEmpty()){
            int x = q.peek();
            q.poll();
            
            for(int j=0;j<adj[x].size();j++)
            {
                int v = adj[x].get(j);
                if(parent[v]==0)
                {
                    dist[v]=dist[x]+1;
                    parent[v]=x;
                    q.add(v);
                }
            }
       
        }
        
        for(int i=1;i<=n;i++)   
        {
            System.out.println("Vertex=" + i);
            System.out.println("Parent=" + parent[i]);
            System.out.println("Distace=" + dist[i]);
           
        }  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
