package kruskal_by_sir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Kruskal_by_sir {
    
    ///declaring variable in this section works as global variable
    
    int V,E;                                ///declaring the number of edges and vertices globally                        
    
    Edge edges[];                           ///declaring arrays of Edge class
    
    ArrayList<Edge>result;                  ///Arraylist can be of user defined type, so here Edge is a user defined class or data type
                                            ///and result is an array list of user defined data type "Edge"
                                            ///Now We know array list is an array(dynamic)
                                            ///so the array list result is an array 
                                            ///result is not an array of integer or float
                                            ///its an array of edge
                                            ///so result[0] will be an edge, result[1] will be an edge
                                            ///result[0] will have 3 parts: src,dest,weight

   ArrayList<Set<Integer>> verticesSet;     ///Set<Integer> is an array of integer to think it easily
                                            ///its a dynamic array
                                            ///so you may imagine that, set is an array
                                            ///now back to the point of ArrayList. when you declare an ArrayList<Integer> it means, its an ArrayList of integer
                                            ///so when you declare ArrayList<  Set<Integer>  > it means,its an arrayList of a set
                                            ///so its like a 2D array when you declare an ArrayList of set<Integer>
                                            ///The Name of ArrayList< set <Integer> > is verticesSet
                                            ///so, verticesSet[0] will hold a set
                                            ///verticesSet[1] will hold a set and following
                                            ///you can also do it by a 2D array, but Arraylist of set will make the task easy
    
    
    
    
    
    
    ///Its The Constructor, parameters are number of nodes/vertices(int x) and numbers of edges(int y)
    public Kruskal_by_sir(int x, int y){
        V=x;
        E=y;
        edges=new Edge[E];
        result=new ArrayList();  ///result arrayList of Edge will contain the edges which will form the MST
    }
    
    
    
    ///readedges functio is written for taking the edges as input
    public void readEdges(){
        
        Scanner ob= new Scanner(System.in);  ///scanner ob for taking integer input
        
        
        
        ///in tthe loop will run for E times, which is the number of edges which and a global variable declared upper
        ///each execution takes 3 inputs s,d,w which are the source, destination, and weight of an edge
        for(int i=0; i<E; i++){    
            int s=ob.nextInt();
            int d=ob.nextInt();
            int w=ob.nextInt();
            
            
            ///e is a temporary object of Edge class
            Edge e= new Edge(s,d,w);  ///see the constructor of edge class below, first parameter as "source" or first vertex of edge, second parameter is "destination" or second vertex of edge, and 3rd parameter is the weight of edge
            edges[i]=e; ///ekhane edges[i] ke r new kora lagbe na,karon e already new kora ache, so edges[i] sei new kore thaka edge ke point korbe
        }
    }
    
    
    public void makeSet(){
        verticesSet= new ArrayList(V);    
        
        
        for(int i=0; i<V; i++){
            
            Set<Integer> vertices =new HashSet<>(); ///ekhane ekta ekta kore set banano hocche,then pura set dhore arraylist e push kora hobe 
            vertices.add(i); ///set er subidha holo set e kono element duibar push hoy na.eta set nijei maintain kore
            ///set er name: vertices
            
            verticesSet.add(vertices);  ///now set create hoye gache, set take arraylist e add kore dte hobe
            
            ///ekhane set er array dorkar nai, karon protibar iteration e "new" hocche
            
            ///How it is working?
            ///Ans: when i=0; a set named "vertices" will be created; set means 1D array
            ///so when i=0; i will be added at vertices[0]; means vertices[0]=0 hobe
            ///then vertices set ta ke "verticesSet" namok arrayList e add kore dewa holo permenantly
            ///important point is "vertices" and "verticesSet" is not same
            ///so as "vertices" is pushed in "verticesSet" , so verticesSet[0] te first set "vertices" push holo
            ///verticesSet[0]+vertics[0]=0 ke merge kore verticesSet[0][0]=0 banano hoy;its for easy thinking
            ///now when the loop will end for i=0; "vertices" set will be deleted as it is a local variable
            ///then next time, when i=1, another new set "vertices" will be created, and this is not the same set as before
            ///because the set is created in local scope
            ///now this time i=1 will be added in "vertces" set
            ///as it is a new set so again vertices[0] te value add hobe
            ///so vertices[0]=1 as i=1
            ///and verticesSet e again new ekta set push hobe
            ///as verticesSet is not a local variale, so for the next "add" its index will increase
            ///so for i=1 the new "vertices" set will be added in verticesSet[1] index
            ///so, verticesSet[1]+vertices[0]=1; will be merged as verticesSet[1][0]=1;
            ///so for the next simulations verticesSet[2][0]=2 hobe;
            ///verticesSet[3][0]=3 hobe
            ///so it means 0 er set e ekhon sudhu 0 ache
            ///1 er set e sudhu 1 ache
            ///2 er set e sudhu 2 ache  
            ///simulate it
        }
    }
    
    
    
    
    
    public void Union(int u, int v){
        
        
        ///initially jekono ekta number er set e sudhu se nijei thake
        ///union er maddhome kono ekta set er under e onno element der ke add kora hoy
        ///verticesSet[2] er kotha chinta kori, initialy verticesSet[2] er value teo ache 2; means verticesSet[2][0]=2
        ///Let,union er pore veticesSet[2] e verticesSet[3] add hoye jabe, [verticesSet[3][0]=3 ache initially]
        //so then verticesSet[2] will be like that -> verticesSet[2][0]=2, verticesSet[2][1]=3;
        ///and the verticesSet[3] er under e je set chilo take remove kore dite hobe, it will be done by remove function
        ///now jodi verticesSet[1] e verticesSet[2] ke add korte bola hoy, 
        ///then verticesSet[1] will look like that -> vertices[1][0]=1; vertices[1][1]=2; vertices[1][2]=3;
        ///and then vertices[2] will be removed
        
        

        ///ei duita vertex er master set duita ke merge korte hobe
        int uIndex= FindSet(u);
        int vIndex=FindSet(v);
        
        ///what does FindSet function do?
        ///definition of the function is given below
        ///let verticesSet[1][0]=1; verticesSet[1][1]=2; verticesSet[1][2]=3;
        ///if FindSet(3) is called it will return 1 ;means the main index of its Set
        ///if we consider 3 as a servant element and its index 1 as a master elemnt
        ///then FindSet takes servant as parameter and returns its master index
        
        
        
        
        ///addAll  merges two sets
        ///ArrayList e "get" function akj kore just like [] er moto
        ///Here verticesSet is an ArrayList; so verticesSet.get(0) likha ar verticesSet[0] likha eki kotha
        ///but code e vertices.get(0) e likhte hobe
        ///so nicher line er mane hocche verticesSet[uIndex] e verticesSet[vIndex] ke add kore dewa hoyeche
        
        verticesSet.get(uIndex). addAll (verticesSet.get(vIndex));
        
        
        ///it means->    uIndex er set e vIndex merge hoye gase
        
        
        ///etake venge venge o kora jete pare
        
        ///set<Integer> uSet = verticesSet.get(uIndex);
        ///set<Integer> vSet = verticesSet.get(vIndex);
        
        ///uSet.addAll(vSet);
        
        
        ///now verticesSet theke vIndex ke remove kore dite hobe
        verticesSet.remove(vIndex);
        ///er mane holo verticesSet[vIndex] ke remove kore dewa hocche
        
        
        
        
        
        ///so finaly summary is, Union funtion e jader paraeter hisabe pathano hobe
        ///tader ekjon er master set er sathe arekjon er master set merge kora
        ///and finaly je set er pichone merge kora hoyeche, tar onno set take NULL or remove kore dewa
    }
    
    
    public int FindSet(int v){
        for(int i=0; i<verticesSet.size(); i++){   ///proti ta set ke iterate kora hocche
            Set <Integer> temp=  verticesSet.get(i);
      
            ///contains function
            if(temp.contains(v)){  ///mane v jodi s set e thake then i return korbe 
                return i;   ///returning the master index of an element
            }
        }
        
        ///ekhane temp namok set ta i=0 er jonno verticesSet[0] er set take hold kore
        ///then Findset(int v) er parameter "v" jodi oi temp set er under e thake tahole as the full set is under verticesSet[0] er under e
        ///so it returns 0; the index of its master index
        ///let i=0 er jonno verticesSet[0] er set e v ke pawa jay nai
        ///then i=1 er jonno temp namok set verticesSet[1] er full set take hold korbe
        ///then check korbe je "v" oi set er moddhe ache kina
        ///thakle se 1 return kore dibe
        ///means FindSet(v) function returns the index ,jar under e v ache
        
        return -1; ///v ke pawa na gale -1 return korbe, but as kruskal works for a connected graph, so kokhonoi -1 return hobe na
    }
    
    
    
    
    
    public void printResult(){ ///ekhane resulting Minimum Spanning Tree er ekta ekta edge ke print kora hocche
        
        for(int i=0; i<result.size(); i++){
            
            Edge edge= result.get(i);
            System.out.println("v1: "+edge.src+" v2: "+edge.dest+" weight: "+edge.weight);
        }
    }
    
    
    
    public void findMST(){
        result = new ArrayList(); 
        makeSet(); 
        
        
        ///now edge sort korte hobe weight er basis e
        ///ekhane direct "sort" function kaj korbe na
        ///karon edge er moddhe 3 ta element ache
        ///kar basis e sort korbe seta bole dite hobe
        
        
        
        ///sort:
        ///Arrays.sort(edges); its error.edges ekta static array, so ekhane Arrays.sort use kora hoyeche
        ///edges dynamic hole Collections.Sort use kora hoto
        ///se edge compare kore kore sort korbe, so ekta comperator edge class e likhte hobe
        
        
        
        
        ///SORT:
        
        Arrays.sort(edges, new Comparator(){  ///its inplace sort. class e comperator likhle ekta fixed element er sapekkhe sort hoto
            @Override
            public int compare(Object o1, Object o2) {
                 Edge e1= (Edge) o1;
                 Edge e2= (Edge) o2;
                 
                 
                 return e1.weight-e2.weight;
            }
            
        });
        
        
        ///how this compare function in sorting works?
        ///Ans: paramater list e o1 age then o2 thakar mane holo array te samne o1, then pichone o2 ache
        ///now o1.weight-o2.weight beshi howar mane holo o1 er weight beshi and o2 er weight kom
        ///now compare function ta positive value return pele tokhon o1 and o2 er moddhe swap kore
        ///so amar dorkar o1 er weight o2 er beshi hole o2 er sathe o1 er swap kora
        ///r ei kaj koranor jonno dorkar compare ke active kora
        ///r compare ke active
        
        
        
        
        for(int i=0; i<E; i++){
            Edge edge = edges[i];
            
            if(FindSet(edge.src) != FindSet(edge.dest)){
                result.add(edge);
                Union(edge.src,edge.dest);
            }
        }
    }
    
    
    
    public static void main(String[] args) {    ///eta likhar shortcut holo psvm then press tab
        Kruskal_by_sir mst= new Kruskal_by_sir(5,8); ///Here I Set a fixed value of number of nodes and edges, you can take it as input
        mst.readEdges();
        mst.findMST();
        System.out.println("");
        mst.printResult();
    }
    
}


class Edge {   ///ekta class arekta class k inherite korar somoy keyword "extends". but ekta class ekta interphase k inherite korar syntax "implements". Comparable is a interphase
    int src,dest,weight;

    public Edge(int src, int dest, int weight) {    ///Righr Click on anywhere in the class.
        this.src = src;                             ///You Will Find a option "Insert Code"                       
        this.dest = dest;                           ///click constructor
        this.weight = weight;
    }
    
    
    
    
    ///@Override

  
    ///public int compareTo(Object o) {
     ///   Edge e= (Edge) o; ///type casting! Object o ke Edge e convert kora
    ///    return this.weight-e.weight;
    ///}
    
}
