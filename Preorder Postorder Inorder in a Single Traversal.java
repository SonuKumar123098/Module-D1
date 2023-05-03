//https://course.acciojob.com/idle?question=e4bec89a-4907-4b75-9ff7-f9defb7ba20f
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			tree.allTraversal(root);
            
		
	}
}
  


class Solution {

	static ArrayList<Integer>pre,in,post;
private static  void traverse(Node root){
	if(root==null)return;
	pre.add(root.data);
	traverse(root.left);
	in.add(root.data);
	traverse(root.right);
	post.add(root.data);
}
	public static void allTraversal(Node root) {
		//Write your code here 
		pre=new ArrayList<>();
		in=new ArrayList<>();
		post=new ArrayList<>();
        traverse(root);
		for(int x:pre)System.out.print(x+" ");
		System.out.println();
		for(int x:in)System.out.print(x+" ");
		System.out.println();
		for(int x:post)System.out.print(x+" ");
		System.out.println();
	}
}
