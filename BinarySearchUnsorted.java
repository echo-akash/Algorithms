

import java.util.Scanner;

public class BinarySearchUnsorted
{
	static Scanner sc = new Scanner(System.in);
	static int arr[];
	static int size;
    
	
	
	
	
	public static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int q = partition(arr, low, high);
            sort(arr, low, q-1);
            sort(arr, q+1, high);
        }
    }
 
    
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
	
	
	
	
	
	
	
	////////////////////////end//////////////////////////
	
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
 
    
    
    
    public static void printArray()
    {
    	for(int i=0; i<size; i++)
    	{
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    }

    
    
    public static void main(String args[])
    {
        
    	System.out.println("Enter the size of the array: ");
        size = sc.nextInt();
        arr = new int[size];
        
    	System.out.println("Enetr array elements: ");
        inputArray();
    
        
        
        
    //////////call sort functions/////////////
    sort(arr, 0, size-1);	
    System.out.println("Sorted array");
    printArray();	
    	
    
    
    
        System.out.println("Enter the element: ");
        
        int element = sc.nextInt();
        
        int result = binarySearch(0, size-1, element);

        
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index "+result);
    }
}

