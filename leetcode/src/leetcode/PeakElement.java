package leetcode;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPeakElement(new int[]{5,2,3,1}));
	}
	
	public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

}
