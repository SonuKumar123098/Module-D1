//https://leetcode.com/problems/pascals-triangle-ii/
//https://course.acciojob.com/idle?question=28343c14-517f-4ba2-ab67-c22339550a60
//optimal O(n)
class Solution {
public://optimised solution time complexity O(n)
    vector<int> getRow(int rowIndex) {
        vector<int>res(rowIndex+1,1);        
        for(int i=0;i<rowIndex-1;i++)
        {
            long long int k=res[i];
            k=k*(rowIndex-i);
            k=k/(i+1);
            res[i+1]=k;
        }
        return res;
    }
};
// 2nd approach O(n^2)
class Solution {
public://optimised solution time complexity O(n)-> O(n^2)
    vector<int> getRow(int rowIndex) {
        vector<int>res(rowIndex+1,0);  
        res[0]=1;      
        for(int i=1;i<rowIndex+1;i++)
        {
            for(int j=i;j>0;j--){
                res[j]=res[j-1]+res[j];
            }
        }
        return res;
    }
};
//acciojob  java code 
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;


class Main {
    
  public static void main (String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        Solution obj=new Solution();
        obj.solve(k);
        System.out.println();
    }
  
}

class Solution{
    public static void solve(int k)
    {
        // your code here
		int temp=1;
		System.out.print(temp+" ");
		for(int i=1;i<=k;i++){
			temp=temp*(k-(i-1))/i;
			System.out.print(temp+" ");
		}
        
    }
}
