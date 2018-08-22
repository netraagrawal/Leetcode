package leetcode;
import java.util.*;
public class SubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsetsWithDup(new int[]{1,2,3}));
	}
	
	public static List<List<Integer>> subsetsWithDup(int[] num) {
		  Arrays.sort(num);
		  List<List<Integer>> ret = new ArrayList<>();
		  ret.add(new ArrayList<Integer>());

		  int size = 0, startIndex;
		  for(int i = 0; i < num.length; i++) {
		    startIndex = (i >= 1 && num[i] == num[i - 1]) ? size : 0;
		    size = ret.size();
		    for(int j = startIndex; j < size; j++) {
		      List<Integer> temp = new ArrayList<>(ret.get(j));
		      temp.add(num[i]);
		      ret.add(temp);
		    }
		  }
		  return ret;
		}

}
