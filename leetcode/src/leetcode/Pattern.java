package leetcode;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int level=1,i=1;
		while(i<=10){
			for(int j=1;j<=level && i<=10;j++){
				System.out.print(i+" ");
				i++;
			}
			level++;
			System.out.println();
		}
	}

}
