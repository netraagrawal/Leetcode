package Strings;
import java.util.*;
public class SplitInFibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(splitIntoFibonacci("1011"));
	}
	
	public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result=new ArrayList<>();
        if(S.length()<3)
            return result;
        helper(S,result,0);
        return result;
    }
    
    public static boolean helper(String S,List<Integer> res,int index){
        
        if(index==S.length() && res.size()>=3)
            return true;
        
        for(int i=index;i<S.length();i++){
            if(S.charAt(index)=='0' && i>index)
                break;
            
            Long num=Long.parseLong(S.substring(index,i+1));
            if(num>Integer.MAX_VALUE){
                break;
            }
            int size=res.size();
            if(res.size()>=2 && res.get(size-1)+res.get(size-2)<num)
                break;
            if(size<=1 || num==res.get(size-1)+res.get(size-2)){
                res.add(Integer.valueOf(num.intValue()));
                if(helper(S,res,i+1))
                    return true;
                res.remove(res.size()-1);
            }
        }
        return false;
    }

}
