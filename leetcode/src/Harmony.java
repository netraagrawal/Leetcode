import java.util.*;
public class Harmony {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static int fact(int r1,int c1,int r2,int c2,int c,int d,List<String> maze){
		if(maze.size()==0 || r1<0 || r2<0 || c1<0 || c2<0 || r1>maze.size()-1 || r2>maze.size()-1 || c1>maze.size()-1 || c2>maze.size()-1)
			return -1;
		boolean[][] visited=new boolean[maze.size()][maze.size()];
		int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
		return helper(maze,r1,r2,c1,c2,c,d,visited,dir);
		
		
	}
	
	public static int helper(List<String> maze,int r1,int r2,int c1,int c2,int c,int d,boolean[][] visited,int[][] dir){
		if(r1<0 || r2<0 || c1<0 || c2<0 || r1>maze.size()-1 || r2>maze.size()-1 || c1>maze.size()-1 || c2>maze.size()-1 || visited[r1][c1]==true || maze.get(r1).charAt(c1)=='#')
			return 0;
		for(int[] dd:dir){
			int nr=r1+dd[0];
			int nc=c1+dd[1];
			if(nr<0 || nc<0 || nr>maze.size()-1 || nc>maze.size()-1)
				continue;
		}
		return 0;
	}

}
