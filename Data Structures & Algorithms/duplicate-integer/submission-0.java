class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> originals = new HashSet<>();

        for (int i = 0; i<nums.length; i++){
            if (originals.contains(nums[i])) return true;
            originals.add(nums[i]);
        }

        return false;
    }
}