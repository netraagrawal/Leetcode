
public class spiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{1,2,3},{4,5,6},{7,8,9}};
		spiralPrint(input);
	}
	
	public static void spiralPrint(int[][] input){
		if(input.length==0 || input[0].length==0)
			return;
		
		int r1=0,c1=0;
		int r2=input.length-1,c2=input[0].length-1;
		while(r1<r2 && c1<c2){
			while(c1<=c2){
				System.out.print(input[r1][c1]+" ");
				c1++;
			}
			c1--;
			
			while(r1<r2){
				System.out.print(input[r1+1][c1]+" ");
				
				r1++;
			}
			c1--;
			while(c1>=0){
				System.out.print(input[r1][c1]+" ");
				c1--;
			}
			c1++;
			while(r2>0){
				System.out.print(input[r2][c1]+" ");
				r2--;
			}
			r1++;
			c1++;
			r2--;
			c2--;
			
		}
		
		
		
		
		
		
	}

}
