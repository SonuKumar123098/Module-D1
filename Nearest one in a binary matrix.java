//https://course.acciojob.com/idle?question=5ebeb2e9-0c47-4fd9-a7b9-5fbb1ecbe30b
import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
class pair{
	int x;
	int y;
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
class Solution
{
	boolean valid(int x,int y,int m,int n,boolean[][]visited){
		if(x<0||x>=m||y<0||y>=n||visited[x][y]) return false;
		return true;
	}
    public int[][] nearest(int[][] grid)
    {
        // Code here
		Queue<pair>q=new LinkedList<>();
		boolean[][]visited=new boolean[grid.length][grid[0].length];
       for(int i=0;i<grid.length;i++){
		   for(int j=0;j<grid[0].length;j++){
			   if(grid[i][j]==1){
				   grid[i][j]=0;
				   visited[i][j]=true;
				   q.add(new pair(i,j));
			   }
		   }
	   }
		int level=0;
		int[][]dirn=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
		while(q.size()>0){
			level++;
			int size=q.size();
			while(size>0){
				size--;
				pair p=q.remove();
				for(int i=0;i<4;i++){
					int x=p.x+dirn[i][0];
					int y=p.y+dirn[i][1];
					if(valid(x,y,grid.length,grid[0].length,visited)){
						grid[x][y]=level;
						visited[x][y]=true;
						q.add(new pair(x,y));
					}
				}
			}
		}
		return grid;
    }
}
