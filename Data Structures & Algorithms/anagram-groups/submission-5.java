

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s : strs) {
            // Count frequency of each character 'a' - 'z'
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build a unique string key from the frequency array
            StringBuilder keyBuilder = new StringBuilder();
            for (int freq : count) {
                keyBuilder.append('#').append(freq);
            }
            String key = keyBuilder.toString();

            // Group anagrams under the same frequency key
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}