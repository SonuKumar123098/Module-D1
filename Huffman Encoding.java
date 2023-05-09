//https://course.acciojob.com/idle?question=7a900b84-a1ca-4b4d-865d-af1793ae8b1f
import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
		PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->{
            return a.freq<b.freq?-1:1;
        });
        for(int i=0;i<N;i++){
            pq.add(new Node(f[i],S.charAt(i)));
        }
        Node root=makeTree(pq);
        StringBuilder sb=new StringBuilder();
        ArrayList<String>ans=new ArrayList<>();
         printPreorder(root,sb,ans);
         return ans;
    }
    private void printPreorder(Node root,StringBuilder sb,ArrayList<String>ans){
        if(root==null)return;
        if(root.left==null && root.right==null){
            ans.add(sb.toString());
            // sb.deleteCharAt(sb.length()-1);
            return;
        }
        printPreorder(root.left,sb.append(0),ans);
        sb.deleteCharAt(sb.length()-1);
        printPreorder(root.right,sb.append(1),ans);
        sb.deleteCharAt(sb.length()-1);
    }
    private Node makeTree(PriorityQueue<Node>pq){
        while(pq.size()>1){
            Node left=pq.remove();
            Node right=pq.remove();
            Node sum=new Node(left.freq+right.freq,'x');
            sum.left=left;
            sum.right=right;
            pq.add(sum);
        }
        return pq.remove();
    }
}
class Node{
    char c;
    int freq;
    Node left,right;
    Node(int freq,char c){
        this.freq=freq;
        this.c=c;
    }
}
