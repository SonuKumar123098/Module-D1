//https://leetcode.com/problems/path-with-minimum-effort/
//https://course.acciojob.com/idle?question=d8b0a8ae-b9f4-4647-9d7b-eb783e5e5781
class Solution {
public:
        
        int vis[100][100];
       vector<pair<int,int>>dir={{0,1},{0,-1},{1,0},{-1,0}};
        void ok(int x,int y,int& mid,vector<vector<int>>&h)
        {
                if(!vis[x][y])
                {
                        vis[x][y]=1;
                         int m=h.size();
                         int n=h[0].size();
                        for(int i=0;i<4;i++)
                        {
                                int x1=x+dir[i].first;
                                int y1=y+dir[i].second;
                                if(x1<0||y1<0||x1>=m||y1>=n)
                                {
                                        continue;
                                }
                                if(abs(h[x][y]-h[x1][y1])<=mid)
                                {
                                        ok(x1,y1,mid,h);
                                }
                        }
                }

        }
    int minimumEffortPath(vector<vector<int>>& h) {
        int l=0;int r=1e6;
            int m=h.size();
            int n=h[0].size();
            while(l<r)
            {
                    int mid=l+(r-l)/2;
                    memset(vis,0,sizeof(vis));
                    ok(0,0,mid,h);
                    if(vis[m-1][n-1]==1){
                            r=mid;                           
                    }
                    else l=mid+1;
            }
            return l;
    }
};
//2nd approach
class Solution {//dijkstra's algorithm
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int m=heights.size();
        int n=heights[0].size();
        vector<vector<int>> dist(m,vector<int>(n,INT_MAX));
        vector<pair<int,int>>dirn={{0,1},{0,-1},{1,0},{-1,0}};
        priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>>pq;
        pq.push({0,0,0});//(d,x,y)
        dist[0][0]=0;
        while(pq.size()){
            auto v=pq.top();
            pq.pop();
            int d=v[0];
            int x=v[1];
            int y=v[2];
            if(x==m-1 and y==n-1){
                return d;
            }
            for(int i=0;i<4;i++){
                int nx=x+dirn[i].first;
                int ny=y+dirn[i].second;
                if(nx>=0 and ny>=0 and nx<m and ny<n ){
                    int nd=max(d,abs(heights[x][y]-heights[nx][ny]));
                    if(nd<dist[nx][ny]){
                        dist[nx][ny]=nd;
                        pq.push({nd,nx,ny});
                    }
                }
            }
        }
        return -1;
    }
};
