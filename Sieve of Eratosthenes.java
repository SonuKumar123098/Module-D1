//https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int n){
         //code here
        boolean[]number=new boolean[n+1];
        for(int i=2;i*i<=n;i++){
            if(!number[i]){
                for(int j=i*i;j<=n;j+=i){
                    number[j]=true;
                }
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(!number[i]) ans.add(i);
        }
        return ans;
    }
}
