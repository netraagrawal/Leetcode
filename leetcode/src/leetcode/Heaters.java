package leetcode;

import java.util.TreeSet;

public class Heaters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRadius(new int[]{5,6,8,10},new int[]{8,11}));
	}
	
	 public static int findRadius(int[] houses, int[] heaters) {
	        TreeSet<Integer> heatersSet = new TreeSet<>();
	        for(int h : heaters) heatersSet.add(h);
	        
	        int min = 0;
	        for(int house : houses) {
	            Integer floor = heatersSet.floor(house);
	            Integer ceiling = heatersSet.ceiling(house);
	            if(floor == null) min = Math.max(min, ceiling - house);
	            else if(ceiling == null) min = Math.max(min, house - floor);
	            else min = Math.max(min, Math.min(ceiling - house, house - floor));
	        }
	        
	        return min;
	    }

}
