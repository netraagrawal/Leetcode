package Strings;

public class MultiplyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiply("123", "456");
	}
	public static String multiply(String num1, String num2) {
	        
	        if(num1==null || num2==null){
	            return "0";
	    }
	    int n=num1.length(),m=num2.length();
	    int[] result=new int[n+m];
	    
	    for(int i=n-1;i>=0;i--){
	        for(int j=m-1;j>=0;j--){
	            int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
	            int curr=i+j,next=i+j+1;
	            int sum=mul+result[next];
	            result[curr]+=sum/10;
	            result[next]=sum%10;
	        }
	    }
	    StringBuilder sb=new StringBuilder();
	    for(int val:result){
	        if(!(sb.length()==0 && val==0)){
	            sb.append(val);
	        }
	    }
	    return sb.length()==0?"0":sb.toString();
	    }
	
	}
