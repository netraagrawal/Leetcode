package leetcode;

import java.util.*;

public class LargestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,30,34,8,10};
		System.out.println(largestNumber(nums));
	}
	
	
	
	static class CustomNumer {

		public Integer number;
		public CustomNumer(int number) {
			this.number = number;
		}
	}
	
	static class CustomNumerCompare implements Comparator<CustomNumer> {

		@Override public int compare(CustomNumer o1, CustomNumer o2) {
			Integer x2 = o1.number;
			Integer x1 = o2.number;
			//System.out.println(Integer.toString(x1).concat(Integer.toString(x2))+":"+Integer.toString(x2).concat(Integer.toString(x1)));
			return Integer.toString(x1).concat(Integer.toString(x2)).compareTo(Integer.toString(x2).concat(Integer.toString(x1)));
		}
	}


	public static String largestNumber(int[] nums) {

		if(nums.length ==0) {
			return "";
		}
		PriorityQueue<CustomNumer> pq = new PriorityQueue<>(new CustomNumerCompare());
		for(int i=0;i< nums.length;i++) {
			CustomNumer customNumer = new CustomNumer(nums[i]);
			pq.add(customNumer);
			System.out.println("peek:"+pq.peek().number);
		}

		String solution = "";
		while (!pq.isEmpty()) {

			solution = solution + (Integer.toString(pq.peek().number));
			pq.poll();
		}
		while(solution.length()>1 && solution.charAt(0) == '0') {
			solution = solution.substring(1, solution.length());
		}
		return solution;
	}

	
}
