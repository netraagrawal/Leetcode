package GoogleLocked;

public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] input=new int[4][4];
		System.out.println(islandPerimeter(input));
	}
	
	public static int islandPerimeter(int[][] grid) {
	        
	        if(grid.length==0){
	            return 0;
	        }
	        int islands=0,neighbors=0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j]==1){
	                    islands++;
	                    if(i<grid.length-1 && grid[i+1][j]==1){
	                        neighbors++;
	                    }
	                    if(j<grid[0].length-1 && grid[i][j+1]==1){
	                        neighbors++;
	                    }
	                }
	            }
	        }
	        return (4*islands)-(2*neighbors);
	    }

}
