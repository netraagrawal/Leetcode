package leetcode;
import java.util.*;
public class LoudAndRich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{0,1},{1,2}};
		int[] q={1,0,2};
		System.out.println(loudAndRich(input, q));
	}
	
	public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] res=new int[quiet.length];
        List<Integer>[] list=new List[quiet.length];
        for(int i=0;i<quiet.length;i++)
            list[i]=new ArrayList<>();
        for(int[] rich:richer)
            list[rich[1]].add(rich[0]);
        
        for(int i=0;i<quiet.length;i++){
            if(list[i].size()==0)
                res[i]=i;
            else
                res[i]=helper(quiet,list,i);
        }
        return res;
        
    }
    
    public static int helper(int[] quiet,List<Integer>[] list,int index){
        Queue<Integer> que=new LinkedList<>();
        int res=index;
        
        que.offer(index);
        while(!que.isEmpty()){
            int t=que.poll();
            if(quiet[t]<quiet[index]){
                res=t;
            }
            if(list[t]!=null){
                List<Integer> s=list[t];
                for(int j=0;j<s.size();j++)
                    que.offer(s.get(j));
            }
        }
        return res;
    }

}
