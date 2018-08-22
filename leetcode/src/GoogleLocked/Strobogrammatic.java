package GoogleLocked;

public class Strobogrammatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isStrobogrammatic("101"));
	}
	
	public static boolean isStrobogrammatic(String num) {
	        
	        if(num==null){
	            return true;
	        }
	        int j=num.length()-1;
	        for(int i=0;i<=j;i++){
	            if(!("00 11 88 69 96").contains(num.charAt(i)+""+num.charAt(j))){
	                return false;
	            }
	            j--;
	        }
	        return true;
	        
	    }

}
