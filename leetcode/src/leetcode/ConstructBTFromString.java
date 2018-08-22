package leetcode;
import java.util.*;


public class ConstructBTFromString {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.floorMod(-97, 1440));
	}
	public TreeNode str2tree(String s) {
        if(s==null){
            return null;
        }
        Stack<TreeNode> st=new Stack<>();
        
        for(int i=0,j=i;i<s.length();i++,j=i){
            if(s.charAt(i)==')'){
                st.pop();
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9' || s.charAt(i)=='-'){
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    i++;
                }
                TreeNode temp=new TreeNode(Integer.valueOf(s.substring(j,i+1)));
                if(!st.isEmpty()){
                    TreeNode p=st.peek();
                    if(p.left!=null){
                        p.right=temp;
                    }
                    else{
                        p.left=temp;
                    }
                }
                st.push(temp);
            }
        }
        return st.isEmpty()?null: st.peek();
    }

}
