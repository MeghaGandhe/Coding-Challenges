package dsProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author megha
 * Problem statement: Given an array of integer, find all possible combination of those numbers.
 */
public class Combination {
	
	public static void main(String[] args) {
		
		int[] nums = {2,3,4};
		List<List<Integer>> combinations = new Combination().findCombination(nums);
		for(List<Integer> list : combinations) {
			for(int num : list) {
				System.out.print(num);
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> findCombination(int[] nums){
		
		List<List<Integer>> combinations = new ArrayList<>();
		//List<List<Integer>> combinations1 = new ArrayList<>();
		backtrack(new ArrayList<Integer>(),combinations, nums, 0);
		//backtrackForNonArray(new ArrayList<Integer>(),combinations1, 3, 1);
		return combinations;
	}
	
	//This code will generate unnecessary extra pairs as well. We will need to get rid of that.
	
	public void backtrack(List<Integer> numsList,List<List<Integer>> combinations, int[] nums, int index){
		if(numsList.size() != 0)
			combinations.add(new ArrayList<>(numsList));
		
		if(index == nums.length) return;
		
		backtrack(new ArrayList<>(numsList),combinations,nums,index+1);
		numsList.add(nums[index]);
		
		backtrack(new ArrayList<>(numsList),combinations,nums,index+1);
		numsList.remove(numsList.size()-1);
		
	}
	
	public void backtrackForNonArray(List<Integer> numsList,List<List<Integer>> combinations, int n, int index){
		if(numsList.size() != 0)
			combinations.add(new ArrayList<>(numsList));
		
		if(index > n) return;
		
		backtrackForNonArray(new ArrayList<>(numsList),combinations,n,index+1);
		numsList.add(index);
		
		backtrackForNonArray(new ArrayList<>(numsList),combinations,n,index+1);
		numsList.remove(numsList.size()-1);
		
	}

}
