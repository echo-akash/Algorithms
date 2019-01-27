
package collectcoins;

public class CollectCoins {
     
    // recursive method to collect coins from
    // height array l to r, with height h already
    // collected
    public static int minStepsRecur(int height[], int l, 
                                         int r, int h)
    {
        //  if l is more than r, no steps needed
        if (l >= r)
            return 0;
      
        // loop over heights to get minimum height
        // index
        int m = l;
        for (int i = l; i < r; i++)
            if (height[i] < height[m])
                m = i;
      
        /*  choose minimum from,
            1) collecting coins using all vertical
            lines (total r - l)
            2) collecting coins using lower horizontal
            lines and recursively on left and right
            segments */
        return Math.min(r - l,
            minStepsRecur(height, l, m, height[m]) +
            minStepsRecur(height, m + 1, r, height[m]) +
            height[m] - h);
    }
      
    // method returns minimum number of step to
    // collect coin from stack, with height in
    // height[] array
    public static int minSteps(int height[], int N)
    {
        return minStepsRecur(height, 0, N, 0);
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
 
        int height[] = {7, 6, 2, 2, 2, 2, 4, 1, 0, 5, 5, 5,};
        int N = height.length;
      
        System.out.println(minSteps(height, N));
             
    }
}
   
// This code is contributed by Arnav Kr. Mandal.
