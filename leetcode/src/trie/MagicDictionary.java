package trie;
import java.util.*;

public class MagicDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class trie{
		boolean word;
		trie[] nodes=new trie[26];
		trie(){
			this.word=false;
		}
	}
	trie root;
	public MagicDictionary() {
	    root=new trie();
	}
	
	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
	    for(String s:dict){
	    	trie node=root;
	    	for(int i=0;i<s.length();i++){
	    		if(node.nodes[s.charAt(i)-'a']==null)
	    			node.nodes[s.charAt(i)-'a']=new trie();
	    		node=node.nodes[s.charAt(i)-'a'];
	    	}
	    	node.word=true;
	    }
	}
	
	/** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	public boolean search(String word) {
	    char[] arr=word.toCharArray();
	    for(int i=0;i<arr.length;i++){
	    	for(char c='a';c<='z';c++){
	    		char temp=arr[i];
	    		arr[i]=c;
	    		if(helper(arr))
	    			return true;
	    	}
	    }
	    return false;
	}
	
	public boolean helper(char[] arr){
		trie node=root;
		for(int i=0;i<arr.length;i++){
			if(node.nodes[arr[i]-'a']==null)
				return false;
			node=node.nodes[arr[i]-'a'];
		}
		return node.word;
	}
	
}