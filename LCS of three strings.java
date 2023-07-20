// https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1
//https://course.acciojob.com/idle?question=9b18888b-1470-42e7-b77c-e9f959105730


//User function Template for Java
class Solution 
{   private int solve(String a,String b,String c, int[][][]dp, int ind1,int ind2,int ind3){
		if(ind1<0 || ind2<0 || ind3<0) return 0;
		if(dp[ind1][ind2][ind3]!=-1)return dp[ind1][ind2][ind3];
		int ans=0;
		if(a.charAt(ind1)==b.charAt(ind2) &&  b.charAt(ind2)==c.charAt(ind3)){
			ans=1+solve(a,b,c,dp,ind1-1,ind2-1,ind3-1);
		}
		else{
			ans=solve(a,b,c,dp,ind1-1,ind2,ind3);
			ans=Math.max(ans,solve(a,b,c,dp,ind1,ind2-1,ind3));
			ans=Math.max(ans,solve(a,b,c,dp,ind1,ind2,ind3-1));
		}
		return dp[ind1][ind2][ind3]=ans;
	}
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int[][][]dp=new int[n1][n2][n3];
		for(int i=0;i<n1;i++){
			for(int j=0;j<n2;j++){
				Arrays.fill(dp[i][j],-1);
			}
		}
		return solve(A,B,C,dp,n1-1,n2-1,n3-1);
    }
} 
