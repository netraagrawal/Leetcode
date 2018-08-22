package GoogleLocked;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CompressedString {
	
	static class StringIterator {
	    int ptr = 0;
	    String[] chars;int[] nums;
	    
	    public StringIterator(String compressedString) {
	        nums = Arrays.stream(compressedString.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();;
	        chars = compressedString.split("[0-9]+");
	    }
	    
	    public char next() {
	        if (!hasNext())
	            return ' ';
	        nums[ptr]--;
	        char res=chars[ptr].charAt(0);
	        if(nums[ptr]==0)
	            ptr++;
	        return res;
	    }
	    
	    public boolean hasNext() {
	        return ptr != chars.length;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringIterator cs=new StringIterator("Le1e2e1t1c1o1d1e1");
	}
	
	
	

}
