class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        rec(candidates,0,new ArrayList<>(),ans,0, target);
        return ans;
    }
    public void rec(int[] arr,int i,List<Integer> list,List<List<Integer>> ans,int sum,int target){
        if(sum>target || i==arr.length) return;
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(arr[i]);
        
        rec(arr,i,list,ans,sum+arr[i],target);
        list.remove(list.size()-1);

        rec(arr,i+1,list,ans,sum,target);


    }
}