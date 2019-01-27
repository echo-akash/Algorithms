
package bitonic;

public class Bitonic {
    int findbit(int arr[], int l, int h){
        if(l<=h){
            int mid=(h+l)/2;
         if(arr[mid-1]<arr[mid] && arr[mid] > arr[mid+1]){
             return mid;
         }
         if(arr[mid]<arr[mid+1]){
             return findbit(arr, mid+1, h);
         }
         else{
             return findbit(arr, l, mid-1);
         }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[]={1, 3, 6, 8, 9, 121,  45, 32, 23, 12, 9, 4, 1};
        
        Bitonic bt=new Bitonic();
        int bit;
        System.out.println("Find bt");
        bit=bt.findbit(arr, 0, arr.length-1);
       //print(arr);
        System.out.print("result: " + arr[bit]);
        
        
    }
    
}
