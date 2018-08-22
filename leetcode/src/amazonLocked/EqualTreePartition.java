package amazonLocked;

public class EqualTreePartition {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	boolean flag;
    public boolean checkEqualTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return false;
        long total=count(root);
        if(total%2!=0)
            return false;
        checkTree(root,total);
        return flag;
    }
    
    public long count(TreeNode root){
        if(root==null)
            return 0;
        return count(root.left)+count(root.right)+root.val;
    }
    
    public long checkTree(TreeNode root,long total){
        if(root==null || flag)
            return 0;
        long curleft=checkTree(root.left,total);
        long curRight=checkTree(root.right,total);
        if((root.left!=null && curleft==total/2) || (root.right!=null && curRight==total/2)){
            flag=true;
            return 0;
        }
        return root.val+curRight+curleft;
    }

}
