package leetcode;
import java.util.*;

public class CycleInNarrTree {
	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node temp4=new Node(4,null);
		Node temp5=new Node(5,null);
		Node temp6=new Node(6,null);
		Node temp7=new Node(7,null);
		Node temp2=new Node(2,new ArrayList<>(Arrays.asList(temp4,temp5,temp6)));
		Node temp3=new Node(3,new ArrayList<>(Arrays.asList(temp7)));
		Node root=new Node(1,new ArrayList<>(Arrays.asList(temp2,temp3)));
		System.out.println(hasCycle(root));
	}
	
	public static boolean hasCycle(Node root){
		if(root==null)
			return false;
		Set<Integer> set=new HashSet<>();
		set.add(root.val);
		return helper(root,set);
	}
	
	public static boolean helper(Node root,Set<Integer> set){
		if(root.children==null)
			return false;
		for(Node n:root.children){
			if(!set.add(n.val))
				return true;
			if(helper(n,set))
				return true;
		}
		return false;
	}

}
