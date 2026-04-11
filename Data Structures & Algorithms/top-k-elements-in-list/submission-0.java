class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Sorts by value in increasing order
    .collect(Collectors.toMap(
        Map.Entry::getKey, 
        Map.Entry::getValue, 
        (e1, e2) -> e1, 
        LinkedHashMap::new));

        int[] answer = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> e: map.entrySet()){
            answer[i] = e.getKey();
            ++i;
            if (i == k) break;
        }
        return answer;
        
    }
}
