package GoogleLocked;

import java.util.*;
public class ClosestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public String nextClosestTime(String time) {
        
        if(time==null){
            return "";
        }
        String ans=time;
        int end=24*60;
        int given=60*(Integer.parseInt(time.substring(0,2)));
        given+=Integer.parseInt(time.substring(3));
        
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<time.length();i++){
            if(time.charAt(i)!=':'){
                set.add(time.charAt(i)-'0');
            }
        }
        
        for(Integer h1: set){
            for(Integer h2: set){
                if(h1*10+h2<24){
                    System.out.println(h1*10+h2);
                    for(Integer m1: set){
                        for(Integer m2: set){
                            if(m1*10+m2<60){
                                int min= 60 *(h1*10+h2) + (m1*10+m2);
                                int diff=Math.floorMod(min-given,24*60);
                                if(diff>0 && diff<end){
                                    ans=String.format("%02d:%02d",(h1*10+h2),(m1*10+m2));
                                    System.out.println(ans);
                                    end=diff;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
        
    }

}
