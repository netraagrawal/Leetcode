package GoogleLocked;

import java.util.HashMap;
import java.util.Map;

public class AnagramMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res[]=anagramMappings(new int[]{20,30,21,50},new int[]{50,21,20,30});
		for(int x:res){
			System.out.print(x+" ");
		}
	}
	
	public static int[] anagramMappings(int[] A, int[] B) {
	        
	        if(A.length==0 && B.length==0){
	            return new int[]{};
	        }
	        
	        int[] result=new int[A.length];
	        Map<Integer,Integer> map=new HashMap<>();
	        for(int i=0;i<B.length;i++){
	            map.put(B[i],i);
	        }
	        
	        for(int j=0;j<A.length;j++){
	            result[j]=map.get(A[j]);
	        }
	        return result;
	        
    }

}
