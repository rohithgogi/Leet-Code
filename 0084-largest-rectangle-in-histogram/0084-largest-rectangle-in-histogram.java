class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=heights[0];
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<heights.length;i++){
           while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
            stack.pop();
           }
           left[i]=stack.isEmpty()?-1:stack.peek();
           stack.push(i);
        }
        stack.clear();

        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }



        for(int i=0;i<heights.length;i++){
            int width=right[i]-left[i]-1;
            maxArea=Math.max(maxArea,width*heights[i]);
        }
        return maxArea;
    }
}