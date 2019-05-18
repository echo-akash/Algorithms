

import java.util.Scanner;

public class BinarySearch
{
	static Scanner sc = new Scanner(System.in);
	static int arr[];
	static int size;
    
    public static int binarySearch(int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            
            if (arr[mid] == x)
               return mid;
            
            if (arr[mid] > x)
               return binarySearch(l, mid-1, x);
            return binarySearch(mid+1, r, x);
        }
 
        return -1;
    }
    
    public static void inputArray()
    {
    	for(int i=0; i<size; i++)
    	{
    		arr[i] = sc.nextInt();
    	}
    }
 

    public static void main(String args[])
    {
        
    	System.out.println("Enter the size of the array: ");
        size = sc.nextInt();
        arr = new int[size];
        
    	System.out.println("Enetr array elements[sorted]: ");
        
    	inputArray();
    	
        System.out.println("Enter the element: ");
        
        int element = sc.nextInt();
        
        int result = binarySearch(0, size-1, element);

        
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index "+result);
    }
}
