package leetcode;

import java.util.Arrays;
import java.util.*;
public class MeetingRoom1 {
	public static class Interval{
		int end,start;
		Interval(){
			end=0;
			start=0;
		}
		Interval(int end,int start){
			this.end=end;
			this.start=start;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(30, 0);
		Interval i2 = new Interval(10, 5);
		Interval i3 = new Interval(20, 15);
		Interval[] intervals ={i1, i2, i3};
		System.out.println(valid(intervals)); 

	}
	
	public static boolean valid(Interval[] intervals){
		
		
		if(intervals.length==0){
			return true;
		}
		Arrays.sort(intervals,new Comparator<Interval>(){
			public int compare(Interval e1,Interval e2){
				return e1.end-e2.end;
			}
		});
		for(int i=0;i<intervals.length-1;i++){
			if(intervals[i].end>intervals[i+1].start){
				return false;
			}
		}
		return true;
	}

}


