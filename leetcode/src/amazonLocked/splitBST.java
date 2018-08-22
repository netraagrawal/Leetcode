package amazonLocked;

public class splitBST {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode[] splitBST(TreeNode root, int V) {
	        
	        if(root==null)
	            return new TreeNode[]{null,null};
	        if(root.val==V){
	            TreeNode split=root.right;
	            root.right=null;
	            return new TreeNode[]{root,split};
	        }
	        TreeNode[] result=new TreeNode[2];
	        if(root.val<V){
	            result=splitBST(root.right,V);
	            root.right=result[0];
	            result[0]=root;
	        }
	        else{
	            result=splitBST(root.left,V);
	            root.left=result[1];
	            result[1]=root;
	        }
	        return result;
	    }
	
	}
