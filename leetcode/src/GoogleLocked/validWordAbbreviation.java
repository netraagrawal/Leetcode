package GoogleLocked;

public class validWordAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validWordAbbreviation("internationalization", "inter8izaton"));
	}
	
	public static boolean validWordAbbreviation(String word, String abbr) {
	        
	        if(abbr.length()==0 || word.length()==0){
	            return true;
	        }
	        if(abbr.length()>word.length()){
	            return false;
	        }
	        
	        int i=0,j=0;
	        while(i<word.length() && j<abbr.length()){
	            if(word.charAt(i)==abbr.charAt(j)){
	                i++;
	                j++;
	                continue;
	            }
	            if(abbr.charAt(j)<='0'){
	                return false;
	            }
	            if(Character.isDigit(abbr.charAt(j))){
	                int start=j;
	                
	                while(j<abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9'){
	                    j++;
	                }
	                int num=Integer.valueOf(abbr.substring(start,j));
	                i+=num;
	                continue;
	            }
	            if(word.charAt(i)!=abbr.charAt(j)){
	                return false;
	            }
	        }
	        return i==word.length() && j==abbr.length();
	    }

}
