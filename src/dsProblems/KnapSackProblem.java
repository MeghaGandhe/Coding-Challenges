package dsProblems;

public class KnapSackProblem {

    public static int knapsack(int[] weight, int[] values, int cap) {
        int[][] cache = new int[values.length][cap+1];
       return knapSack_helper(weight,values,cap,values.length-1,cache);
    }

    public static int knapSack_helper(int[] weight, int[] values, int cap, int length, int[][] cache){
        if(length < 0 || cap == 0) return 0;
        if(cache[length][cap] !=0)
            return cache[length][cap];
        if(cap < weight[length]){
            cache[length][cap] = knapSack_helper(weight,values,cap,length-1,cache);
            return cache[length][cap];
        }
        cache[length][cap] = Math.max(values[length]+knapSack_helper(weight,values,cap-weight[length],length-1,cache),
                                        knapSack_helper(weight,values,cap,length-1,cache));
        return cache[length][cap];

    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        System.out.println("Maximum value in knapsack = " + knapsack(weights, values, capacity));
    }
}
