package leetcode;

public class jumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jump(new int[]{2,3,0,1,4}));
	}
	
	public static int jump(int[] nums) {
        int[] minJumps = new int[nums.length];
        for (int i = nums.length - 2; i >=0; i --) {
            int minJump = nums.length - 1;
            for (int j = i + 1; j <= Math.min(nums[i] + i, nums.length - 1); j ++) {
                minJump = Math.min(minJumps[j] + 1, minJump);
            }
            minJumps[i] = minJump;
            //System.out.println(median_two_arrays.array2Str(minJumps));
        }
        return minJumps[0];
    }

}
