package leetcode;

public class SortColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sortColors(new int[]{0,1,2,0,1,1}));
	}
	public static int[] sortColors(int[] nums) {
        
        if(nums.length==0){
            return new int[]{};
        }
        int[] color=new int[3];
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            color[nums[i]]++;
        }
        
        int c=0;
        for(int i=0;i<color.length;i++){
            System.out.print("i:"+i+" "+color[i]);
            while(color[i]>0){
                result[c]=i;
                color[i]--;
                c++;
            }
        }
        return result;
    }
}
