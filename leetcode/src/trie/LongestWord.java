package trie;

public class LongestWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestWord(new String[]{"a","ab","abc","abcde"});
	}
	
	public static String longestWord(String[] words) {
        TrieNode root = new TrieNode ();
        root.word = "-";
        for (String word : words)
            root.insert (word);
        return dfs (root, "");
    }

    static String dfs (TrieNode node, String accum) {
        if (node == null || node.word.length () == 0)
            return accum;
        String res = "";
        if (!node.word.equals ("-"))
            accum = node.word;
        for (TrieNode child : node.links) {
            String curRes = dfs (child, accum);
            if (curRes.length () > res.length () || (curRes.length () == res.length () && curRes.compareTo (res) < 0))
                res = curRes;
        }
        return res;
    }

    /* Hand write this class every time you need to so you can remember well */
    static class TrieNode {
        String word = "";
        TrieNode[] links = new TrieNode[26];

        void insert (String s) {
            char[] chs = s.toCharArray ();
            TrieNode curNode = this;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (curNode.links[index] == null)
                    curNode.links[index] = new TrieNode ();
                curNode = curNode.links[index];
            }
            curNode.word = s;
        }
    }

}
