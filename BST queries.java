//https://course.acciojob.com/idle?question=017e582a-b0ac-4ee7-9ac9-9ed5d954ee46
import java.util.*;
// A binary tree node
class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Main {
	 public static void printTree(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node f = q.poll();
            System.out.print(f.data + " ");
            if (f.left != null)
                q.add(f.left);
            if (f.right != null)
                q.add(f.right);
        }
        System.out.println();
    }

    public static Node levelOrder(Node root, int value) {
        if (root == null) {
            Node nnode = new Node(value);
            return nnode;
        }
        if (value <= root.data)
            root.left = levelOrder(root.left, value);

        else
            root.right = levelOrder(root.right, value);
        return root;
    }

    public static Node constructBST(int arr[]) {
        int n = arr.length;
        if (n == 0)
            return null;
        Node root = null;
        for (int i = 0; i < n; i++)
            root = levelOrder(root, arr[i]);
        return root;
    }
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int preorder[] = new int[n];
		for (int i = 0; i < n; i++) {
			preorder[i] = (sc.nextInt());
		}
		Node root = constructBST(preorder);
		int[][] queries = new int[q][2];
		for (int i = 0; i < q; i++) {
			queries[i][0] = sc.nextInt();
			queries[i][1] = sc.nextInt();
		}
		ArrayList<Integer> ans = Solution.bstQueries(root, q, queries);
		for (Integer x : ans) {
			System.out.println(x);
		}
	}
}
class Solution {

    public static ArrayList<Integer> bstQueries(Node root, int q, int[][] queries) {
		//your code here
		ArrayList<Integer>inorder=new ArrayList<>();
		inorderTraversal(root,inorder);
		ArrayList<Integer>ans=new ArrayList<>();
		for(int i=0;i<q;i++){
			int L=queries[i][0];
			int R=queries[i][1];
			int left=leftIdx(inorder,L);
			int right=rightIdx(inorder,R);
			ans.add(right-left+1);
		}
		return ans;
    }
	private static int leftIdx(ArrayList<Integer>inorder,int val){
		int n=inorder.size();
		int l=0,h=n-1;
		while(l<h){
			int m=l+(h-l)/2;
			if(inorder.get(m)>=val) h=m;
			else l=m+1;
		}
		return inorder.get(l)>=val?l:l+1;
	}
	private static int rightIdx(ArrayList<Integer>inorder,int val){
		int n=inorder.size();
		int l=0,h=n-1;
		while(l<h){
			int m=l+(h-l+1)/2;
			if(inorder.get(m)>val) h=m-1;
			else l=m;
		}
		return inorder.get(l)<=val?l:l-1;
	}
	private static void inorderTraversal(Node root,ArrayList<Integer>inorder){
		if(root==null)return;
		inorderTraversal(root.left,inorder);
		inorder.add(root.data);
		inorderTraversal(root.right,inorder);
	}
}
