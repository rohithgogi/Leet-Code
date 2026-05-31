class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        boolean[][] dp=new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=true;
            ans++;
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                ans++;
            }
        }

        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                if(s.charAt(i)==s.charAt(i+len-1) && dp[i+1][i+len-2]){
                    dp[i][i+len-1]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
}