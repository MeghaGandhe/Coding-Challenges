package dsProblems;

public class CountPrime {
	public static int countPrimes(int n) {
        if(n == 0 || n==1)
            return 0;
        if(n == 2)
            return 1;
        for(int i = 2;i<n;i++){
            if(n%i == 0)
                return countPrimes(n-1);
        }
        return countPrimes(n-1)+1;
        
    }
	
	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}

}
