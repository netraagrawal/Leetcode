
import java.util.*; 
public class gracenote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={2,4,5,7,8};
		System.out.println(addSum(input,20));
		
	}
	
	public static boolean addSum(int[] input,int target){
		if(input.length==0)
			return false;
		
		Set<Integer> set=new HashSet<>();
		
		for(int i=0;i<input.length;i++){
			if(set.contains(target-input[i]))
				return true;
			set.add(input[i]);
		}
		
		return false;
		
		
		
	}

}
