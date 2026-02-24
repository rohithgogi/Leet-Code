class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> ans=new ArrayList<>();
         backtrack(n,new String(),0,0,ans);
         return ans;
    }
    public void backtrack(int n,String s,int open,int close,List<String> list){

        if(s.length()==2*n){
            list.add(new String(s));
            return;
        }
        if(open<n){
            backtrack(n,s+"(",open+1,close,list);
        }
        if(close<open){
            backtrack(n,s+")",open,close+1,list);
        }
    }
}