package leetcode;
import java.util.*;
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
	 
	public class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordDict1) {
	        LinkedList<WordNode> queue = new LinkedList<WordNode>();
	        Set<String> wordDict = new HashSet<String>();
	        for(int i = 0; i < wordDict1.size(); i++)
	            wordDict.add(wordDict1.get(i));
	        queue.add(new WordNode(beginWord, 1));
	 
	        //wordDict.add(endWord);
	 
	        while(!queue.isEmpty()){
	            WordNode top = queue.remove();
	            String word = top.word;
	 
	            if(word.equals(endWord)){
	                return top.numSteps;
	            }
	 
	            char[] arr = word.toCharArray();
	            for(int i=0; i<arr.length; i++){
	                for(char c='a'; c<='z'; c++){
	                    char temp = arr[i];
	                    if(arr[i]!=c){
	                        arr[i]=c;
	                    }
	 
	                    String newWord = new String(arr);
	                    if(wordDict.contains(newWord)){
	                        queue.add(new WordNode(newWord, top.numSteps+1));
	                        wordDict.remove(newWord);
	                    }
	 
	                    arr[i]=temp;
	                }
	            }
	        }
	 
	        return 0;
	    }
	}

}
