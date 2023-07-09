// https://course.acciojob.com/idle?question=44b449af-5b5f-4a0b-8f1e-21d67f17d20d
import java.util.*;

class Solution {
    public int[] StripTemp(int n, int k, int[] a, int[] t) {
        //Write your code here
		int ans[]=new int[n];
		for(int j=0;j<n;j++){
			int min=Integer.MAX_VALUE;
			for(int i=0;i<k;i++){
				int temp=Math.abs(a[i]-(j+1))+t[i];
				min=Math.min(temp,min);
			}
			ans[j]=min;
		}
		return ans;
		
    }

}

public class Main {
    public static void main(String[] args) {


	Solution Obj = new Solution();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[k];
        int[] t = new int[k];

        for(int i = 0 ; i< k; i++)
            a[i] = scanner.nextInt();

        for(int i = 0 ; i< k; i++)
            t[i] = scanner.nextInt();

        int[] ans = Obj.StripTemp(n, k, a, t);

        for(int a1 : ans)
            System.out.print(a1 + " ");
    }
}
