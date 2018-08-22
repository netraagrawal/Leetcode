package Strings;
import java.util.*;
public class Allanagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findAnagrams("cababa", "abb");
	}
	public static List<Integer> findAnagrams(String s, String p) {

	    char[] ptrn = p.toCharArray();
	    char[] str = s.toCharArray();
	    
	    int[] w = new int[26];
	    
	    for(char c : ptrn) w[c - 'a']++;
	    
	    int start = 0;
	            
	    List<Integer> result = new LinkedList<>();
	    
	    for(int i = 0; i<str.length; i++){
	        int cIndex = str[i] - 'a';

	        w[cIndex]--;
	        // the crucial bit, if we have seen the character too many times 
	        // or it is a character that is not in the pattern, rewind the starting index
	        while(w[cIndex] < 0){
	            w[str[start] - 'a']++;
	            start++;
	        }
	        
	        if(i - start + 1 == ptrn.length){
	            result.add(start);
	            w[str[start] - 'a']++;
	            start++;
	        }
	    }
	    

	    return result;
	}        

}
