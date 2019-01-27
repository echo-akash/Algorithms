import java.util.Scanner;


/*
3
5
1 2 3 4 5
3
3 3 3
7
30 35 15 5 10 20 25
*/

public class MatrixChainMultiplication {

	static Scanner scanner = new Scanner(System.in);
	
	char letter = 'A';
	int arr[];
	int n;
	int dp[][], s[][];
	
	public MatrixChainMultiplication(int n)
	{
		this.n = n;
		arr = new int[n];
		dp = new int[n+1][n+1];
		s = new int[n+1][n+1];
		
		for(int i=0;i<n;i++)
		{
			for(int j = i;j<n;j++)
			{
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<n;i++)
		{
			dp[i][i] = 0;
		}
	}
	
	public void readInput()
	{
		for(int i=0;i<n;i++)
		{
			int a = scanner.nextInt();
			arr[i] = a;
		}
	}
	
	public int MatrixChainOrder(int i, int j)
	{
		if(dp[i][j] < Integer.MAX_VALUE) return dp[i][j];
		if(i == j) return dp[i][j] = 0;
		int min = Integer.MAX_VALUE;
		int cnt;
		
		for(int k=i;k<j;k++)
		{
			cnt = MatrixChainOrder(i, k) + MatrixChainOrder(k+1, j) + arr[i-1]*arr[k]*arr[j];
			if(cnt < min) 
			{
				min = cnt;
				s[i][j] = k;
			}
			//min = Math.min(min, cnt);
			
		}
		return dp[i][j] = min;
	}
	
	public void printOptimalParents(int i, int j)
	{
		if(i == j) 
		{
			System.out.print(letter++);
		}
		else
		{
			System.out.print("(");
			printOptimalParents(i, s[i][j]);
			printOptimalParents(s[i][j] + 1, j);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args)
	{
		int t;
		t = scanner.nextInt();
		while(t>0)
		{
			int n;
			n = scanner.nextInt();
			MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication(n);
			
			matrixChainMultiplication.readInput();
			int ans = matrixChainMultiplication.MatrixChainOrder(1, n-1);
			System.out.println(ans);
			matrixChainMultiplication.printOptimalParents(0, n-1);
			System.out.println();
			t--;
		}
		
	}
	
	
}
