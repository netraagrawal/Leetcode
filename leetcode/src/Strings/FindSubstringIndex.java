package Strings;
import java.util.*;
public class FindSubstringIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
		}
	
	public static List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> need = new HashMap<>();
        for (final String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }
        final int n = s.length();
        final int num = words.length;
        final int len = words[0].length();
        final List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int l = i, count = 0;
            final Map<String, Integer> seen = new HashMap<>();
            for (int j = i; j <= n - len; j += len) {
                final String word = s.substring(j, j + len);
                if (need.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) <= need.get(word)) {
                        count++;
                    } else {
                        while (seen.get(word) > need.get(word)) {
                            final String first = s.substring(l, l += len);
                            seen.put(first, seen.getOrDefault(first, 0) - 1);
                            if (seen.get(first) < need.getOrDefault(first, 0)) {
                                count--;
                            }
                        }
                    }
                    if (count == num) {
                        ans.add(l);
                        count--;
                        final String first = s.substring(l, l += len);
                        seen.put(first, seen.get(first) - 1);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    l = j + len;
                }
            }
        }
        return ans;
    }

	
/*	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if(words.length==0)
            return result;
        int wordlen=words[0].length();
        int wordnum=words.length;
        int n=s.length();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        
        for(int i=0;i<wordlen;i++){
            int start=i,count=0;
            HashMap<String,Integer> seen=new HashMap<>();
            for(int j=0;j<n-wordlen;j+=wordlen){
                String sub=s.substring(j,j+wordlen);
                if(map.containsKey(sub)){
                    seen.put(sub,seen.getOrDefault(sub,0)+1);
                    if(seen.get(sub)<=map.get(sub))
                        count++;
                    else{
                        while(seen.get(sub)>map.get(sub)){
                            String temp=s.substring(start,start+wordlen);
                            start=start+wordlen;
                            seen.put(temp,seen.get(temp)-1);
                            
                        }
                    }
                    if(count==wordnum){
                        result.add(start);
                        count--;
                        String temp=s.substring(start,start+wordlen);
                        start=start+wordlen;
                        seen.put(temp,seen.get(temp)-1);
                    }
                }
                else{
                    count=0;
                    seen.clear();
                    start=j+wordlen;
                }
                    
            }
        }
        return result;
    }*/
}
