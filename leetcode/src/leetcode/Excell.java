package leetcode;

public class Excell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(26));
	}
	
	public static String convertToTitle(int n) {
        
		System.out.println((char)('A' + (--n % 26)));
        return n == 0 ? "" : convertToTitle(n / 26) + (char)('A' + (n % 26));
        
    }
}
