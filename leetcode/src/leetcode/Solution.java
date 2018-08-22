package leetcode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("11:00"));
	}
	
	
	 public static String solution(String time) {
	        // write your code in Java SE 8
	        
	        String hour_min[] = time.split(":");
	        time = time.replace(":", "");
	        
	        int currTimeInMins = (Integer.parseInt(hour_min[0]) * 60) + Integer.parseInt(hour_min[1]);
	        System.out.println("Current Time In mins = " + currTimeInMins);
	        
	        int timeLeftToCompleteClockCycle = 1440 - currTimeInMins;
	        System.out.println("Cycle remaining Time = " + timeLeftToCompleteClockCycle + "\n");
	        int nextNearTime = 1440;
	        
	        int lastIndex = 0, i = 0, j = 0, p = 0;
	        
	        while(i < time.length())
	        {
	            lastIndex += i;
	            while(j < time.length())
	            {
	                if( i != j)
	                {
	                    lastIndex += j;
	                    
	                    int currHour = Character.getNumericValue(time.charAt(i)) * 10 + Character.getNumericValue(time.charAt(j));
	                    
	                    if(currHour < 24 && currHour>0)
	                    {
	                        while(p < time.length())
	                        {
	                            if(i != p && j != p)
	                            {
	                                lastIndex += p;
	                                int q = 6 - lastIndex;
	                                
	                                int currMin = Character.getNumericValue(time.charAt(p)) * 10 + Character.getNumericValue(time.charAt(q));
	                                
	                                
	                                if(currMin < 60)
	                                {
	                                    
										  System.out.println("Next Hour = " +
										  (currHour) + " Next Min = " + currMin);
										 
										 
	                                    int nextTimeInMins = currHour * 60 + currMin;
	                                    
	                                    System.out.println(
										 "Next Time in Min Before = " +
										  nextTimeInMins);
	                                    
	                                    nextTimeInMins = (nextTimeInMins <= currTimeInMins) ? (nextTimeInMins += timeLeftToCompleteClockCycle) : (nextTimeInMins -= currTimeInMins);
	                                    
	                                    nextNearTime = Math.min(nextNearTime, nextTimeInMins);
	                                }
	                                lastIndex -= p;
	                            }
	                            p++;
	                        }
	                    }
	                    lastIndex -= j;
	                }
	                j++;
	            }
	            lastIndex -= i;
	            i++;
	        }
	        
	        
	        
	        int formatHour = ((Integer.parseInt(hour_min[0]) + nextNearTime / 60) % 24) + ((Integer.parseInt(hour_min[1]) + nextNearTime % 60) / 60);
	        
	        int formatMin = (Integer.parseInt(hour_min[1]) + nextNearTime % 60) % 60;
	        System.out.println(formatHour + "" +formatMin);
	        return (formatHour < 10 ? "0" + formatHour : formatHour) + ":" + (formatMin < 10 ? "0" + formatMin : formatMin);
	    }
}
