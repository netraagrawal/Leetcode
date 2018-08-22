package GoogleLocked;
import java.util.*;
public class LonelyPixel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int findLonelyPixel(char[][] picture) {
        if(picture.length==0 || picture[0].length==0)
            return 0;
        int ans=0;
        List<Integer> row=new ArrayList<>();
        List<Integer> col=new ArrayList<>();
        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[0].length;j++){
                if(picture[i][j]=='B' && !row.contains(i) && !col.contains(j) && check(picture,i,j,row,col))
                  ans++;  
            }
        }
        return ans;
    }
    public static boolean check(char[][] ar,int i,int j,List<Integer> row,List<Integer> col){
        for(int k=0;k<ar.length;k++){
            if(k!=i && ar[k][j]=='B'){
                col.add(j);
                return false;
            }
        }
        for(int l=0;l<ar[0].length;l++){
            if(l!=j && ar[i][l]=='B'){
                row.add(i);
                return false;
            }
        }
        return true;
    }
	
}
