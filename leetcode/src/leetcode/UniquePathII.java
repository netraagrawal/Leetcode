package leetcode;

public class UniquePathII {
	
	static int count;
	static int[][] dir={{1,1},{1,-1},{-1,1},{-1,-1},{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		helper(new int[4][4],0,0,2,2,2,0);
		System.out.println(count);
	}
	 public static void helper(int[][] nums,int i,int j,int ti,int tj,int steps,int m){
		 if(i<0 || i>nums.length-1 || j<0 || j>nums[0].length-1 || i>ti || j>tj || m>steps)
			 return;
		 
		 if(i==ti && j==tj){
			 count++;
			 return;
		 }
		 for(int[] d:dir){
			 int newi=d[0]+i;
			 int newj=d[1]+j;
			 helper(nums,newi,newj,ti,tj,steps,m+1);
		 }
		 
	 }

}
