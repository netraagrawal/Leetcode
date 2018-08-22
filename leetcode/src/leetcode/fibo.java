package leetcode;

public class fibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int fibonnaci(int n){
		int res=0;
		if(n<=2){
			return 1;
		}
		int a=1,b=1;
		
		for(int i=3;i<=n;i++){
			res=a+b;
			a=b;
			b=res;
		}
		
		return res;
		
		
	}
	
	public boolean checkFibo(int n){
		
		if(n<=2){
			return true;
		}
		int a=1,b=1;
		int res=0;
		while(res<=n){
			if(res==n){
				return true;
			}
			res=a+b;
			a=b;
			b=res;
		}
		
		return false;
	}

}
