//https://course.acciojob.com/idle?question=2da7ad22-cccc-497d-864c-a3ea784e1263
import java.util.*;

class Solution{
	 static int[] nextGreaterOnRightIdx(int[] arr)
    {
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer>st=new Stack();
        for(int i=n-1;i>=0;i--)
        {
           while(!st.isEmpty() && arr[st.peek()]<=arr[i])
           {
               st.pop();
           }
           if(st.isEmpty()) ans[i]=n;
           else ans[i]=st.peek();
           st.push(i);
        }
        return ans;
    }
    static int[] SlidingWindowMaximum(int n, int k, int[] arr){
        // write code here
        int ans[]=new int[n-k+1];
        int nGE[]=nextGreaterOnRightIdx(arr);
        int j=0;
        for(int i=0;i<=n-k;i++)
        {
            //if j is laging behind i
            if(j<i) j=i;
            //j will be within window
            while(nGE[j]<i+k)  j=nGE[j];
            // j will be point on window maximum
            ans[i]=arr[j];
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,arr);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
