package dsProblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class SortedArrayInDesc {
	
public int[] sortArray(int[] arr,int k) {
		
		int heap_size = k+1;
		int[] num = new int[arr.length];
		if(arr.length == k)
			heap_size = k;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<arr.length;i++) {
			minHeap.add(arr[i]);
		}
		
		int index =0;
		/*for(int i =k+1;i<arr.length;i++) {
			num[index] = minHeap.poll();
			minHeap.add(arr[i]);
			index++;
		}*/
		
		while(!minHeap.isEmpty()) {
			num[index] = minHeap.poll();
			index++;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 2, 3, 8, 7, 6};
		int k = 2;
		
		int[] nums = new SortedArrayInDesc().sortArray(arr, k);
		
		for(int i= 0; i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}

}
