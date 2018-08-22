package leetcode;
import java.util.*;

public class WallsNgates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void wallsAndGates(int[][] rooms) {
	        
	        if(rooms.length==0){
	            return;
	        }
	        List<int[]> traverse=Arrays.asList(
	            new int[]{1,0},new int[]{-1,0},new int[]{0,1},new int[]{0,-1}
	        );
	        int Empty=Integer.MAX_VALUE;   
	        Queue<int[]> que=new LinkedList<>();
	        for(int i=0;i<rooms.length;i++){
	            for(int j=0;j<rooms[0].length;j++){
	                if(rooms[i][j]==0){
	                    que.offer(new int[]{i,j});
	                }
	            }
	        }
	        
	        while(!que.isEmpty()){
	            int[] temp=que.poll();
	            int row=temp[0],col=temp[1];
	            for(int[] tr:traverse){
	                int r=row+tr[0];
	                int c=col+tr[1];
	                
	                if(r<0 || c<0 || r>rooms.length-1 || c>rooms[0].length-1 || rooms[r][c]!=Empty){
	                    continue;
	                }
	                
	                rooms[r][c]=rooms[row][col]+1;
	                que.offer(new int[]{r,c});
	            }
	        }
	        
	    }

}
