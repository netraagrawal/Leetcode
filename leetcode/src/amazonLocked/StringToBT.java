package amazonLocked;

import amazonLocked.ClosestLeaf.TreeNode;
import java.util.*;
public class StringToBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public TreeNode convert(String s){
		if(s == null)
            return null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        for(int i = 0, j = i; i < s.length(); i++, j = i)
        {
            char c = s.charAt(i);
            if(c == ')')
                st.pop();
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-')
            {
                while((i + 1) < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                    i++;
                TreeNode curr = new TreeNode(Integer.parseInt(s.substring(j, i + 1)));
                if(!st.isEmpty())
                {
                    TreeNode parent = st.peek();
                    if(parent.left == null)
                        parent.left = curr;
                    else
                        parent.right = curr;
                }
                st.push(curr);
            }
        }
        return st.isEmpty() ? null : st.peek();
		
		
	}

}
