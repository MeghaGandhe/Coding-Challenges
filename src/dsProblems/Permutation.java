package dsProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
	
	public static void main(String[] args) {
		int [] nums = {1,2,3};
		List<List<Integer>> pairs = new Permutation().findPermutation(nums);
		for(List<Integer>pair : pairs) {
			System.out.print("(");
			for(int i =0;i<pair.size();i++) {
				System.out.print(pair.get(i) + ",");
			}
			System.out.print(") ");
			//System.out.println();
		}
	}
	
	public List<List<Integer>> findPermutation(int[] nums){
		List<List<Integer>> pairs = new ArrayList<>();
		List<Integer> pair = new ArrayList<>();
		if(nums.length == 0) {
			pairs.add(new ArrayList<>());
			return pairs;
		}
		
		for(int i =0;i<nums.length;i++) {
			pair.add(nums[i]);
		}
		
		for(int i =0;i<nums.length;i++) {
			for(int j =0;j<nums.length;j++) {
				Collections.swap(pair, i, j);
				pairs.add(new ArrayList<Integer>(pair));
				Collections.swap(pair, i, j);
			}
		}
		return pairs;
	}

}
