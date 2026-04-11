class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // loop through all strs 
        // for every str sort it alphabatically and store in in map
        // if its already present in the map then put it in the already created
        // arrayList
        List<List<String>> output = new ArrayList<>();
        HashMap<String, Integer> stringMap = new HashMap<>();
        int mapIdx = 0;
        for (String str: strs) {
            String sortedString = sortStringInAscsOrder(str);
            if (stringMap.containsKey(sortedString)) {
                // word is present already
                int outputIdx = stringMap.get(sortedString);
                output.get(outputIdx).add(str);
            }
            else {
                // word is not present already
                stringMap.put(sortedString, mapIdx);
                List<String> newString = new ArrayList<>();
                newString.add(str);
                output.add(newString);
                ++mapIdx;
            }
        }
        return output;
    }

    private String sortStringInAscsOrder(String str) {
        char[] unsortedString =  str.toCharArray();
        Arrays.sort(unsortedString);
        return new String(unsortedString);
    }
}
