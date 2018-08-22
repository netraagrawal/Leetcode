package leetcode;

public class SparseMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	
	public int[][] sparse(int[][] A,int[][] B){
		 int[][] result=new int[A.length][B[0].length];
	        if(A.length==0 || B.length==0){
	            return result;
	        }
	        if(A[0].length!=B.length){
	            return result;
	        }
	        
	        
	        int n=A.length, m=A[0].length, p=B[0].length;
	        
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(A[i][j]!=0){
	                    for(int k=0;k<p;k++){
	                        if(B[j][k]!=0){
	                            result[i][k]+=A[i][j]*B[j][k];
	                        }
	                    }
	                }
	            }
	        }
	        return result;
	}
}
