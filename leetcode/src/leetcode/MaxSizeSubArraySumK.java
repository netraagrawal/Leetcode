package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubArraySumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(maxSubArrayLen(new int[]{-1,-2,2,1},1));
	}
	
	 public static int maxSubArrayLen(int[] nums, int k) {
	        
	        if(nums.length==0){
	            return 0;
	        }
	        
	        int result=0,sum=0;
	        Map<Integer,Integer> map=new HashMap<>();
	        map.put(0,-1);
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            if(map.containsKey(sum-k)){
	                result=Math.max(result,i-map.get(sum-k));
	                
	            }
	            if(!map.containsKey(sum)){
	                map.put(sum,i);
	            }
	        }
	        return result;
	    }

}
