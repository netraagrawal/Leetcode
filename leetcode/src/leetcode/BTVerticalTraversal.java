package leetcode;

import java.util.*;

import javax.swing.tree.TreeNode;

public class BTVerticalTraversal {
	
	public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(12);
		root.left.right=new TreeNode(5);
		System.out.println(verticalOrder(root));

	}
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        Queue<TreeNode> que=new LinkedList<>();
        Queue<Integer> col=new LinkedList<>();
        
        que.offer(root);
        col.offer(0);
        int min=0,max=0;
        while(!que.isEmpty()){
            TreeNode node=que.poll();
            int id=col.poll();
            if(!map.containsKey(id)){
                map.put(id,new ArrayList<Integer>());
            }
            map.get(id).add(node.val);
            if(node.left!=null){
                que.offer(node.left);
                col.offer(id-1);
                min=Math.min(min,id-1);
            }
            
            if(node.right!=null){
                que.offer(node.right);
                col.offer(id+1);
                max=Math.max(max,id+1);
            }
        }
        
        for(int i=min;i<=max;i++){
            result.add(map.get(i));
        }
        return result;
    }
}
