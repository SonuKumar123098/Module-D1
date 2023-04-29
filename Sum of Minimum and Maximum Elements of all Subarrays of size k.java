//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
//https://course.acciojob.com/idle?question=e3c0aa66-fa4c-45dc-879e-ddb89e2e5a55
import java.util.*;
class Solution{
    public static long sumOfMaxAndMin(int nums[], int n, int k)
    {
        //Write your code here
		Deque<Integer>max=new LinkedList<>();
		Deque<Integer>min=new LinkedList<>();
		long sum=0;
		for(int i=0;i<k;i++){
			//maintain  window in incresing order
			while(!min.isEmpty() && nums[min.peekLast()]>=nums[i]){
				min.removeLast();
			}
			min.addLast(i);
			//maintain decreasing roder of window
			while(!max.isEmpty() && nums[max.peekLast()]<=nums[i]){
				max.removeLast();
			}
			max.addLast(i);
		}
		sum+=(nums[min.peekFirst()]+nums[max.peekFirst()]);
		for(int i=k;i<n;i++){
			//maintain window in increasing order
			while(!min.isEmpty() && nums[min.peekLast()]>=nums[i]){
				min.removeLast();
			}
			min.addLast(i);
			//maintaining window size
			if(min.peekFirst()<=i-k) min.removeFirst();
			//maintain window in decreasing order
			while(!max.isEmpty() && nums[max.peekLast()]<=nums[i]){
				max.removeLast();
			}
			max.addLast(i);
			//maintaining window size
			if(max.peekFirst()<=i-k) max.removeFirst();
			//add minimum and maximum of window ot sum
			sum+=(nums[min.peekFirst()]+nums[max.peekFirst()]);
		}
		return sum;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n] ; 
        for(int i = 0 ; i < n ; ++i){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
         System.out.print(Solution.sumOfMaxAndMin(arr, n , k ));
        
    }
}
