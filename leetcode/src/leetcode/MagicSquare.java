package leetcode;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid={{4,3,8,4},{9,5,1,9},{2,7,6,2}};
		System.out.println(numMagicSquaresInside(grid));
	}
	
	public static int numMagicSquaresInside(int[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int count=0;  
        for(int i=0;i<grid.length && i+2<grid.length;i++){
            for(int j=0;j<grid[0].length && j+2<grid[0].length;j++){
                if(check(grid,i,j,i+2,j+2))
                    count++;
            }
        }
        return count;
    }
    public static boolean check(int[][] grid,int i,int j,int row,int col){
        int[] val=new int[10];
        for(int k=i;k<=row;k++){
            for(int l=j;l<=col;l++){
                if(grid[k][l]>9 || grid[k][l]<1)
                    return false;
                val[grid[k][l]]++;
                if(val[grid[k][l]]>1)
                    return false;
            }
        }
        return (grid[i][j]+grid[i][j+1]+grid[i][j+2]==15 && grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2]==15
               && grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2]==15 && grid[i][j]+grid[i+1][j]+grid[i+2][j]==15
               && grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1]==15 && grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2]==15
               && grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2]==15 && grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j]==15);
    }

}
