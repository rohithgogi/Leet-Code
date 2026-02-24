class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(String s,int idx,List<String> list,List<List<String>> ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                list.add(s.substring(idx,i+1));
                backtrack(s,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }

    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}