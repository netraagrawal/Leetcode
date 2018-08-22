package Strings;

public class RepeatedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedSubstringPattern("abcbaabdbaabcba"));
	}
	
	public static boolean repeatedSubstringPattern(String s) {
	        
	        if(s==null){
	            return true;
	        }
	        
	        for(int i=s.length()/2;i>=1;i--){
	            if(s.length()%i==0){
	                int j=i;
	                String sub=s.substring(0,j);
	                while(s.indexOf(sub,j)==j){
	                    j+=i;
	                }
	                if(j==s.length()){
	                    return true;
	                }
	            }
	        }
	        return false;
	        
	    }

}
