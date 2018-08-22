package leetcode;
import java.util.*;
public class NextGreaterII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextGreaterElements(new int[]{1,2,3,2});
	}
	
	public static int[] nextGreaterElements(int[] nums) {
        if(nums.length==0)
            return new int[]{};
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        boolean[] done=new boolean[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=st.peek())
                st.pop();
            if(!st.isEmpty()){
                res[i]=st.peek();
                done[i]=true;
            }
            st.push(nums[i]);
        }
        
        for(int i=nums.length-1;i>=0;i--){
            if(!done[i]){
                while(!st.isEmpty() && nums[i]>=st.peek()){
                    st.pop();
                }
                if(!st.isEmpty()){
                    res[i]=st.peek();
                    done[i]=true;
                }
                
            }
            
        }
        return res;
    }

}
