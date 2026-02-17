class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean vis[] =new boolean[nums.length];
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(nums,vis,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int[] nums,boolean[] vis,List<Integer> list,List<List<Integer>> ans){

        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            
            if(vis[i]) continue;

            if(i>0 && nums[i-1]==nums[i] && !vis[i-1]) continue;
            vis[i]=true;
            list.add(nums[i]);
            backtrack(nums,vis,list,ans);

            vis[i]=false;
            list.remove(list.size()-1);
        }
    }
}