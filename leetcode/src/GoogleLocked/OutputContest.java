package GoogleLocked;

public class OutputContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String findContestMatch(int n) {
        if(n==0){
            return "";
        }
        String[] res=new String[n/2];
        int i=1,j=n;
        while(i<j){
            res[i-1]="("+i+","+j+")";
            i++;
            j--;
        }
        int k=(n/2);
        while(k>=1){
            i=0;
            j=k-1;
            while(i<j){
                res[i]="("+res[i]+","+res[j]+")";
                i++;
                j--;
            }
            k/=2;
        }
        return res[0]; 
    }

}
