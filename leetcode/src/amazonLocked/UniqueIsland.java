package amazonLocked;
import java.util.*;
public class UniqueIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid={{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}};
		System.out.println(numDistinctIslands(grid));
	}
	
	public static int numDistinctIslands(int[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        int res=0;
        Set<String> set=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder sb=new StringBuilder();
                    calculate(grid,i,j,"o",sb);
                    set.add(sb.toString());
                }
                    
            }
        }
        return set.size();
    }
    
    public static void calculate(int[][] grid,int i,int j,String sub,StringBuilder sb){
        
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]==0)
            return;
        
        grid[i][j]=0;
        sb.append(sub);
        calculate(grid,i+1,j,"d",sb);
        calculate(grid,i-1,j,"u",sb);
        calculate(grid,i,j-1,"l",sb);
        calculate(grid,i,j+1,"r",sb);
        
        
    }

}
