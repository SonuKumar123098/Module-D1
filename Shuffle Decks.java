//https://course.acciojob.com/idle?question=0d4632ba-59a1-4644-bd9f-8ff8f9e086dc
import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node next;
    Node(int key){
        data = key;
        next = null;
    }
}

class Main{
    static Node head;
    static Node temp;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		head = null;
		temp = null;
		addToTheLast(a1);
		
		for(int i = 1; i < n; i++){
			int data = sc.nextInt();
			addToTheLast(data);
		}
		Solution ans = new Solution();
		Node node = ans.shuffleDeck(head);
		printList(node);
		System.out.println();
    }
    
    public static void addToTheLast(int data){
        if(head == null){
			head = new Node(data);
			temp =head;
			return ;
		}
		else{
			Node new_node = new Node(data);
			temp.next = new_node;
			temp=temp.next;
			return;		
		}
    }
    
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Solution{

    public static Node shuffleDeck(Node node){
       //your code here
		if(node==null)return node;
		Node head=node;
		Node slow=node;
		Node fast=node;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		//second half linkedlist
		Node temp=slow.next;
		slow.next=null;
		Node prev=null;
		//reversing second half list
		Node cur=temp;
		while(cur!=null){
			temp=cur.next;
			cur.next=prev;
			prev=cur;
			cur=temp;
		}
		//joining the both half list in alternate order
		Node cur1=node;
		Node cur2=prev;
		while(cur1!=null && cur2!=null){
			temp=cur1.next;
			cur1.next=cur2;
			cur1=temp;
			temp=cur2.next;
			cur2.next=cur1;
			cur2=temp;
		}
		return node;
    }
}

