//https://course.acciojob.com/idle?question=1dcbd139-1ad2-45ca-9705-5184b1a0b922
import java.io.*;
import java.util.*;

class Solution {
        public static int[] solve(int[] arr) {
        // Your code here
			int n=arr.length;
			int []ans=new int[n];
			Stack<Integer>st=new Stack<>();
			for(int i=0;i<n;i++){
				while(!st.empty() && arr[st.peek()]<=arr[i])
					st.pop();
				if(st.empty()) ans[i]=-1;
				else ans[i]=i-st.peek();
				st.push(i);
			}
			return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.solve(arr1);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
        System.out.println('\n');
    }
}
