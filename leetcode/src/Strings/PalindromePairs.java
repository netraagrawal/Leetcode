package Strings;
import java.util.*;
public class PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input={"lls","s","sssll"};
		System.out.println(palindromePairs(input));

	}
	public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result=new ArrayList<>();
        if(words.length==0)
            return result;
        
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
            map.put(words[i],i);
        
        if(map.containsKey("")){
            int ind=map.get("");
            for(int i=0;i<words.length;i++){
            	if(i==ind) continue;
                if(isPalindrome(words[i])){
                    int index=map.get(words[i]);
                    result.add(new ArrayList<>(Arrays.asList(index,ind)));
                    result.add(new ArrayList<>(Arrays.asList(ind,index)));
                }
            }
        }
        for(int i=0;i<words.length;i++){
            String rev=reverse(words[i]);
            if(map.containsKey(rev))
            	if(map.get(rev)!=map.get(words[i]))
            		result.add(new ArrayList<>(Arrays.asList(map.get(rev),map.get(words[i]))));
            for(int j=1;j<words[i].length();j++){
                String sub=words[i].substring(0,j);
                String other=words[i].substring(j);
                if(isPalindrome(sub)){
                	String r=reverse(words[i].substring(j));
                    if(map.containsKey(r)){
                    	if(map.get(words[i])==map.get(words[i].substring(j))) continue;
                    	result.add(new ArrayList<>(Arrays.asList(map.get(words[i]),map.get(r))));
                    }
                        
                }
                if(isPalindrome(other)){
                	String r=reverse(words[i].substring(0,j));
                    if(map.containsKey(r)){
                    	if(map.get(words[i])==map.get(words[i].substring(0,j))) continue;
                    	result.add(new ArrayList<>(Arrays.asList(map.get(words[i]),map.get(r))));
                    }    
                }
            }
        }
        
        return result;
        
    }
    
    public static String reverse(String temp){
        char[] t=temp.toCharArray();
        int i=0,j=temp.length()-1;
        while(i<j){
            char a=t[i];
            t[i]=t[j];
            t[j]=a;
            i++;
            j--;
        }
        return String.valueOf(t);
    }
    
    public static  boolean isPalindrome(String s){
        char[] t=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
