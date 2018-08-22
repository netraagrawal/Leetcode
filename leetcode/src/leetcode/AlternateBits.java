package leetcode;

public class AlternateBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hasAlternatingBits(7));
	}
	
	public static boolean hasAlternatingBits(int n) {
        if(n==0)
            return true;
        int prev=-1;
        while(n!=0){
            int curr = n & 1;
            if(curr==prev)
                return false;
            prev=curr;
            n=n>>1;
        }
        return true;
    }

}
