class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int[] fact=new int[n];
        fact[0]=1;
        for(int i=1;i<n;i++){
            fact[i]=fact[i-1]*i;
        }

        k=k-1;
        StringBuilder ans=new StringBuilder();
        for(int i=n;i>=1;i--){
            int idx=k/fact[i-1];
            ans.append(list.get(idx));
            list.remove(idx);
            k=k%fact[i-1];

        }
        return ans.toString();
        
    }
}