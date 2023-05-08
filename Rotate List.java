//https://leetcode.com/problems/rotate-list/
//https://course.acciojob.com/idle?question=87e0d4e3-e18e-46bd-bccf-7c3409344674
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return head;
        ListNode tail,newHead;
        tail=head;
        int len=1;//number of nodes
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        k%=len;
        tail.next=head;
        if(k!=0){
            for(int i=0;i<len-k;i++){
                tail=tail.next;
            }
        }
        newHead=tail.next;
        tail.next=null;
        return newHead;
    }
}
//2nd approach

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int n=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            n++;
        }
        k%=n;
        if(k==0)return head;
        ListNode prev=new ListNode(0);
        prev.next=head;
        int cnt=0;
        ListNode right=prev;
        ListNode left=prev;
        while(cnt<k){
            right=right.next; cnt++;
        }
        while(right.next!=null){
            left=left.next;
            right=right.next;
        }
        ListNode temp=left.next;
        left.next=null;
        right.next=head;
        return temp;
    }
}
