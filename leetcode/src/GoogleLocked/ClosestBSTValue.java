package GoogleLocked;

public class ClosestBSTValue {
	
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int closestValue(TreeNode root, double target) {
	        
	        if(root==null){
	            return 0;
	        }
	        int first=root.val;
	        root=(first>target)? root.left : root.right;
	        while(root!=null){
	            int second=root.val;
	            first= Math.abs(target-first)>Math.abs(target-second)? second: first;
	            root=second>target? root.left : root.right;
	            if(root==null){
	                return first;
	            }
	        }
	        return first;
	    }

}
