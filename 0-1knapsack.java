package javalab02;
import java.util.Scanner;

public class JavaLab02 {
    
    public static int findProfit(int i, int c, int w[], int v[], int n){
        if(i==n||c==0){
            return 0;
        }else if(w[i]<=c){
            int x1 = v[i] + findProfit(i+1,c-w[i], w, v, n);
            int x2 = findProfit(i+1,c, w, v, n);
            return x1>x2?x1:x2;
        }else{
            return findProfit(i+1,c, w, v, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w[] = new int[n];
        int v[] = new int[n];
        int capacity = sc.nextInt();
        
        
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();
            
        }
        for (int i = 0; i < v.length; i++) {
            v[i] = sc.nextInt();
            
        }
        
        System.out.println(findProfit(0, capacity, w, v, n));

    }

}

/*
4 5
2 1 3 2
12 10 20 15
*/