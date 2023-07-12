// https://course.acciojob.com/idle?question=8dda6267-a0e8-4d9f-89ce-30b41215dbbb
import java.util.*;

class Solution {
    static void minShippingWeight(int a[], int n,int D)
    {
        //Write your code here
		int low=0,high=0;
		for(int x:a){
			low=Math.max(x,low);
			high+=x;
		}
		while(low<high){
			int mid=low+(high-low)/2;
			if(isPossible(a,D,mid)) high=mid;
			else low=mid+1;
		}
		System.out.println(low);
       
    }
   private static boolean isPossible(int a[],int d,int mid){
	   int n=a.length;
	   int days=1;
	   int sum=0;
	   for(int i=0;i<n;i++){
		   sum+=a[i];
		   if(sum>mid){
			   days++;
			   sum=a[i];
		   }
	   }
	   if(days<=d)return true;
	   return false;
   }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int D= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.minShippingWeight(array,n,D);
    }
}
