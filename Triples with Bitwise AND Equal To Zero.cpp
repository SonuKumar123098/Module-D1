// https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/description/
// https://course.acciojob.com/idle?question=77971af9-8cb7-49c4-9fb1-654982a691af
class Solution {
public:
    int countTriplets(vector<int>& nums) {
        int cnt=0; int n=nums.size();
        unordered_map<int,int>pair;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pair[(nums[i]&nums[j])]++;
            }
        }
        for(int i=0;i<n;i++){
            for(auto it:pair){
                if((it.first&nums[i])==0) cnt+=it.second;
            }
        }
        return cnt;
    }
};
// 
