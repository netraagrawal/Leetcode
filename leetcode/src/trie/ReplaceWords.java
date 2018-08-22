package trie;
import java.util.*;
public class ReplaceWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> in=new ArrayList<>(Arrays.asList("cat","bat","rat"));
		replaceWords(in, "the cattle was rattled by battery");
	}
	
	public static String replaceWords(List<String> dict, String sentence) {
        if(dict.size()==0)
            return sentence;
        Trie root=new Trie();
        for(int i=0;i<dict.size();i++){
            add(root,dict.get(i));
        }
        StringBuilder res=new StringBuilder();
        for(String sub: sentence.split("\\s+")){
            Trie node=root;
            for(int i=0;i<sub.length();i++){
                if(node.nodes[sub.charAt(i)-'a']==null || node.word.length()>0 )
                    break;
                node=node.nodes[sub.charAt(i)-'a'];
            }
            if(res.length()>0)
                res.append(" ");
            res.append(node.word!=null?node.word:sub);
        }
        return res.toString();
        
    }
    
    static class Trie{
        String word;
        Trie[] nodes=new Trie[26];
        Trie(){
            word="";
        }
    }
    
    public static void add(Trie root,String word){
        Trie node=root;
        for(int i=0;i<word.length();i++){
            if(node.nodes[word.charAt(i)-'a']==null)
                node.nodes[word.charAt(i)-'a']=new Trie();
            node=node.nodes[word.charAt(i)-'a'];
        }
        node.word=word;
    }

}
