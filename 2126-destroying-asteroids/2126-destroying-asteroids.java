class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long currmass=mass;
        Arrays.sort(asteroids);
        for(int i:asteroids){
            if(currmass<i) return false;
            currmass+=i;
        }
        return true;
    }
}