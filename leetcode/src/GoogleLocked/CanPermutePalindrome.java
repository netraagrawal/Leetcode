package GoogleLocked;

public class CanPermutePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canPermutePalindrome("abc"));
	}
	
	public static boolean canPermutePalindrome(String s) {
        if(s==null){
            return true;
        }
        int odd=0;
        int[] ch=new int[128];
        for(int i=0;i<s.length();i++){
            ch[s.charAt(i)]++;
        }
        for(int i=0;i<ch.length;i++){
            if((ch[i]%2)!=0){
                odd++;
            }
            if(odd>1){
                return false;
            }
        }
        return true;
    }

}
