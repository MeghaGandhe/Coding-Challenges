package dsProblems;

import java.util.*;

public class SentenceSimilarity {

    public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, String[][] similarPairs) {
        // your code goes here
        boolean isSimilar = true;
        if(sentence1.length != sentence2.length)
            return isSimilar == false;

        Map<String,String> similarWords = new HashMap<>();
        for(int i =0;i<similarPairs.length;i++){
            similarWords.put(similarPairs[i][0],similarPairs[i][1]);

        }
        for(int i =0;i<sentence1.length;i++){
            if(sentence1[i].equals(sentence2[i]))
                continue;
            isSimilar = BFS(similarWords,sentence1[i],sentence2[i]);
            System.out.println("isSimilar="+isSimilar);
            if(isSimilar)
                continue;
            else
            	return false;
        }

        return isSimilar;

    }

    public static boolean BFS(Map<String,String> similarWords,String word1, String word2){
        Set<String> visited = new HashSet<>();
        String str = word1;
        boolean isSimilar = false;
        while(!visited.contains(str)){
        	visited.add(str);
            if(similarWords.containsKey(str)){
                str = similarWords.get(str);
                if(str.equals(word2)){
                    isSimilar = true;
                    break;
                    //return true;
                }
            } else if(similarWords.containsValue(str)){
                for(Map.Entry<String,String> entry : similarWords.entrySet()){
                    if(entry.getValue().equals(str)){
                    	if(visited.contains(entry.getKey()))
                    		continue;
                    	str = entry.getKey();
                        if(str.equals(word2)){
                            isSimilar = true;
                            break;
                        }
                    }
                }
                if(isSimilar)
                	break;
            } else{
                isSimilar = false;
                break;
            }
        }
        return isSimilar;
    }

    public static void main(String[] args) {
        String[] sentence1 = {"i", "really", "love", "leetcode", "and", "apples"};
        String[] sentence2 = {"i", "so", "like", "codesignal", "and", "oranges"};
        String[][] similarPairs = {
            {"very", "so"},
            {"love", "adore"},
            {"really", "very"},
            {"leetcode", "codesignal"},
            {"apples", "oranges"},
            {"like", "adore"},
        };

        boolean result = areSentencesSimilar(sentence1, sentence2, similarPairs);
        System.out.println(result); // Expected output: true
    }
}