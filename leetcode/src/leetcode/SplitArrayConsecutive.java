package leetcode;
import java.util.*;
public class SplitArrayConsecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPossible(new int[]{10,10,11,11,11,11,12,12,12,12,13,15,16}));
	}
	
	public static boolean isPossible(int[] nums) {
        Integer prev = null;
        int prevCount = 0;
        Queue<Integer> starts = new LinkedList();
        int anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            int t = nums[i];
            if (i == nums.length - 1 || nums[i+1] != t) {
                int count = i - anchor + 1;
                if (prev != null && t - prev != 1) {
                    while (prevCount-- > 0)
                        if (prev < starts.poll() + 2) return false;
                    prev = null;
                }

                if (prev == null || t - prev == 1) {
                    while (prevCount > count) {
                        prevCount--;
                        if (t-1 < starts.poll() + 2)
                            return false;
                    }
                    while (prevCount++ < count)
                        starts.add(t);
                }
                prev = t;
                prevCount = count;
                anchor = i+1;
            }
        }

        while (prevCount-- > 0)
            if (nums[nums.length - 1] < starts.poll() + 2)
                return false;
        return true;
    }

}
