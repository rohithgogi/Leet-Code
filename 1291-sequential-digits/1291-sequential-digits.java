class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=9;i++){
            if(i>=low && i<=high) ans.add(i);
            int num=i;

            while(true){
                int rem=num%10;
                
                if(rem<9){
                    num=num*10+(rem+1);
                }else{
                    break;
                } 
                if(num>high) break;
                if(num>=low && num<=high) ans.add(num);
                
            }
        }
        Collections.sort(ans);
        return ans;
    }
}