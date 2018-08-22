

package GoogleLocked;

import java.util.*;
public class LoggerRateLimiter {
		class Logger {

	    Map<String,Integer> map;
	    /** Initialize your data structure here. */
	    public Logger() {
	        map=new HashMap<>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        
	        if(map.containsKey(message)){
	            int lastPrint=map.get(message);
	            if(timestamp-lastPrint>=10){
	                map.put(message,timestamp);
	                return true;
	            }
	            return false;
	        }
	        else{
	            map.put(message,timestamp);
	            return true;
	        }
	        
	        
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
