class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        if (strs.length == 0) return answer;
        answer.add(new ArrayList<>(Arrays.asList(strs[0])));
        for (int i = 1; i < strs.length; i++) {
            boolean found = false;
            for (int j = 0; j < answer.size(); j++) {
                String s = answer.get(j).get(0);
                if (isAnagram(strs[i], s)) {
                    answer.get(j).add(strs[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                answer.add(new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        return answer;
    }

    private boolean isAnagram(String one, String two) {
        if (one.length() != two.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < one.length(); i++) {
            count[one.charAt(i) - 'a']++;
            count[two.charAt(i) - 'a']--;
        }
        for (int cnt : count) {
            if (cnt != 0) return false;
        }
        return true;
    }
}