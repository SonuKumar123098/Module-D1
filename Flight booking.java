//https://course.acciojob.com/idle?question=1f7e8882-80e0-4a9e-8faf-72f06a552111
import java.io.*;
import java.util.*;

class Solution {

    public int bestTime(String customers) {
        // write code here
		int n=customers.length();
		int[]come=new int[n+1];
		for(int i=1;i<=n;i++){
			char c=customers.charAt(i-1);
			if(c=='Y') come[i]=come[i-1]+1;
			else come[i]=come[i-1];
		}
		int hour=0;
		int penalty=Integer.MAX_VALUE;
		for(int i=0;i<=n;i++){
			int curPenalty=i-2*come[i]+come[n];
			if(curPenalty<penalty){
				penalty=curPenalty;
				hour=i;
			}
		}
		return hour;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.bestTime(str));
    }
}
