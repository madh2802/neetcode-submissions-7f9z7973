class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int initialPointer = 0;
        int longestSubstringLength = 0;
        for (int i = 0; i<s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
            int indexOfChar = map.get(s.charAt(i));
            if (indexOfChar != i) {
                longestSubstringLength = Math.max(longestSubstringLength, i - initialPointer);
                initialPointer = Math.max(indexOfChar + 1, initialPointer);
                map.put(s.charAt(i), i);
            }
        }
        // if (initialPointer == 0) return s.length();
        return Math.max(longestSubstringLength, s.length()-initialPointer);
    }
}
