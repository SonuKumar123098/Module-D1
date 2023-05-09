// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

class Solution {
public:
        void dfs(vector<int> graph[],vector<int>&vis,int node)
        {
                if(vis[node]==1) return;
                vis[node]=1;
                for(int x:graph[node])
                {
                        dfs(graph,vis,x);
                }
                return;
        }
    int makeConnected(int n, vector<vector<int>>& connections) {
        
            if(connections.size()<n-1) return -1;
            vector<int> graph[n];
            for(int i=0;i<connections.size();i++)
            {
                    graph[connections[i][0]].push_back(connections[i][1]);
                    graph[connections[i][1]].push_back(connections[i][0]);
            }
            vector<int>vis(n,0);
            int count=0;
            for(int i=0;i<n;i++)
            {
                    if(vis[i]==0)
                    {
                            count++;
                            dfs(graph,vis,i);
                    }
            }
            return count-1;
    }
};
// https://course.acciojob.com/idle?question=8ece7d1c-895e-4584-b084-64f1032d0611
import java.util.*;
class Solution{
    
    private static void dfs(ArrayList<Integer>adj[],boolean[]visited,int node){
		visited[node]=true;
		for(int vertex:adj[node]){
			if(!visited[vertex])
				dfs(adj,visited,vertex);
		}
	}
    public static int makeConnected(int n , int[][] connections){
        //write your code here
		int edge=connections.length;
		if(edge<(n-1)) return -1;
		ArrayList<Integer>adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
		for(int i=0;i<edge;i++){
			adj[connections[i][0]].add(connections[i][1]);
			adj[connections[i][1]].add(connections[i][0]);
		}
		boolean[]visited=new boolean[n];
		int component=0;
		for(int i=0;i<n;i++){
			if(!visited[i]){
				component++;
				dfs(adj,visited,i);
			}
		}
		return component-1;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][2] ; 
        for(int i = 0 ; i < m ; ++i){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.print(Solution.makeConnected(n,edges));
    }
}
