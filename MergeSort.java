import java.util.Scanner;

public class MergeSort {

	static Scanner sc = new Scanner(System.in);
	static int size;
 	static int a[];
	static int b[];
	
	static void merge_sort(int a[], int low, int high) 
	{
		if(low<high) {
			int mid = (low+high)/2;
			
			merge_sort(a,low,mid);
			merge_sort(a,mid+1,high);
			merge(a, low, mid, high, b);
		}
		else
			return;
	}
	
	static void merge(int a[], int l, int m, int h, int b[])
	{
		int i=l;
		int j = m+1;
		int k = l;
		
		while(i<=m && j<=h)
		{
			if(a[i]<=a[j])
			{
				b[k] = a[i];
				i++;
			}
			else
			{
				b[k] = a[j];
				j++;
			}
			k++;
		}
		
		if(i<=m)
		{
			while(i<=m) {
				b[k] = a[i];
				k++;
				i++;
			}
		}
		else
		{
			while(j<=h)
			{
				b[k] = a[j];
				k++;
				j++;
			}
		}
		
		for(int n=l; n<=h; n++) {
			a[n] = b[n];
		}		
	}
	
	public static void inputArray()
	{
		for(int i=0; i<size; i++)
		{
			a[i] = sc.nextInt();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Number of elements: ");	
		size = sc.nextInt();
		
		a = new int[size];
		b = new int[size];
		
		inputArray();
		
		merge_sort(a, 0, size-1);
		System.out.println("After sorted");
		for(int i=0; i<size; i++) {
			System.out.print(a[i]+" ");
		}
		
	}

}
