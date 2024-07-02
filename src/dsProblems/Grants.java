package dsProblems;
import java.io.*;
import java.util.*;

public class Grants {
	  
	  static double findGrantsCap(double[] grantsArray, double newBudget) {
	    // your code goes here
	    int n = grantsArray.length-1;
	    Arrays.sort(grantsArray);
	    double avgGrants = newBudget/n;
	    for(int i = 0; i<=n; i++){
	      if(grantsArray[i] <= avgGrants){
	          newBudget = newBudget-grantsArray[i];
	          avgGrants = newBudget/(n-i);
	          System.out.println(avgGrants);
	          continue;
	      } else{
	          return avgGrants;
	      }
	    }
	    return avgGrants;
	  }

	  public static void main(String[] args) {
	    double[] grantsArray = {2,100,50,120,1000};
	    System.out.println(findGrantsCap(grantsArray,190));

	  }

}
