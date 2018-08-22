package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Kempty2 {
	public static void main(String args[]) {
		
		int arr[] = {3,1,5,4,2};
		System.out.println(kempty(arr, 3));

	}

	public static int kempty(int[] flowers, int k) {
		if (flowers.length == 0) {
			return 0;
		}
		if (k == flowers.length) {
			return k;
		}
		
		int latest = 0;
		int[] spots = new int[flowers.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < flowers.length; i++) {
			map.put(i + 1, 0);
		}

		for (int i = 0; i < flowers.length; i++) {
			int flowerNum = flowers[i] - 1;
			map.put(flowerNum + 1, map.get(flowerNum + 1) + 1);
			spots[flowerNum]=1;
			if( flowerNum< flowers.length-1 && spots[flowerNum+1] > 0) {
				spots[flowerNum] += spots[flowerNum + 1];
			}
			if (flowerNum>0 && spots[flowerNum - 1] > 0) {
				spots[flowerNum] += spots[flowerNum - 1];
			}
			
			map.put(flowerNum + 1, spots[flowerNum]);
			for (int index = flowerNum - 1; index >= 0; index--) {
				if (spots[index] == 0) {
					break;
				}
				spots[index] = spots[flowerNum];
				map.put(index + 1, map.get(flowerNum + 1));
			}
			
			for (int index = flowerNum + 1; index < flowers.length; index++) {
				if (spots[index] == 0) {
					break;
				}
				spots[index] = spots[flowerNum];
				map.put(index + 1, map.get(flowerNum + 1));
			}
			
			if(map.containsValue(k))
			{
				System.out.println();
				latest=i+1;
			}
			
		}
		return latest;
	}
}