//https://course.acciojob.com/idle?question=c8fc7c7c-ae34-4fbe-909d-a7d666d4510a
import java.util.*;

class Solution {

    public int constantPalindrome(int arr[], int k) {
        // write code here
		int freq[]=new int[2*k+2];
		int n=arr.length;
		for(int i=0;i<n/2;i++){
			int sum=arr[i]+arr[n-1-i];
			int min=Math.min(arr[i],arr[n-1-i]);
			int max=Math.max(arr[i],arr[n-1-i]);
			freq[sum]++;
			freq[sum+1]--;
			freq[min+1]++;
			freq[max+k+1]--;
		}
		int cnt=freq[0];
		for(int i=1;i<freq.length;i++){
			freq[i]=freq[i-1]+freq[i];
			cnt=Math.max(freq[i],cnt);
		}
		return n-cnt;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        sc.close();
        System.out.print(Obj.constantPalindrome(arr, k));
    }
}
