package leetcode;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wiggleSort(new int[]{3,2,5,1,6,4});
	}
	
	public static void wiggleSort(int[] nums) {
        if(nums.length==0){
            return;
        }
        boolean flag=true;
        for(int i=0;i<nums.length-1;i++){
            if(flag){
                if(nums[i]>nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
            else{
                if(nums[i]<nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
            flag=!flag;
        }
    }
    
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
