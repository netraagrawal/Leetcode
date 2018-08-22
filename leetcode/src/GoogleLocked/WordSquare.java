package GoogleLocked;

import java.util.List;

public class WordSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean validWordSquare(List<String> words) {
	        
	        if(words.size()==0){
	            return true;
	        }
	        for(int i=0;i<words.size();i++){
	            String temp=words.get(i);
	            if(temp.length()>words.size())
	                    return false;
	            for(int j=0;j<temp.length();j++){
	                if(i >= words.get(j).length())
	                    return false;
	                if(temp.charAt(j)!=words.get(j).charAt(i))
	                    return false;
	            }
	        }
	        return true;
	    }

}
