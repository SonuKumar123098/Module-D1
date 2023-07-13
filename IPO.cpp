// https://leetcode.com/problems/ipo/description/
// https://course.acciojob.com/idle?question=d143bbcb-fe59-42ea-9630-9ce8e7165b4a
class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        int n=capital.size();
        vector<pair<int,int>>project(n);
        for(int i=0;i<n;i++){
            project[i]={capital[i],profits[i]};
        }
        priority_queue<int>gain;
        sort(project.begin(),project.end());
        int i=0;
        while(k>0){
            while(i<n and project[i].first<=w){
                gain.push(project[i].second);
                i++;
            }
            if(gain.size()>0){
                w+=gain.top();
                gain.pop();
                k--;
            }else k=0;
        }
        return w;
    }
};
