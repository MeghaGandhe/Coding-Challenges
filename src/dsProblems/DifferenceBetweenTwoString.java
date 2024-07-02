package dsProblems;

import java.util.*;

class DifferenceBetweenTwoString {

	static String[] diffBetweenTwoStrings(String source, String target) {
		// your code goes here
        List<String> result = new ArrayList<>();
        diffBetweenTwoStrings(source,target,0,0,result);
        return result.toArray(new String[0]);
        
	}

    static List<String> diffBetweenTwoStrings(String source, String target, int i, int j, List<String> result){
        if(source == null || target == null)
            return result;
        if(i >= source.length() && j >= target.length())
        	return result;
        else if(i >= source.length() && j < target.length()){
        		result.add("+" + target.charAt(j));
        		return diffBetweenTwoStrings(source,target,i,j+1,result);     
        }

        else if(source.charAt(i) == target.charAt(j)){
            result.add(""+source.charAt(i));
            return diffBetweenTwoStrings(source,target,i+1,j+1,result);
        }
        else{
            List<String> result1 = diffBetweenTwoStrings(source,target,i+1,j,result);
            List<String> result2 = diffBetweenTwoStrings(source,target,i,j+1,result);
            if(result1.size() < result2.size())
                result.add("-" + source.charAt(i));
            else
                result.add("+" + target.charAt(j));

            return result;
        }

    }

	public static void main(String[] args) {
        // debug your code below
        String source = "ABCDEFG";
        String target = "ABDFFGH";
        String[] result = diffBetweenTwoStrings(source, target);
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}