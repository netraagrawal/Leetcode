package Strings;

public class ExpressiveWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(expressiveWords("heeellooo", new String[]{"hello","helo"}));
	}
	
	public static int expressiveWords(String S, String[] words) {
        if(S.length()==0 || words.length==0)
            return 0;
        int ans=0;
        for(String w:words){
            if(check(S,w))
                ans++;
        }
        return ans;
    }
    
    public static boolean check(String s,String w){
        int i=0,j=0;
        if(w.length()>s.length())
            return false;
        while(i<s.length() && j<w.length()){
            int counts=1,countw=1;
            if(s.charAt(i)!=w.charAt(j))
                return false;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                i++;
                counts++;
            }
            while(j+1<w.length() && w.charAt(j)==w.charAt(j+1)){
                j++;
                countw++;
            }
            if(counts<3 && counts!=countw)
                return false;
            i++;
            j++;
        }
        return i==s.length() && j==w.length();
    }

}
