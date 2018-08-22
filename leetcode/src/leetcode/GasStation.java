package leetcode;

public class GasStation {
	
	static int next;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canCompleteCircuit(new int[]{3,3,4},new int[]{3,4,4}));
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(gas.length==0 || cost.length==0){
            return 0;
        }
        
        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i]){
                if(check(i,gas,cost)){
                    return i;
                }
                i=next;
            }
        }
        return -1;
        
    }
    
    public static boolean check(int start,int[] gas,int[] cost){
        
        int beginGas= gas[start];
        int i=start;
        int require=0;
        while(start<gas.length){
            require=cost[start];
            if(beginGas<require){
            	next=start;
                return false;
            }
            start++;
            if(start<gas.length){
                beginGas=beginGas-require+gas[start];
            }
        }
        int j=0;
        while(j<i){
        	beginGas=beginGas-require+gas[j];
        	require=cost[j];
            if(beginGas<require){
                return false;
            }
            j++;
        }
        if(beginGas>=require){
            return true;
        }
        return false;
        
    }

}
