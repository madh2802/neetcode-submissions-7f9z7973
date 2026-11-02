class Solution {
    public boolean isAnagram(String s, String t) {
        // HashMap<char, int> map = new HashMap();
        // for (int i = 0; i<s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i)), 1);
        // }
        if (s.length() != t.length()) return false;
        int a[] = new int[26];
        for (int i = 0; i<s.length(); i++) {
            int idx1 = s.charAt(i) - 'a';
            int idx2 = t.charAt(i) - 'a';
            a[idx1]++;
            a[idx2]--;
        }
        
        for (int i = 0; i<26; i++) {
            if (a[i] != 0) return false;
        }
        return true;
    }
}
