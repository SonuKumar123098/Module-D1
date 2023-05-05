//https://course.acciojob.com/idle?question=465ab15a-4dbc-442b-b552-ff450783a838
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Solution {
	private static int dfs(int[][]shelf,boolean[][]visited, int x ,int y){
		if(x<0||x>=shelf.length||y<0||y>=shelf[0].length||visited[x][y]||shelf[x][y]==0)
			return 0;
		int ans=shelf[x][y];
		visited[x][y]=true;
		int bottom=ans+dfs(shelf,visited,x+1,y);
		int top=ans+dfs(shelf,visited,x-1,y);
		int right=ans+dfs(shelf,visited,x,y+1);
		int left=ans+dfs(shelf,visited,x,y-1);
		visited[x][y]=false;
		return Math.max(bottom,Math.max(top,Math.max(left,right)));
	}
	static int getMaximumBooks(int[][] shelf){
        //Write your code here
		int m=shelf.length;
		int n=shelf[0].length;
		int maxNumber=0;
		boolean[][] visited=new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(shelf[i][j]!=0 && !visited[i][j]){
					int book=dfs(shelf,visited,i,j);
					maxNumber=Math.max(maxNumber,book);
				}
			}
		}
		return maxNumber;
    }
}

class Main{
	public static void main(String args[]) {
		Scanner ob = new Scanner (System.in);
	    int m=ob.nextInt();
		int n=ob.nextInt();
	    int grid[][]=new int [m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++)
                grid[i][j]=ob.nextInt();
        }
	    System.out.print(Solution.getMaximumBooks(grid));
	}
}
