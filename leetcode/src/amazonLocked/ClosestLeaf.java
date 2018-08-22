package amazonLocked;
import java.util.*;

public class ClosestLeaf {
	static public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.left.left=new TreeNode(5);
		root.left.left.left.left=new TreeNode(6);
		System.out.println(findClosestLeaf(root, 2));
	}
	
	public static int findClosestLeaf(TreeNode root, int k) {
        if(root==null)
            return 0;
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        dfs(parent,root,null);
        Queue<TreeNode> que=new LinkedList<>();
        Set<TreeNode> set=new HashSet<>();
        TreeNode start=new TreeNode(0);
        for(TreeNode node:parent.keySet()){
            if(node!=null && node.val==k){
                start=node;
                set.add(node);
                que.offer(node);
            }
        }
        
        if(start.left==null && start.right==null)
            return start.val;
        while(!que.isEmpty()){
            TreeNode temp=que.poll();
            if(temp!=null){
                if(temp.left==null && temp.right==null)
                    return temp.val;
                if(!set.contains(temp.left)){
                    set.add(temp.left);
                    que.offer(temp.left);
                }
                if(!set.contains(temp.right)){
                    set.add(temp.right);
                    que.offer(temp.right);
                }
                if(!set.contains(parent.get(temp)) && parent.get(temp)!=null){
                    set.add(parent.get(temp));
                    que.offer(parent.get(temp));
                }
            }
            
        }
        return start.val;
    }
    
    public static void dfs(Map<TreeNode,TreeNode> map,TreeNode root,TreeNode parent){
        if(root!=null){
            map.put(root,parent);
            dfs(map,root.left,root);
            dfs(map,root.right,root);
        }
    }

}
