package leetcode;

public class OneEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isOneEditDistance("",""));
	}
	
	public static boolean isOneEditDistance(String s, String t) {
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
       
        for(int i=0;i<Math.min(s.length(),t.length());i++){
            
            if(s.charAt(i)!=t.charAt(i)){
                if(s.length()==t.length()){
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                else if(s.length()>t.length()){
                    return s.substring(i+1).equals(t.substring(i));
                }
                else if(s.length()<t.length()){
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return Math.abs(s.length()-t.length())==1;
    }
}
