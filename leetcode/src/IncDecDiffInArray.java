
public class IncDecDiffInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] out=calculateDiff(new int[]{1,2,3,1,1},3);
		for(int i=0;i<out.length;i++)
			System.out.println(out[i]);
		
	}
	
	public static int[] calculateDiff(int[] nums,int k){
		
		if(nums.length==0)
			return new int[]{};
		
		int[] inc=new int[nums.length];
		int[] dec=new int[nums.length];
		
		int[] output=new int[nums.length-k+1];
		int in=0,de=0;
		int o=0;
		for(int i=0;i<nums.length;i++){
			
			for(int j=i-1;j>=0 && j>i-k && nums[j+1]>=nums[j];j--){
					inc[j]++;
					in++;
			}
			
			for(int j=i-1;j>=0 && j>i-k && nums[j+1]<=nums[j];j--){
					dec[j]++;
					de++;
			}
			
			if(i>=k-1){
				
				if(i>k-1){
					in=in-inc[i-k];
					de=de-dec[i-k];
				}
				output[o++]=in-de;
			}
			
		}
		
		return output;
	}

}
