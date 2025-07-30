class Solution {
    public int lastRemaining(int n) {
        return helper(n, true);
    }

    private int helper(int n, boolean leftToRight) {
        if(n==1){
            return 1;
        }
        return 2*helper(n/2,!leftToRight)-(leftToRight||n%2==1?0:1);
    }
}