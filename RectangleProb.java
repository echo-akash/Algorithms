/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleprob;

import java.util.ArrayList;
import java.util.Random;

public class RectangleProb {
    int func(int arr[]){
        ArrayList<Integer> arr1=new ArrayList();
        int count;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0)
                arr1.add(0);
            else{
                count=arr[i];
                for (int j = i-1; j >= 0; j--) {
                   if(arr[j]<arr[i])
                       break;
                   else
                       count=count+arr[i];
                }
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j]<arr[i])
                       break;
                   else
                       count=count+arr[i];
                }
                arr1.add(count);
            }
        }
        int max=0;
        for (int i = 0; i < arr1.size(); i++) {
          if(max < arr1.get(i)){
              max=arr1.get(i);
          }  
        }
        
        return max;
        
    }
    public static void main(String[] args) {
        Random rnd= new Random();
        String st[]={"asa", "dd", "ds", "ds", "srf", "sd"};
        int x;
        x=rnd.nextInt(5);
        String str=st[x];
        System.out.print(str );
        
        RectangleProb rp=new RectangleProb();
        int arr[]={7, 6, 5, 2, 5, 5, 1, 0};
        int result=rp.func(arr);
        System.out.println("result: " + result);
    }
    
}
