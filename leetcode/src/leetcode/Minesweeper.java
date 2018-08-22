package leetcode;

public class Minesweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] input={{".","m",".","."},
				{".",".","m","."},
				{".","m",".","."},
				{".",".",".","."}};
		int[][] r=new int[4][4];
		r=minesweeper(input);
		for(int i=0;i<r.length;i++){
			for(int j=0;j<r[0].length;j++){
				System.out.print(r[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] minesweeper(String[][] input){
		int[][] res=new int[input.length][input[0].length];
		if(input.length==0 || input[0].length==0){
			return res;
		}
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]=="m")
					setValue(res,i,j);
			}
		}
		for(int i=0;i<input.length;i++){
			int count=0;
			for(int j=0;j<input[0].length;j++){
				if((i%2) != 0 && input[i][j].equals("m"))
					count++;
				if(input[i][j].equals("m"))
					setRight(res,i,j);
			}
			if(count>0){
				for(int k=0;k<res[0].length;k++)
					res[i][k]*=3;
			}
		}
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(!input[i][j].equals("m")){
					int count=checkCorner(input,i+1,j-1)+checkCorner(input,i+1,j+1)+checkCorner(input,i-1,j-1)+checkCorner(input,i-1,j+1);
					if(count>=1)
						res[i][j]*=2;
				}
			}
		}
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]=="m")
					res[i][j]=-1;
			}
		}
		
		return res;
	}
	public static void setValue(int[][] res,int i,int j){
		int[][] dir={{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
		for(int[] d:dir){
			int n=i+d[0];
			int m=j+d[1];
			if(n>=0 && m>=0 && n<res.length && m<res[0].length)
				res[n][m]+=1;
		}
		
		//
	}
	
	public static int checkCorner(String[][] input,int i,int j){
		if(i<0 || j<0 || i>input.length-1 || j>input[0].length-1)
			return 0;
		if(input[i][j].equals("m"))
			return 1;
		return 0;
	}
	public static void setRight(int[][] res,int i,int j){
		
		if(i<res.length && j+1<res[0].length)
			res[i][j+1]=0;

	}

}
