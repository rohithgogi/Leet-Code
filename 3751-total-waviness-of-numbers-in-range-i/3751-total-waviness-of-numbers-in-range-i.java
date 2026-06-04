class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int i=num1;i<=num2;i++){
            ans+=waviness(i);
        }
        return ans;
    }
    public int waviness(int num){
        int temp=num;
        int count=0;
        List<Integer> list=new ArrayList<>();
        while(temp!=0){
            list.add(temp%10);
            temp=temp/10;
        }
        int start=0;
        int end=start+2;
        while(start<=list.size()-3){
            if(list.get(start)<list.get(start+1) && list.get(start+1)>list.get(start+2)) count++;
            if(list.get(start)>list.get(start+1) && list.get(start+1)<list.get(start+2)) count++;
            start++;
            end++;
        }
        return count;

    }
}