package Strings;

public class StringreverseII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] split=("netra  agrawal").split(" ");
		for(String ans:split){
			System.out.println(ans+" len:"+ans.length());
		}
		
		//System.out.println(reverseStr("abcdefg",2));
	}
	
	public static String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

}
