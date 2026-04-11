class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length-1;
        boolean isFound = false;
        while(startRow <= endRow) {
            int midRow = (startRow + endRow) / 2;
            if (matrix[midRow][0] <= target && matrix[midRow][endCol] >= target) {
                isFound = binarySearchForGivenArray(matrix[midRow], target);
                break;
            }
            else if (matrix[midRow][0] > target) endRow = midRow-1;
            else startRow = midRow+1;
        }
        return isFound;
    }

    private boolean binarySearchForGivenArray(int[] searchSpace, int target) {
        int s = 0;
        int e = searchSpace.length-1;

        while(s<=e) {
            int mid = (s+e)/2;
            if (searchSpace[mid] == target) return true;
            else if (searchSpace[mid] > target) e = mid-1;
            else s = mid + 1;
        }
        return false;
    }
}
