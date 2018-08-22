package leetcode;
import java.util.*;
public class GenerateParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(3);
	}
	
	public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        if(n==0){
            result.add("");
            return result;
        }
        helper(result,"",0,0,n);
        return result;
        
    }
    
    public static void helper(List<String> result,String str,int start,int end,int n){
        
        if(str.length()==n*2){
            result.add(str);
            return;
        }
        
        if(start<n){
            helper(result,str+"(",start+1,end,n);
        }
        if(end<start){
            helper(result,str+")",start,end+1,n);
        }
    }

}
