package leetcode;

import java.util.Arrays;

public class HeaterBS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses={5,6,7,8,10};
		int[] heaters={8,11};
		System.out.println(findRadius(houses ,heaters ));
	}
	
	public static int findRadius(int[] houses, int[] heaters) {
	    Arrays.sort(heaters);
	    int result = 0;
	    
	    for (int house : houses) {
	        int index = Arrays.binarySearch(heaters, house);
	        if (index < 0) {
	            index = ~index;
	            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
	            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
	            
	            result = Math.max(result, Math.min(dist1, dist2));
	        }
	    }
	    
	    return result;
	}

}
