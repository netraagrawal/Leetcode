package leetcode;

import java.util.*;
public class ServerGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int[]> input=new ArrayList<>();
		input.add(new int[]{1,1});
		input.add(new int[]{1,2});
		List<int[]> output=calculate(5, input);
		for(int[] res:output){
			System.out.println(res[0]+" "+res[1]);
		}
		
	}
	
   static List<int[]> ans=new ArrayList<>();
   static int max=0;
   public static List<int[]> calculate(int n,List<int[]> list){
       List<int[]> ans=new ArrayList<>();
       if(list.size()==0){
           return ans;
       }
       int[][] grid=new int[n+1][n+1];
       for(int i=0;i<list.size();i++){
           int[] temp=list.get(i);
           int r=temp[0];
           int c=temp[1];
           grid[r][c]=1;
           //System.out.println(r+" "+c);
       }
       for(int i=1;i<grid.length;i++){
           for(int j=1;j<grid[0].length;j++){
               if(grid[i][j]==0){
                   int c=helper(grid,i+1,j)+helper(grid,i,j+1)+helper(grid,i+1,j+1)+helper(grid,i+1,j-1)+helper(grid,i,j-1)+helper(grid,i-1,j)+helper(grid,i-1,j+1)+helper(grid,i-1,j-1);
                   //System.out.println(c+" max:"+max);
	               if(c>max){
	            	   max=c;
	                   ans.clear();
	                   ans.add(new int[]{i,j});
	               }
	               else if(c==max){
	                   ans.add(new int[]{i,j});
	               }
              }
           }
       }
       return ans;
   }
   
   public static int helper(int[][] grid,int i,int j){
       if(i<1 || j>grid[0].length-1 || i>grid.length-1 || j<1){
           return 0;
       }
       if(grid[i][j]==1){
           return 1;
       }
       return 0;
   
   }

}
