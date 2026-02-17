class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        backtrack(arr,0,k,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int[] arr,int i,int k,List<Integer>list,List<List<Integer>> ans){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i==arr.length) return;
        list.add(arr[i]);
        backtrack(arr,i+1,k,list,ans);

        list.remove(list.size()-1);
        backtrack(arr,i+1,k,list,ans);
    }
}