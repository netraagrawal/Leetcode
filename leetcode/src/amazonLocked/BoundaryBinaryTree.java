package amazonLocked;
import java.util.*;


public class BoundaryBinaryTree {
	
	static public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        if(!isLeaf(root))
            res.add(root.val);
        TreeNode node=root.left;
        while(node!=null){
            if(!isLeaf(node))
                res.add(node.val);
            if(node.left!=null)
                node=node.left;
            else
                node=node.right;
        }
        node=root;
        addLeaf(node,res);
        Stack<TreeNode> st=new Stack<>();
        node=root.right;
        while(node!=null){
            if(!isLeaf(node))
                st.push(node);
            if(node.right!=null)
                node=node.right;
            else
                node=node.left;
        }
        while(!st.isEmpty())
            res.add(st.pop().val);
        
        return res;
            
    }
    public boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    public void addLeaf(TreeNode root,List<Integer> list){
        if(isLeaf(root))
            list.add(root.val);
        else{
            if(root.left!=null)
                addLeaf(root.left,list);
            if(root.right!=null)
                addLeaf(root.right,list);
        }
    }

}
