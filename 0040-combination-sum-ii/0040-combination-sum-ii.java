class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans =new ArrayList<>();
        backtrack(candidates,0,0,new ArrayList<>(),ans,target);
        return ans;
    }

    public void backtrack(int[] arr,int i,int sum,List<Integer> list,List<List<Integer>> ans, int target){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || i>=arr.length) return;

        list.add(arr[i]);
        backtrack(arr,i+1,sum+arr[i],list,ans,target);
        list.remove(list.size()-1);

        while(i+1<arr.length && arr[i]==arr[i+1]){
            i++;
        }
        backtrack(arr,i+1,sum,list,ans,target);
    }
}