class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                list.add(i);
            }
        }
        list.add(n);
        if(k<=list.size()) return list.get(k-1);
        return -1;

    }
}