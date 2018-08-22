package leetcode;
import java.util.*;
public class CombinationSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum4(new int[]{2,3,4},6));
	}
	private static int[] dp;
	public static int combinationSum4(int[] nums, int target) {
	    dp = new int[target + 1];
	    Arrays.fill(dp, -1);
	    dp[0] = 1;
	    return helper(nums, target);
	}

	private static int helper(int[] nums, int target) {
	    if (dp[target] != -1) {
	        return dp[target];
	    }
	    int res = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (target >= nums[i]) {
	            res += helper(nums, target - nums[i]);
	        }
	    }
	    dp[target] = res;
	    return res;
	}

}
