package javalab;

import java.util.Scanner;
import javax.transaction.xa.XAException;

public class JavaLab {
    char X[];
    char Y[];
    int l1,l2;
    int c[][];
    int b[][];
    public JavaLab(int x, int y, char X[], char Y[]) {
        l1 = x;
        l2 = y;
        c = new int[l1][l2];
        b = new int[l1][l2];
        this.X = X;
        this.Y = Y;
    }
    
    public void LCS_length(){
        int m = l1;
        int n = l2;
        for (int i = 0; i < m; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            c[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(X[i]==Y[j]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1;
                }else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }
        
    }
    
    public void LCS_print(int i, int j){
        if(i==0||j==0) return;
        if(b[i][j]==1)
        {
            LCS_print(i-1, j-1);
            System.out.print(X[i]);
        }else if(b[i][j]==2){
            LCS_print(i-1, j);
        }
        else{
            LCS_print(i, j-1);
        }
            
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        System.out.println("");
        //char X[] = new char[x.length()+1];
        char X[] = new char[x.length()+1];
        char Y[] = new char[y.length()+1];
        
        for (int i = 0; i < x.length(); i++) {
            X[i+1] = x.charAt(i);   
        }
        for (int i = 0; i < y.length(); i++) {
            Y[i+1] = y.charAt(i);
        }
        JavaLab jl = new JavaLab(X.length, Y.length, X, Y);
        
        jl.LCS_length();
        jl.LCS_print(X.length-1, Y.length-1);
        System.out.println("");
    }
    
    /*
    ABCBAB
    BDCABA
    */

}
