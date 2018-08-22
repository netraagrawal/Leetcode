package GoogleLocked;

public class MovingAverage {
	
	class MovingAvg {
	    
	    int[] window;
	    int curr,i,sum;
	    /** Initialize your data structure here. */
	    public MovingAvg(int size) {
	        window=new int[size];
	        curr=0;
	        sum=0;
	    }
	    
	    public double next(int val) {
	        
	        if(i<window.length){
	            i++;
	        }
	        sum-=window[curr];
	        sum+=val;
	        window[curr]=val;
	        curr=(curr+1)%window.length;
	        
	        return (double)sum/i;
	        
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
