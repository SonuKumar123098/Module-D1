//https://leetcode.com/problems/network-delay-time/
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<pair<int,int>>adj[n+1];
            for(int i=0;i<times.size();i++)
            {
                    adj[times[i][0]].push_back({times[i][1],times[i][2]});
            }
            priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>q;
            q.push({0,k});
            vector<int>rec(n+1,-1);
            while(q.size())
            {
                    pair<int,int>p=q.top();
                    q.pop();
                    int node=p.second;
                    int time=p.first;
                    if(rec[node]!=-1) continue;
                    rec[node]=time;
                    for(pair<int,int> x:adj[node])
                    {
                            if(rec[x.first]==-1)
                            {
                                    q.push({time+x.second, x.first});
                            }
                    }
            }
            for(int i=1;i<=n;i++)
            {
                    if(rec[i]==-1) return -1;
            }
            return *max_element(rec.begin(),rec.end());
    }
};
