class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        boolean[] dp=new boolean[n];
        dp[0]=true;
        int reachable=0;
        for(int i=1;i<n;i++){
            if(i-minJump>=0 && dp[i-minJump]){
                reachable++;
            }
            if(i-maxJump-1>=0 && dp[i-maxJump-1]){
                reachable--;
            }
            if(reachable>0 && s.charAt(i)=='0') dp[i]=true;
        }
        return dp[n-1];
    
        
    }
    public boolean travel(String s,int min,int max,boolean[] vis,int curr){
        if(curr==s.length()-1 && s.charAt(curr)=='0') return true;
        if(vis[curr]==true) return false;
        for(int j=curr+min;j<=Math.min(curr+max,s.length()-1);j++){
            
            if(s.charAt(j)=='1') continue;
            
            if(travel(s,min,max,vis,j)) return true;
        }
        vis[curr]=true;
        return false;
    }
}