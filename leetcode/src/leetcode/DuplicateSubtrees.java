package leetcode;

import java.util.*;

public class DuplicateSubtrees {
	static int t;
    static Map<String, Integer> trees;
    static Map<Integer, Integer> count;
    static List<TreeNode> ans;
    
    public static class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
    
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node=new TreeNode(4);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		node.left.left=new TreeNode(1);
		node.left.right=new TreeNode(2);
		node.left.right.left=new TreeNode(1);
		List<TreeNode> result=findDuplicateSubtrees(node);
		
	}
	
	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public static int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
        	System.out.println(node.val);
            ans.add(node);
        return uid;
    }

}
