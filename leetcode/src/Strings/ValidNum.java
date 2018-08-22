package Strings;

public class ValidNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isNumber("100.e+10");
	}
	public static boolean isNumber(String s) {
	        
	        s=s.trim();
	        boolean eseen=false,point=false,num=false,nume=false;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='-' || s.charAt(i)=='+'){
	            if(i!=0 && s.charAt(i-1)!='e')
	                return false;
	        }
	        else if(s.charAt(i)=='.'){
	            if(eseen || point)
	                return false;
	            point=true;
	        }
	        else if(s.charAt(i)=='e'){
	            if(eseen || !num)
	                return false;
	            eseen=true;
	            nume=false;
	        }
	        else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
	            num=true;
	            nume=true;
	        }
	        else
	            return false;
	    }
	    return num && nume;
	}

}
