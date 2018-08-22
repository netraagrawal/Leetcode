package Strings;

import java.util.HashSet;
import java.util.*;

public class SubstringFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(check("SOMECORESAREINDEPENDENT", "SECRET"));

	}
	
	public static boolean check(String first,String second){
		if(first==null || second==null){
			return false;
		}
		Map<Character,List<Integer>> map=new HashMap<>();
		Set<Character> set=new HashSet<>();
		for(int i=0;i<second.length();i++){
			if(!map.containsKey(second.charAt(i))){
				map.put(second.charAt(i), new ArrayList<>());
			}
			map.get(second.charAt(i)).add(i+1);
			
			set.add(second.charAt(i));
		}
		int count=0;
		boolean temp=false;
		for(int i=0;i<first.length();i++){
			if(set.contains(first.charAt(i))){
				count++;
				List<Integer> l=map.get(first.charAt(i));
				for(Integer num:l){
					if(num==count){
						temp=true;
					}
				}
				if(temp==false){
					return false;
				}
				else{
					temp=false;
				}
			}
		}
		
		return true;
	}

}
