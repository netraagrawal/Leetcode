package Strings;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs={"flow","flower","flaw"};
		System.out.println(longestCommonPrefix(strs));
	}
	public static String longestCommonPrefix(String[] strs) {
	        
	        if(strs.length==0){
	            return "";
	        }
	        
	        String prefix=strs[0];
	        int i=1;
	        while(i<strs.length){
	            while(strs[i].indexOf(prefix)!=0){
	                System.out.println(strs[i].indexOf(prefix)+" "+prefix);
	                prefix=prefix.substring(0,prefix.length()-1);
	            }
	            i++;
	        }
	        return prefix;
	        
	    }

}
