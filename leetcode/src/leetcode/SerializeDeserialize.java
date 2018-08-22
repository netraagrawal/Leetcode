package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.BTVerticalTraversal.TreeNode;

public class SerializeDeserialize {
	
	
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
		System.out.println(serialize(root));
		System.out.println(deSerialize("3,9,12,X,5,X,X,X,X"));
	}
	
	public static String serialize(TreeNode root){
		
		if(root==null){
			return null;
		}
		String forN="X";
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root);
		StringBuilder sb=new StringBuilder();
		sb.append(root.val+",");
		while(!que.isEmpty()){
			System.out.println(sb.toString());
			TreeNode temp=que.poll();
			if(temp!=null && temp.left==null){
				sb.append(forN+",");
				
			}
			else if(temp.left!=null){
				System.out.println("val"+temp.left.val);
				que.offer(temp.left);
				sb.append(temp.left.val+",");
				System.out.println("left"+sb.toString());
			}
			if(temp!=null && temp.right==null){
				sb.append(forN+",");
				
			}
			else if(temp.right!=null){
				que.offer(temp.right);
				sb.append(temp.right.val+",");
			}
		}
		return sb.deleteCharAt(sb.length()-1).toString();
		
	}
	
	public static TreeNode deSerialize(String s){
		if(s==null){
			return null;
		}
		String[] st=s.split(",");
		String forN="X";
		TreeNode root=new TreeNode(Integer.valueOf(s.charAt(0)));
		Queue<TreeNode> que=new LinkedList<>();
		que.offer(root);
		int j=1;
		while(!que.isEmpty()){
			int size=que.size();
			for(int i=0;i<size;i++){
				TreeNode temp=que.poll();
				if(!st[j].equals(forN)){
					temp.left=new TreeNode(Integer.valueOf(st[j]));
					que.offer(temp.left);
				}
				j++;
				if(!st[j].equals(forN)){
					temp.right=new TreeNode(Integer.valueOf(st[j]));
					que.offer(temp.right);
				}
				j++;
			}
			
		}
		
		return root;
	}
}
