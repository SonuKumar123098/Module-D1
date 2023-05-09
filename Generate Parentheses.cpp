//https://leetcode.com/problems/generate-parentheses/
// https://course.acciojob.com/idle?question=117d315f-d2e8-4eb8-9e68-bd2322a59f84
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string>ans;
        solve(ans,"",0,0,n);
        return ans;
    }
    void solve(vector<string>&ans,string s,int open, int close,int n){
        if(open > n)return;
        if(close == n){
            ans.push_back(s);
            return;
        }
        if(open<n){
            solve(ans,s+"(",open+1,close,n);
        }
        if(close<open){
            solve(ans,s+")",open,close+1,n);
        }
    }
};
//2nd at acciojob platfrom
import java.io.*;
import java.util.*;
class Solution{
     public static void generateParanthesis(int n){
        // write code here
		 StringBuilder sb=new StringBuilder();
		 solve(sb,0,0,n);
		 
    }
	private static void solve(StringBuilder sb,int open,int close,int n){
		if(open >n)return;
		if(close==n){
			System.out.println(sb.toString());
			return;
		}
		if(open<n){
			sb.append('(');
			solve(sb,open+1,close,n);
			sb.deleteCharAt(sb.length()-1);
		}
		if(open>close){
			sb.append(')');
			solve(sb,open,close+1,n);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
public class Main {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.generateParanthesis(n);
    }
}
