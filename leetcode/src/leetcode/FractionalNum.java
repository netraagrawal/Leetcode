package leetcode;
import java.util.*;


public class FractionalNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(-1,
				-2147483648));
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator==0){
            return "0"; 
        }
        if(denominator==0){
            return "division by 0";
        }
        StringBuilder sb=new StringBuilder();
        if(numerator<0 ^ denominator<0){
            sb.append("-");
        }
        long num=Math.abs(numerator);
        long den=Math.abs(denominator);
        
        sb.append(num/den);
        long remain=num%den;
        if(remain==0){
            return sb.toString();
        }
        sb.append('.');
        Map<Long,Integer> map=new HashMap<>();
        while(remain!=0){
            if(!map.containsKey(remain)){
                map.put(remain,sb.length());
                remain=remain*10;
                sb.append(remain/den);
                remain=remain%den;
            }else{
                sb.insert(map.get(remain),"(");
                sb.append(")");
                return sb.toString();
            }
            
        }
        return sb.toString();
        
    }

}
