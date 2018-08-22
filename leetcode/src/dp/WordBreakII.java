package dp;
import java.util.*;
public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> input=new HashSet<>(Arrays.asList("cat","cats","sand","and","dog"));
		wordBreak("catsanddog", input);
	}
	
	public static List<String> wordBreak(String s, Set<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    static HashMap<Integer, List<String>> map = new HashMap<>();

    public static List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

}
