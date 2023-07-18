// https://course.acciojob.com/idle?question=2f7b45ac-ff41-4558-8523-44e07240c9b6
import java.util.*;



class Solution {
	
     public static void cheapProduct(List<Integer> a) {
       //write your code here
		 int n=a.size();
		 Collections.sort(a);
		 List<Integer>ans=new ArrayList<>();
		 int p2=n/2;
		 int p1=0;
		 while(p1<n/2 && p2<n){
			 ans.add(a.get(p2++));
			 ans.add(a.get(p1++));
		 }
		 while(p1<n/2) ans.add(a.get(p1++));
		 while(p2<n) ans.add(a.get(p2++));
		 int cnt=0;
		 for(int i=1;i<n-1;i++){
			if(ans.get(i)<ans.get(i+1) && ans.get(i)<ans.get(i-1)) cnt++;
		 }
		 System.out.println(cnt);
		 for(int i:ans){
			System.out.print(i+" ");
		 }
		 System.out.println();
	 }
}
		 
		



class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
            arr1.add(sc.nextInt());
        Solution.cheapProduct(arr1);
    }
}
