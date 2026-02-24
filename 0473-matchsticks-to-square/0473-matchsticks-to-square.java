class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int n=matchsticks.length;
        if(n<4) return false;
        int sum=0;
        for(int i:matchsticks){
            sum+=i;
        }
        if(sum%4 != 0) return false;

        return backtrack(matchsticks,0,new int[4],sum/4);

    }
    public boolean backtrack(int[] arr,int idx,int[] sides,int target){
        if(idx==arr.length) return true;
        for(int i=0;i<4;i++){
            if(sides[i]+arr[idx]>target) continue;

            sides[i]+=arr[idx];
            if(backtrack(arr,idx+1,sides,target)) return true;
            sides[i]-=arr[idx];

            if(sides[i]==0) break;
        }
        return false;

    }
}