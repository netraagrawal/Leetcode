package leetcode;

public class DivideIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, 2));
	}
	
	public static int divide(int dividend, int divisor) {
        
        if(divisor==0 || dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(divisor==1){
            return dividend;
        }
        if(divisor==dividend){
            return 1;
        }
        
        if(divisor==Integer.MIN_VALUE){
            return 0;
        }
        
        char sign=' ';
        if(divisor<0 ^ dividend<0){
            sign='-';
        }
        
        int num= dividend==Integer.MIN_VALUE ? Integer.MAX_VALUE: Math.abs(dividend);
        int den=Math.abs(divisor);
        
        if(num<den){
            return 0;
        }
        int count=helper(num,den);
        
        return sign=='-'? -count : count;
    }
    
    
    public static int helper(int num,int den){
        if(num<den){
            return 0;
        }
        
        int count=1;
        int temp=den;
        while(temp+temp<=num && temp!=Integer.MIN_VALUE){
            count=count+count;
            temp=temp+temp;
        }
        
        return count + helper(num-temp,den);
    }

}
