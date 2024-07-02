package dsProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIp {
	
	static boolean validateIP(String ip) {
		// your code goes here
		boolean isCorrect = true;
		System.out.println(ip);
		//ip = ip.replaceAll(".",",");
		System.out.println(ip);
		String[] ipArr = ip.split("\\.");
		System.out.println(ipArr.length);
        for(int i=0;i<ipArr.length;i++){
            try{
            	System.out.println(ipArr[i].length());
                int x = Integer.parseInt(ipArr[i]);
				System.out.println(x);
				isCorrect = (x >=0 && x<=255)?true:false;
				if(!isCorrect)
					return isCorrect;
            } catch(NumberFormatException e){
                return false;
            }
        }
		return isCorrect;
	}

	public static void main(String[] args) {
		//String ip = "1e1.4.5.6";
		//System.out.println(validateIP(ip));
		
		String str = "FGb8";
		System.out.println(validHexa(str));
	
	}
	
	public static boolean validHexa(String str) {
		 Pattern pattern = Pattern.compile("[0-9A-Fa-f]+");
         Matcher match = pattern.matcher(str);
         if(!match.find()){
             return false;
         }
		return true;
	}
}
