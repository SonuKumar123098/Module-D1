// https://leetcode.com/problems/transform-to-chessboard/description/
// https://course.acciojob.com/idle?question=677957f2-ac9d-413f-8926-6ba807b95732
class Solution {
    public int movesToChessboard(int[][] b) {
        // counting number of ones in each row and each column
				int n=b.length;
		int rows[]=new int[n];
		int cols[]=new int[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(((b[i][0]^b[0][0])^(b[0][j]^b[i][j]))!=0) return -1;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(b[i][j]==1)
					{
						rows[i]++;
						cols[j]++;
					}
			}
		}
		//chekcing that it is possible to convert into chessbox or not;
		
		for(int i=0;i<n;i++){
			if(rows[i]!=n/2 && rows[i]!=(n+1)/2) return -1;
			if(cols[i]!=n/2 && cols[i]!=(n+1)/2) return -1;
		}
		//counting the number of swap in rows and cols
		int rcount=0;
		int ccount=0;
		for(int i=0;i<n;i++){
			if(b[0][i]!=i%2) rcount++;
			if(b[i][0]!=i%2) ccount++;
		}
		// if n is odd then we need to consider the first row  or column is flipped
		if(n%2==1){
			if(rcount%2==1)
			  rcount=n-rcount;
			if(ccount%2==1)
			  ccount=n-ccount;
		}
		else{
			rcount=Math.min(rcount,n-rcount);
			ccount=Math.min(ccount,n-ccount);
		}
		return (rcount+ccount)/2;
    }
}
