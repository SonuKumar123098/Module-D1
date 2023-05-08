//https://course.acciojob.com/idle?question=ca3cf533-b8c9-4980-bfcb-ccda70697aea
import java.io.*;
import java.util.*;
   class Solution {
     private boolean isValid(int x,int y,int n,int[][]parent){
		 if(x<0 ||y<0 ||x>=n ||y>=n || parent[x][y]!=-1)return false;
		 return true;
	 }
     void redHorse(int n, int startx, int starty, int endx, int endy) {
        
      //Write your code here
		 int dirn[][]=new int[][]{{-2,-1},{-2,1},{0,2},{2,1},{2,-1},{0,-2}};
		 String step[]=new String[]{"UL", "UR", "R", "LR", "LL", "L"};
         int[][] parent=new int[n][n];
		 for(int i=0;i<n;i++)Arrays.fill(parent[i],-1);
		 Queue<int[]>q=new LinkedList<>();
		 q.add(new int[]{startx,starty});
		 parent[startx][starty]=-2;
		 boolean flag=false;
		 while(!q.isEmpty()){
			 int size=q.size();
			 for(int i=0;i<size;i++){
				 var v=q.remove();
                 for(int j=0;j<6;j++){
					 int x=v[0]+dirn[j][0];
					 int y=v[1]+dirn[j][1];
					 if(isValid(x,y,n,parent)){
						 parent[x][y]=j;
						 if(x==endx && y==endy){
							 flag=true;
							 break;
						 }
						 q.add(new int[]{x,y});
					 }
				 }
				 if(flag)break;
			 }
			 if(flag)break;
		 }
		 if(!flag){
			 System.out.println("Impossible");
			 return;
		 }
		 ArrayList<String>path=new ArrayList<>();
		 int x=endx,y=endy;
		 while(true){
			 if(x==startx && y==starty) break;
			path.add(step[parent[x][y]]);
			 // System.out.println(parent[x][y]);
			 int index=parent[x][y];
			 x-=dirn[index][0];
			 y-=dirn[index][1];
			 
		 }
		 Collections.reverse(path);
		 System.out.println(path.size());
		 for(var v:path) System.out.print(v+" ");
    }
	   
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int startx = input.nextInt();
        int starty = input.nextInt();
        int endx = input.nextInt();
        int endy = input.nextInt();

        Solution obj=new Solution();
        obj.redHorse(n,startx,starty,endx,endy);
    }
}
