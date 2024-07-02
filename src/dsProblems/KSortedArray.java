package dsProblems;

import java.util.PriorityQueue;

/**
 * 
 * @author megha
 * Sort an almost-sorted, k-sorted or nearly-sorted array
 *
 */

public class KSortedArray {
	
	//First simple approach I can think of is sorting the array and print it.
	// Which will take o(nlogn)time complexity. we can use quickSort(in-place) or mergeSort(not in-place).
	
	//If n is small we can utilize insertion sort , which will take o(nk) time.
	
	//Third solution is to use quick sort for better time complexity
	//Read : https://www.javatpoint.com/sort-an-almost-sorted-k-sorted-or-nearly-sorted-array
	
	//Fourth solution would me to utilize min-heap of k+1 size. 
	public int[] sortArray(int[] arr,int k) {
		
		int heap_size = k+1;
		int[] num = new int[arr.length];
		if(arr.length == k)
			heap_size = k;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(heap_size);
		for(int i=0 ;i<=k;i++) {
			minHeap.add(arr[i]);
		}
		
		int index =0;
		for(int i =k+1;i<arr.length;i++) {
			num[index] = minHeap.poll();
			minHeap.add(arr[i]);
			index++;
		}
		
		while(!minHeap.isEmpty()) {
			num[index] = minHeap.poll();
			index++;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 2, 3, 8, 7, 6};
		int k = 2;
		
		int[] nums = new KSortedArray().sortArray(arr, k);
		
		for(int i= 0; i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}

}
