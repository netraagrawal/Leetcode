package careercup;

public class FillNxN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{1,2,0},{0,1,0},{0,0,1}};
		fillmatrix(input);
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void fillmatrix(int[][] input){
		
		if(input.length==0 || input[0].length==0)
			return;
		
		helper(input);
		
	}
	
	public static boolean helper(int[][] input){
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]==0){
					for(int k=1;k<=input.length;k++){
						if(check(input,i,j,k)){
							input[i][j]=k;
							if(helper(input))
								return true;
						}
						input[i][j]=0;
					}
					return false;
				}
				
			}
		}
		return true;
	}
	
	public static boolean check(int[][] input,int r,int c,int val){
		
		for(int i=0;i<input[0].length;i++){
			if(input[r][i]==val)
				return false;
			if(input[i][c]==val)
				return false;
		}
		
		return true;
	}

}
