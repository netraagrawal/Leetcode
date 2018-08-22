package leetcode;

import java.util.HashMap;

import leetcode.BTVerticalTraversal.TreeNode;

	public class PathSumIII {
	
		public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(1);
		root.right=new TreeNode(6);
		root.left.right=new TreeNode(2);
		root.right.right=new TreeNode(8);
		root.right.left=new TreeNode(-3);
		root.right.left.left=new TreeNode(4);
		System.out.println(pathSum(root,3));
	
	}
	static int count=0;
    static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public static int pathSum(TreeNode root, int sum) {
        map.put(0,1);
        helper(root,sum,0);
       return count;
    }
    
    public static void helper(TreeNode root,int sum,int current){
        if(root==null){
            return;
        }
        current=current+root.val;
        if(map.containsKey(current-sum)){
            count=count+map.get(current-sum);
        }
        if(!map.containsKey(current)){
            map.put(current,1);
        }
        else{
            map.put(current,map.get(current)+1);
        }
        helper(root.left,sum,current);
        helper(root.right,sum,current);
        map.put(current,map.get(current)-1);
        
    }

}
