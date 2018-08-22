package careercup;

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ajdacentDuplicate("abccbdc"));
	}
	
	public static String ajdacentDuplicate(String s){
		if(s.length()==0)
			return "-1";
		int i=1,count=0;
		char c=s.charAt(0);
		while(i<s.length()){
			while(i<s.length() && c==s.charAt(i)){
				count++;
				i++;
			}
			if(count>0)
				break;
			else
				c=s.charAt(i);
			i++;
			
		}
		if(count==0)
			return s;
		else
			return ajdacentDuplicate(s.substring(0, i-(count+1))+s.substring(i));
		
		
		
	}

}
