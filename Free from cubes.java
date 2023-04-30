//https://course.acciojob.com/idle?question=ad209648-3f41-4de1-8f5b-43f27c00d9fe
import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = Solution.isCubeFree(n);
        System.out.println(ans);
    }
}

class Solution {

    static int isCubeFree(int n) {

       // Write your code here
		int[]number=new int[n+1];
		for(int i=2;i*i*i<=n;i++){
			if(number[i]==0){
				int k=i*i*i;
				for(int j=k;j<=n;j+=k){
					number[j]=1;
				}
			}
		}
		int cnt=0;
		for(int i=1;i<=n;i++){
			if(number[i]==0) cnt++;
		}
		return number[n]==0?cnt:-1;
    }
}
