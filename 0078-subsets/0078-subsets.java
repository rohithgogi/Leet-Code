class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(nums,0,new ArrayList<>(),ans);
        return ans;
    }

    public void recursion(int[] arr,int i,List<Integer> list, List<List<Integer>> ans){
        if(i==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        recursion(arr,i+1,list,ans);
        list.remove(list.size()-1);
        recursion(arr,i+1,list,ans);
    }

}