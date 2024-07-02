package dsProblems;

import java.util.*;

public class EditDistance1 {

    public static int updateWord(List<String> words, String startWord, String endWord) {
        // your code goes here
        if(startWord.equals(endWord))
            return 0;
        Map<String,List<String>> oneEditDistanceGraph = new HashMap<>();
        for(int i = 0; i < words.size(); i++){
            String word = words.get(i);
            for(int j = 0; j < words.size(); j++){
                if(i != j){
                    String curWord = words.get(j);
                    if(isOneEditDistance(word,curWord)){
                        oneEditDistanceGraph.computeIfAbsent(word, k -> new ArrayList()).add(curWord);
                    }
                }
            }

        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord,0));
        Set<String> visitedString = new HashSet<>();
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(!visitedString.contains(pair.getKey())){
                for(String str : oneEditDistanceGraph.getOrDefault(pair.getKey(),Collections.emptyList())){
                    if(str.equals(endWord)){
                        return pair.getDistance() +1;
                    }
                    queue.add(new Pair(str,pair.getDistance()+1));
                    visitedString.add(str);
                }
            }
        }
        return -1;
    }

    public static boolean isOneEditDistance(String word1, String word2){
        if(word1.length() != word2.length())
            return false;
        int diffCharCount = 0;
        for(int i =0; i<word1.length();i++){
           if(word1.charAt(i) != word2.charAt(i)){
                diffCharCount++;
                if(diffCharCount > 1)
                    return false;
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

    static class Pair{
        private String key;
        private int distance;

        public Pair(String key, int distance ){
            this.key = key;
            this.distance = distance;
        }

        public String getKey(){
            return this.key;
        }
        public int getDistance(){
            return this.distance;
        }

    }
}
