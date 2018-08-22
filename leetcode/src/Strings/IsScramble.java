package Strings;
import java.util.*;
public class IsScramble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isScramble("great","rgtae");
	}
	static class CharCountMap extends HashMap<Character, int[]> {
		public void addChars(char c, boolean add) {
			int[] i = get(c);
			if(i == null) {
				i = new int[1];
				put(c, i);
			}
			i[0] += add ? +1 : -1;
			if(i[0] == 0)
				remove(c);
		}
	}
	
	private static CharCountMap charCountMap;

	public static boolean isScramble(String s1, String s2) {
		charCountMap = new CharCountMap();
		if(s1.length() != s2.length())
			return false;
		
		for(char c : s1.toCharArray())
			charCountMap.addChars(c, true);
		for(char c : s2.toCharArray())
			charCountMap.addChars(c, false);
		if(!charCountMap.isEmpty())
			return false;
		
		return isScramble(s1, 0, s2, 0, s2.length());
	}
	
	private static boolean isScramble(String s1, int p1, String s2, int p2, int length) {
		if(s1.substring(p1, p1 + length).equals(s2.substring(p2, p2 + length)))
			return true;
		
		for(int i=1; i<length; i++){  //Partition
			charCountMap.addChars(s1.charAt(p1 + i - 1), true);
			charCountMap.addChars(s2.charAt(p2 + i - 1), false);
			if(charCountMap.isEmpty())
				if(isScramble(s1, p1, s2, p2, i) && isScramble(s1, p1 + i, s2, p2 + i, length - i))
					return true;
		}
		charCountMap.clear();
		for(int i=1; i<length; i++){  //Partition
			charCountMap.addChars(s1.charAt(p1 + i - 1), true);
			charCountMap.addChars(s2.charAt(p2 + length - i), false);
			if(charCountMap.isEmpty())
				if(isScramble(s1, p1, s2, p2 + length - i, i) && isScramble(s1, p1 + i, s2, p2, length - i))
					return true;
		}

		return false;
	}

}
