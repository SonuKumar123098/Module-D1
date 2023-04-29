//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
class Solution {
    //optimal way to do
    public int shortestSubarray(int[] nums, int k) {
        Deque<long[]>dq=new LinkedList<>();
        int n=nums.length;
        long sum=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            //maintain deque in increasing order
            while(!dq.isEmpty() && dq.peekLast()[1]>=sum){
                dq.removeLast();
            }
            dq.addLast(new long[]{i,sum});
            if(sum>=k) ans=Math.min(ans,i+1);//check s2>=k
            //check s2-s1>=k
            while(!dq.isEmpty() && dq.peekLast()[1]-dq.peekFirst()[1]>=k){
                ans=Math.min(ans,(int)(dq.peekLast()[0]-dq.peekFirst()[0]));
                dq.removeFirst();
            }

        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
