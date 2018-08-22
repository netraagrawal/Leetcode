package Strings;

public class ShiftingLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shiftingLetters("amz",new int[]{10,20,8}));
	}
	public static String shiftingLetters(String S, int[] shifts) {
        if(S.length()==0 || shifts.length==0)
            return S;
        for(int i=shifts.length-2;i>=0;i--){
            shifts[i]=(shifts[i]+shifts[i+1]);
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S.length();i++){
            sb.append((char)((S.charAt(i)-'a'+shifts[i])%26 + 'a'));
        }
        return sb.toString();
    }

}
