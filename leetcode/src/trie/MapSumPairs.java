package trie;
import java.util.*;
public class MapSumPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	class MapSum {

	    /** Initialize your data structure here. */
	    class Trie{
	        String word;
	        Trie[] nodes=new Trie[26];
	        Trie(){
	            word="";
	        }
	    }
	    
	    public void add(Trie root,String w){
	        Trie node=root;
	        for(int i=0;i<w.length();i++){
	            if(node.nodes[w.charAt(i)-'a']==null)
	                node.nodes[w.charAt(i)-'a']=new Trie();
	            node=node.nodes[w.charAt(i)-'a'];
	        }
	        node.word=w;
	    }
	    
	    
	    Map<String,Integer> map;
	    Trie root;
	    public MapSum() {
	        map=new HashMap<>();
	        root=new Trie();
	    }
	    
	    public void insert(String key, int val) {
	        if(!map.containsKey(key))
	            add(root,key);
	        map.put(key,val);
	    }
	    
	    public int sum(String prefix) {
	        Trie node=root;
	        int sum=0;
	        for(int i=0;i<prefix.length();i++){
	            if(node.nodes[prefix.charAt(i)-'a']==null)
	                break;
	            node=node.nodes[prefix.charAt(i)-'a'];
	        }
	        if(node.word.length()>0)
	            sum+=map.get(node.word);
	        for(Trie child:node.nodes){
	            sum+=helper(child);
	        }
	        return sum;
	    }
	    
	    public int helper(Trie node){
	        if(node==null)
	            return 0;
	        int sum=0;
	        if(node.word.length()>0)
	            sum+=map.get(node.word);
	        for(Trie child:node.nodes){
	            sum+=helper(child);
	        }
	        return sum;
	    }
	}


}
