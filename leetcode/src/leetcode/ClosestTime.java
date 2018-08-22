package leetcode;

public class ClosestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nextClosestTime("19:34"));
		
	}
	
	public static String nextClosestTime(String CurrentTime) {
        //first we will store hour and min in different variables
        int hours = Integer.parseInt(CurrentTime.substring(0, 2));
        int mins = Integer.parseInt(CurrentTime.substring(3));
        
        //we will remove the : in between time
        CurrentTime = CurrentTime.replace(":", "");
        
        //we will convert the input time in minutes
        int minuteFormat = hours * 60 + mins;
       
        //calculate the remaining time to start next day
        int minutesLeft = 1440 - minuteFormat;
        int ans = 1440;
        
        for(int i = 0; i < CurrentTime.length(); i++) { 
            for(int j = 0;j < CurrentTime.length(); j++) { 
                if(j != i) {
                	int first= Character.getNumericValue(CurrentTime.charAt(i)) * 10;
                	int second= Character.getNumericValue(CurrentTime.charAt(j));
                    int newHour = first + second;
                    
                    if(newHour >= 0 && newHour < 24) {
                        for(int a = 0; a < CurrentTime.length(); a++) {
                            if(a != i && a != j) {
                                for(int b = 0; b < CurrentTime.length();b++) {
                                    if(b != a && b != j && b!= i) {
                                    	int third= Character.getNumericValue(CurrentTime.charAt(a)) * 10;
                                    	int fourth= Character.getNumericValue(CurrentTime.charAt(b));
                                        int newMinute = third + fourth;
                                        if(newMinute >= 0 && newMinute < 60) {
                                           
                                            int totalNewMin =  newHour* 60 + newMinute;
                                            
                                            if(totalNewMin <= minuteFormat) {
                                                totalNewMin += minutesLeft;    
                                            } else {
                                            	totalNewMin -=minuteFormat;
                                            }
                                       
                                            ans = Math.min(ans, totalNewMin);
                                        }
                                    }
                                }
                            }
                        }                                                                        
                    }
                }
            }
        }
        int newH= (hours+ans/60)%24;
        int newM= (mins+ans%60)/60;
        int nh = newH + newM;
        int nm = (mins+ans%60)%60;
        return (nh<10 ? "0"+nh : nh) + ":" + (nm<10 ? "0"+nm : nm) ;
    }
}
