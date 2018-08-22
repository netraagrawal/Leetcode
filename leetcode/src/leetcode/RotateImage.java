package leetcode;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{1,2,3},{4,5,6},{7,8,9}};
		rotate(input);
	}
	
	public static void rotate(int[][] matrix) {
	        
	        if(matrix.length==0){
	            return;
	        }
	        int i=0,j=matrix[0].length-1;
	        while(i<j){
	            int[] temp=matrix[j];
	            matrix[j]=matrix[i];
	            matrix[i]=temp;
	            i++;
	            j--;
	        }
	        
	        for(int r=0;r<matrix.length;r++){
	            for(int c=r+1;c<matrix[0].length;c++){
	                
	                int temp=matrix[r][c];
	                matrix[r][c]=matrix[c][r];
	                matrix[c][r]=temp;
	            }
	        }
	        
	    }

}
