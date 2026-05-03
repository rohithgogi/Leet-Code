class Solution {
    public int maximalRectangle(char[][] matrix) {
        Stack<Integer> stack=new Stack<>();
        int[] height=new int[matrix[0].length];
        int[] left=new int[matrix[0].length];;
        int[] right=new int[matrix[0].length];
        int maxArea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }else{
                    height[j]=0;
                }
            }

            for(int k=0;k<height.length;k++){
                while(!stack.isEmpty() && height[stack.peek()]>=height[k]){
                    stack.pop();
                }
                left[k]=stack.isEmpty()?-1:stack.peek();
                stack.push(k);
                
            }
            stack.clear();
            for(int k=height.length-1;k>=0;k--){
                while(!stack.isEmpty() && height[stack.peek()]>=height[k]){
                    stack.pop();
                }
                right[k]=stack.isEmpty()?height.length:stack.peek();
                stack.push(k);
            }
            stack.clear();

            for(int k=0;k<height.length;k++){
                int width=right[k]-left[k]-1;
                maxArea=Math.max(maxArea,height[k]*width);
            }

        }
        return maxArea;
    }
}