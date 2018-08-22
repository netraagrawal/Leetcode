package leetcode;

public class Piles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] piles=new int[2];
		calculatePiles(11,9,2,piles);
		System.out.println("count"+count);
	}
	static int count=0;
	public static int calculatePiles(int N,int M,int P,int[] piles){
		if(P==1){
			count=N;
			return N;
		}
		if(M>=N){
			return 1;
		}
		int i=0;
		int tempP=P;
		while(N>0 && tempP>0){
			piles[i]=N/tempP;
			N=N-piles[i];
			i++;
			tempP=tempP-1;
		}
		for(int j=0;j<piles.length;j++){
			
			if(piles[j]==0){
				continue;
			}
			if(piles[j]>M){
				calculatePiles(piles[j],M,P,new int[2]);
			}
			else{
				count++;
			}
		}
		return 0;
	}

}
