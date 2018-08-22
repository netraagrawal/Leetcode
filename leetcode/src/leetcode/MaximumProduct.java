package leetcode;

public class MaximumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,4},100));
	}
	
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;        
    }

}
