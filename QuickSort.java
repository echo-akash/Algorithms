import java.util.Scanner;

public class QuickSort
{
	static Scanner sc = new Scanner(System.in);
	static int size;
	public static int arr[]; 

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
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
    
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    public static void inputArray()
    {
    	for(int i=0; i<size; i++){
    		arr[i] = sc.nextInt();
    	}
    }
    
    
    
    
    public static void main(String args[])
    {
        System.out.println("Number of elements: ");
        size = sc.nextInt();
        
        arr = new int[size];
        
        inputArray();
        sort(arr, 0, size-1);
 
        System.out.println("Sorted array");
        printArray(arr);
    }
}
