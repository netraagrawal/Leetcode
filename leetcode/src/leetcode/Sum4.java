package leetcode;
import java.util.*;
public class Sum4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res=fourSum(new int[]{0,1,5,0,1,5,5,-4},11);
		
	}
	
	    public static List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> result=new ArrayList<>();
	        if(nums.length==0){
	            return result;
	        }
	        
	        Arrays.sort(nums);
	        if(nums[nums.length-1]*4<target || nums[0]*4>target){
	            return result;
	        }
	        int len=nums.length;
	        int i,n;
	        for(i=0;i<len;i++){
	            n=nums[i];
	            if(i>0 && n==nums[i-1]){
	                continue;
	            }
	            if(n+(3*nums[len-1])<target){
	                continue;
	            }
	            if(n*4>target){
	                break;
	            }
	            if(n*4==target){
	                if(i+3<len && nums[i+3]==n){
	                    result.add(Arrays.asList(n,n,n,n));
	                }
	                break;
	            }
	            
	            threeSum(nums,i+1,len-1,n,result,target-n);
	        }
	        return result;
	    }
	    
	    public static void threeSum(int[] nums,int start,int end,int first,List<List<Integer>> result,int target ){
	        if(start+1>=end){
	            return;
	        }
	        if(nums[start]*3>target || nums[end]*3<target){
	            return;
	        }
	        
	        int i,n1;
	        for(i=start;i<=end;i++){
	            n1=nums[i];
	            if(i>start && n1==nums[i-1]){
	                continue;
	            }
	            if(n1+2*nums[end]<target){
	                continue;
	            }
	            if(n1*3>target){
	                break;
	            }
	            if(n1*3==target){
	                if(i+2<=end && nums[i+2]==n1){
	                    result.add(Arrays.asList(first,n1,n1,n1));
	                }
	                break;
	            }
	            twoSum(nums,i+1,end,first,n1,result,target-n1);
	        }
	    }
	    
	    public static void twoSum(int[] nums,int start,int end,int first,int second,List<List<Integer>> result,int target){
	        
	        if(start>=end){
	            return;
	        }
	        if(2*nums[end]<target || 2*nums[start]>target){
	            return;
	        }
	        
	        int i=start,j=end;
	        int sum=0;
	        while(i<j){
	            sum=nums[i]+nums[j];
	            if(sum<target){
	                i++;
	            }
	            else if(sum>target){
	                j--;
	            }
	            else if(sum==target){
	                result.add(Arrays.asList(first,second,nums[i],nums[j]));
	                while(i+1<j && nums[i]==nums[i+1]){
	                    i++;
	                    
	                }
	                while(i<j-1 && nums[j]==nums[j-1]){
	                    j--;
	                }
	                i++;
	                j--;
	            }
	        }
	        return;
	    }
	

}
