package leetcode;
import java.util.*;
public class MaxDistanceArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDistance(List<List<Integer>> arrays) {
		if(arrays==null)
			return 0;
		int res=0;
		List<Integer> first=arrays.get(0);
		int max=first.get(first.size()-1);
		int min=first.get(0);
		for(int i=1;i<arrays.size();i++){
			List<Integer> temp=arrays.get(i);
			int submax=temp.get(temp.size()-1);
			int submin=temp.get(0);
            res=Math.max(res,Math.max(Math.abs(submax-min),Math.abs(max-submin)));
			max=Math.max(max, submax);
			min=Math.min(min, submin);
		}
		return res;
	
	}

}
