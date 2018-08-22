package careercup;
import java.util.*;
public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsetSumHalf(new int[]{3,7,2,1,8,9,6}));
	}
	
	public static List<Integer> subsetSumHalf(int[] num){
		List<Integer> res=new ArrayList<>();
		if(num.length==0)
			return res;
		int sum=0;
		for(int i=0;i<num.length;i++)
			sum+=num[i];
		Arrays.sort(num);
		List<Integer> ans=new ArrayList<>();
		if((sum & 1) == 0)
			helper(num,0,0,sum/2,res);
		return res;
		
	}
	
	public static boolean helper(int[] num,int curr,int start,int target,List<Integer> res){
		
		if(curr==target){
			return true;
		}
		if(curr>target)
			return false;
		for(int i=start;i<num.length;i++){
			res.add(num[i]);
			if(helper(num,curr+num[i],i+1,target,res))
				return true;
			res.remove(res.size()-1);
		}
		return false;
	}

}
