
import java.util.Scanner;

public class MakePalindrome {

	static char str[];
    final static Scanner scan=new Scanner(System.in);
    
    static int min(int a, int b)
    {
        if(a<b) return a;
        return b;
    }

    static int findMinInsertions(int l, int h)
    {

        if (l > h) return 999999;
        if (l == h) return 0;
        if (l == h - 1)
        {
            if (str[l] == str[h])
                return 0;
            return 1;
        }
        if (str[l] == str[h]) return findMinInsertions(l + 1, h - 1);
        else return (min(findMinInsertions(l, h - 1), findMinInsertions(l + 1, h)) + 1);
    }


    public static void main(String[] args) {
        
    	String st;
    	String buffer;
    	int testCase;
    	
    	testCase = scan.nextInt();
    	buffer = scan.nextLine();
    	
    	for(int i=1; i<=testCase; i++) {
    		
    		st = scan.nextLine();   
            str = st.toCharArray();
            int len = st.length()-1;
            System.out.println("Case "+i+": "+findMinInsertions(0, len));
      
    	}
    }
  }



/*
5
aab
aaaaa
abababaabababa
amar
hello
*/
