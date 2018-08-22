package leetcode;

public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
	}
	
	public static int findTargetSumWays(int[] nums, int S) {
	        int[][] dp = new int[nums.length][2];
	        dp[0][nums[0] + 1] = 1;
	        dp[0][-nums[0] + 1] += 1;
	        for (int i = 1; i < nums.length; i++) {
	            for (int sum = -1; sum <= 1; sum++) {
	                if (dp[i - 1][sum + 1] > 0) {
	                    dp[i][sum + nums[i] + 1] += dp[i - 1][sum + 1];
	                    dp[i][sum - nums[i] + 1] += dp[i - 1][sum + 1];
	                }
	            }
	        }
	        return S > 1 ? 0 : dp[nums.length - 1][S + 1];
	    }

}
