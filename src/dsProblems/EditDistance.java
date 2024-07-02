package dsProblems;

import java.util.*;

public class EditDistance {

    public static int updateWord(List<String> words, String startWord, String endWord) {
        // If start and end words are the same, no edits are needed
        if (startWord.equals(endWord)) {
            return 0;
        }

        // Construct the graph
        Map<String, List<String>> oneEditDistanceGraph = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String baseWord = words.get(i);
            for (int j = 0; j < words.size(); j++) {
                if (i != j) {
                    String newWord = words.get(j);
                    if (isOneEditDistance(baseWord, newWord)) {
                        oneEditDistanceGraph.computeIfAbsent(baseWord, k -> new ArrayList<>()).add(newWord);
                    }
                }
            }
        }

        // Traverse graph
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(startWord, 0));
        Set<String> visitedWordSet = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String currWord = pair.getKey();
            int editDistance = pair.getValue();
            for (String word : oneEditDistanceGraph.getOrDefault(currWord, Collections.emptyList())) {
                if (!visitedWordSet.contains(word)) {
                    if (word.equals(endWord)) {
                        return editDistance + 1;
                    }
                    queue.add(new Pair<>(word, editDistance + 1));
                    visitedWordSet.add(word);
                }
            }
        }

        return -1; // Return -1 if no path is found
    }

    private static boolean isOneEditDistance(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffCharCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCharCount++;
                if (diffCharCount > 1) {
                    return false;
                }
            }
        }
        return diffCharCount == 1;
    }
    
    public static void main(String[] args) {
        // debug your code below
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hit", "hot", "dot", "dog", "cog");

        System.out.println(EditDistance.updateWord(wordList, beginWord, endWord));
    }

    // Helper class for pairs of words and their edit distance
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}