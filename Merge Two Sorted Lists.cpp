//https://leetcode.com/problems/merge-two-sorted-lists/description/
//https://course.acciojob.com/idle?question=0a80f2b0-70b8-4f71-85c6-761b1313dae5
class Solution {
public://iterative->recursion
ListNode* merge(ListNode* l1, ListNode* l2)
{
    if(l1==NULL) return l2;
    else if(l2==NULL) return l1;
   else  if(l1->val<l2->val)
    {
        l1->next=merge(l1->next,l2);
        return l1;
    }else{
        l2->next=merge(l1,l2->next);
        return l2;
    }
}
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        return merge(list1,list2);
    }
};
