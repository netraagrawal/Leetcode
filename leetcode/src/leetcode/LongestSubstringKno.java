package leetcode;

public class LongestSubstringKno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubstring("cababababdabab",2));
	}

    static int result = 0;
    //store chars as int
    static int[] chars;
    public static int longestSubstring(String s, int k) {
        int len = s.length();
				
        // early quit
        if (k > len) {
            return 0;
        }
        if (k < 2) {
            return len; 
        }
        
        chars = new int[len];
        for (int i = 0; i < len; i++) {
            chars[i] = s.charAt(i)-'a';
        }
				
        helper(0, len-1, k);
        return result;
    }
    
    public static void helper(int left, int right, int k) {
        // early quit
        if (right-left+1 < k || right-left+1< result) {
            return;
        }
        int[] counts = new int[26];
        int max = 0;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, ++counts[chars[i]]);
        }
				
        // early quit
        if (max < k) {
            return;
        }
				
        boolean match = true;
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0 && counts[i] < k) {
                match = false;
                break;
            }
        }
        if (match) {
            // new max
            result = right-left+1;
            return;
        }
				
        int l = left;
        for (int i = left; i <= right; i++) {
            if (counts[chars[i]] < k) {
                // split at i
                helper(l,i-1,k);
                l = i+1;
            }
        }
        // don't forget end with right
        if (counts[chars[right]] >= k) {
            helper(l,right,k);
        }
    }

}
