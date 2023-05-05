//https://course.acciojob.com/idle?question=3371df0b-df51-42c0-b0ca-e908eb7a031f
import java.util.Scanner;
import java.util.Arrays;

class Solution{
    public static void solve(int n, int[] arr) {
       // Your code here
		StringBuilder sb=new StringBuilder();
		int[]ans=new int[n];
		for(int i=0;i<n;i++){
			int num=arr[i];
			int left=Math.max(0,i-(num-1));
			int right=Math.min(n-1,i+(num-1));
			int cnt=0;
			int sum=0;
			int required=(arr[i]*(arr[i]+1))/2;
			while(cnt<arr[i]){
				sum+=arr[left+cnt++];
			}
			if(sum==required) {ans[arr[i]-1]=1;
							   continue;}
			for(int j=left+cnt;j<=right;j++){
				sum+=arr[j];
				sum-=arr[left++];
				if(sum==required){
					ans[arr[i]-1]=1;
					break;
				}
			}
		}
		for(int i:ans){
			sb.append(i);
		}
		String res=sb.toString();
		System.out.println(res);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Solution.solve(n, arr);
    }
}
//2nd approach optimal
import java.util.Scanner;
import java.util.Arrays;

class Solution{
    public static void solve(int n, int[] arr) {
       // Your code here
		StringBuilder sb=new StringBuilder();
		int[]map=new int[n+1];
		for(int i=0;i<n;i++){
			map[arr[i]]=i;
		}
		int left=n,right=0;
		for(int i=1;i<=n;i++){
			left=Math.min(map[i],left);
			right=Math.max(map[i],right);
			if(right-left+1==i)sb.append('1');
			else sb.append('0');
		}
		String res=sb.toString();
		System.out.println(res);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Solution.solve(n, arr);
    }
}
