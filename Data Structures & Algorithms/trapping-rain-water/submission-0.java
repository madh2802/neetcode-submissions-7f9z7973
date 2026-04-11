class Solution {
    public int trap(int[] height) {
        // traverse through height array
        // while doing that calculate miximum water a single height can accomodate
        // find the largest integer to the left of that height and largest integer
        // to the right of that hight
        // total water trapped will be equal to min of those two height minus the 
        // initial height at that index.
        // add all the sums of these water trapped which will give us the maximum water
        // trapped

        int maxWaterTrapped = 0;
        for (int i = 0; i<height.length; i++) {
            int leftMax = calculateLargestIntToLeft(height, i-1);
            int rightMax = calculateLargestIntToRight(height, i+1);

            if (leftMax > height[i] && rightMax > height[i]) {
                maxWaterTrapped += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return maxWaterTrapped;
    }

    private int calculateLargestIntToLeft(int[] height, int idx) {
        int maxHeight = -1;
        for (int i = idx; i>-1; i--) {
            maxHeight = Math.max(height[i], maxHeight);
        }
        return maxHeight;
    }

    private int calculateLargestIntToRight(int[] height, int idx) {
        int maxHeight = -1;
        for (int i = idx; i<height.length; i++) {
            maxHeight = Math.max(height[i], maxHeight);
        }
        return maxHeight;
    }
}
