package GoogleLocked;

import java.util.*;

public class FlipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static List<String> generatePossibleNextMoves(String s) {
	        
	        List<String> result=new ArrayList<>();
	        if(s==null){
	            return result;
	        }
	        
	        for(int i=0;i<s.length()-1;i++){
	            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
	                result.add(s.substring(0,i)+"--"+s.substring(i+2));
	            }
	        }
	        return result;
	    }

}
