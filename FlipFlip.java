//https://course.acciojob.com/idle?question=1f82c6b4-988d-4474-be30-4a15f898cf69
import java.util.*;

class Solution {
    public int FlipFlip(int n, int[] nums,int k) {
        // Write your code here
        int[]flip=new int[n+1];
        int cnt=0;
        for(int i=0;i<n;i++){
           if(i==0 && nums[i]==0){
               if(i+k<=n){
                   flip[i]++;
                   flip[i+k]--;
                   cnt++;
                }else return -1;
           }else if(i!=0){
               flip[i]+=flip[i-1];
               if((flip[i]%2==0 && nums[i]==0)||(flip[i]%2==1 && nums[i]==1)){
                   if(i+k<=n){
                       flip[i]++;
                       flip[i+k]--;
                       cnt++;
                   }else return -1;
               }
           }
        }
        return cnt;
    }
}
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
         int k = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
		int a=Obj.FlipFlip(n,arr,k);
        System.out.print(a+" ");
		}
}
