package leetcode;
import java.util.*;
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(1));
	}
	public static int reverseBits(int n) {
        if(n==0)
            return 0;
        int[] num=new int[32];
        int sum=0,pow=31;
        for(int i=0;i<32;i++){
            int val= n & 1;
            num[i]=val;
            System.out.println(num[i]);
            n=n>>1;
        	sum+= num[i]*Math.pow(2, pow);
        	System.out.println(sum+" "+Math.pow(2, pow));
        	pow--;
        }
        return sum;
    }

}
