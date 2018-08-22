/*
Longest Substring Without Repeating Characters
QUESTION
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/*CODE*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
         if(s==null || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int max=0;
        LinkedList<Character> hs=new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!hs.contains(c)){
                hs.add(c);
            }
            else{
                max=Math.max(max, hs.size());
                while(hs.contains(c)){
                    hs.removeFirst();
                }
                hs.add(c);
            }
        }
        max=Math.max(max, hs.size());
    return max;
    }
}