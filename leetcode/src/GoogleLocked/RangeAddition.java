package GoogleLocked;

public class RangeAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] getModifiedArray(int length, int[][] updates) {
        
        int[] result=new int[length];
        if(length==0 || updates.length==0 || updates[0].length==0){
            return result;
        }
        for(int[] op: updates){
            if(op[0]<0 || op[1]>length-1)
                continue;
            for(int i=op[0];i<=op[1];i++){
                result[i]+=op[2];
            }
        }
        return result;
    }

}
