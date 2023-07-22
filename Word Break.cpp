// https://leetcode.com/problems/word-break/description/
// https://course.acciojob.com/idle?question=1ee812f3-1318-42b2-8ebb-0413662e1c52
class Solution {
public://recursion- memoization

int dp[301];
int solve(string&s,unordered_set<string>&st,int ind,int&n)
{
    if(ind==n) return 1;
    if(dp[ind]!=-1) return dp[ind];
    string temp="";
    for(int j=ind;j<n;j++)
    {
        temp+=s[j];
        if(st.find(temp)!=st.end())
        {
        if(solve(s,st,j+1,n)) return dp[j]=1;
        }
    }
    return dp[ind]=0;
}
    bool wordBreak(string s, vector<string>& wordDict) {
        int n=s.size(); 
        memset(dp,-1,sizeof (dp));
        unordered_set<string>st(wordDict.begin(),wordDict.end());
        return solve(s,st,0,n);
    }
};
