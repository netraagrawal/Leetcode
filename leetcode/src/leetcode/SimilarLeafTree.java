package leetcode;


import java.util.*;
public class SimilarLeafTree {

	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(5);
		root.right=new TreeNode(1);
		root.left.right=new TreeNode(2);
		root.left.left=new TreeNode(6);
		root.left.right.left=new TreeNode(7);
		root.left.right.right=new TreeNode(4);
		
		TreeNode root2=new TreeNode(3);
		root2.left=new TreeNode(5);
		root2.right=new TreeNode(1);
		root2.left.right=new TreeNode(2);
		root2.left.left=new TreeNode(6);
		root2.left.right.left=new TreeNode(7);
		root2.left.right.right=new TreeNode(4);
		System.out.println(leafSimilar(root,root2));
	
	}
	
	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null)
            return root2==null;
        if(root2==null)
            return root1==null;
        
        List<Integer> res1=new ArrayList<Integer>();
        helper(root1,res1);
        List<Integer> res2=new ArrayList<>();
        helper(root2,res2);
        
        return res1.equals(res2);
    }
    
    public static void helper(TreeNode root,List<Integer> res){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
            
    }

}
