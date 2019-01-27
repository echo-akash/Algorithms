import java.util.Scanner;

public class BitonicPoint {

	
	static int binarySearch(int arr[], int left, int right)
	{
	    if (left <= right)
	    {
	        int mid = (left+right)/2;
	 
	        if (arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])
	            return mid;
	 
	        if (arr[mid] < arr[mid+1])
	            return binarySearch(arr, mid+1,right);
	        else
	            return binarySearch(arr, left, mid-1);
	    }
	 
	    return -1;
	}
	 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			Scanner scanner = new Scanner(System.in);
		    int n;
		    n = scanner.nextInt();
		    int arr[] = new int[n+1];
		    
		    for(int i=0; i<n; i++)
		    {
		    	arr[i] = scanner.nextInt();
		    }
		    
		    int index = binarySearch(arr, 1, n-1);
		    if (index != -1)
		    	System.out.println(arr[index]);
		       
		   
		}
	}

}
