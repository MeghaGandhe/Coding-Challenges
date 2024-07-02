package dsProblems;

public class DuplicationInString1 {
	
	public static String removeDuplicates(String s, int k) {

        StringBuilder sf = new StringBuilder(s);
        int startIndex = 0;
        int endIndex = 0;
        boolean diff = false;
        char c = sf.charAt(0);
        for(int i = 0; i<sf.length();i++){
            System.out.println(sf.toString());
            char c1 = sf.charAt(i);
            if( c  == c1){
                endIndex = i;
                diff = false;
            }else{
                diff = true;
                c = sf.charAt(i);
                startIndex = i;
                endIndex = i;
            }
            if(endIndex-startIndex == (k-1)){
                sf = sf.delete(startIndex,endIndex+1);
                i = 0;
                startIndex = 0;
                endIndex = 0;
                c = sf.charAt(0);
                diff = false;
            }
        }
        return sf.toString();
        
    }
	
	public static void main(String[] args) {
		String s = "pbbcggttciiippooaais";
		int k = 2;
		System.out.println(removeDuplicates(s,k));
	}

}
