package careercup;
import java.util.*;
public class MaxSubArray1s0s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubwithEqualCount(int[] in){
		
		Map<Integer,Integer> map=new HashMap<>();
		int max=0;
		int sum=0;
		for(int i=0;i<in.length;i++){
			sum+=(in[i]==0)?-1:1;
			if(sum==0)
				max=i+1;
			if(map.containsKey(sum))
				max=Math.max(max,i-map.get(sum));
			else
				map.put(sum, i);
		}
		
		return max;
	}

}
