//https://leetcode.com/problems/reverse-linked-list-ii/description/
//https://course.acciojob.com/idle?question=8507a3b7-ff9c-45c2-b12c-d886d2e145df

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy=new ListNode(1);
		dummy.next=head;
		ListNode cur=dummy;
		ListNode prev=null;
		int cnt=0;
		// reach at the node where reverse start
		while(cnt!=left){
			prev=cur;
			cur=cur.next;
			cnt++;
		}
		//reverse the node from left to right
		ListNode inner_prev=null;
		ListNode inner_cur=cur;
       while(cnt!=right+1){
		   ListNode temp=inner_cur.next;
		   inner_cur.next=inner_prev;
		   inner_prev=inner_cur;
		   inner_cur=temp;
		   cnt++;
	   }
		// connecting the reverse linked list adjusting its position
		prev.next=inner_prev;
		cur.next=inner_cur;
		return dummy.next;
    }
}
