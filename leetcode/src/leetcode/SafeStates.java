package leetcode;
import java.util.*;
public class SafeStates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{},{0,2,3,4},{3},{4},{}};
		System.out.println(eventualSafeNodes(input));
	}
	public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        if(graph.length==0)
            return result;
        int color[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(helper(i,graph,color))
                result.add(i);
        }
        return result;
    }
    
    public static boolean helper(int cur,int[][] graph,int[] color){
        if(color[cur]>0)
            return color[cur]==2;
        color[cur]=1;
        for(int n:graph[cur]){
            if(color[n]==2)
                continue;
            if(color[n]==1 || !helper(n,graph,color))
                return false;
        }
        color[cur]=2;
        return true;
    }

}
