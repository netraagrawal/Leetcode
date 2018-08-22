package leetcode;

public class ValidSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerfectSquare(2147483647));
	}
	
	public static boolean isPerfectSquare(int num) {
        if(num==0){
           return false;
       }
       for(int i=0;i<num/2;i++){
           if(i*i==num){
               return true;
           }
           if(i*i>num){
               return false;
           }
       }
       return true;
   }

}
