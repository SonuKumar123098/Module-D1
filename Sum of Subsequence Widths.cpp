// https://leetcode.com/problems/sum-of-subsequence-widths/description/
// https://course.acciojob.com/idle?question=d23a8ae4-8086-4e1e-8450-ac1da4d118a7
class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        int n=nums.size();
        sort(nums.begin(),nums.end());
        long long int sum=0;
        int mod=1e9+7;
        long long int pow[n]; pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }
        for(int i=0;i<n;i++){
            sum=((nums[i]*(pow[i]-pow[n-1-i]))%mod+sum)%mod;
        }
        return sum;
    }
};
