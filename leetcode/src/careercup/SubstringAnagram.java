package careercup;

public class SubstringAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(substringAnagram("slate", "tea"));
	}
	
	public static String substringAnagram(String s,String p){
		if(s==null || p==null)
			return null;
		
		int[] val=new int[26];
		for(int i=0;i<p.length();i++){
			val[p.charAt(i)-'a']++;
		}
		String res="";
		int i=0,start=0;
		while(i<s.length()){
			val[s.charAt(i)-'a']--;
			while(val[s.charAt(i)-'a']<0){
				val[s.charAt(start)-'a']++;
				start++;
			}
			if(p.length()==i-start+1){
				res=s.substring(start, start+p.length());
				break;
			}
			i++;
		}
		return res;
	}

}
