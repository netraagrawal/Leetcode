package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.MeetingRoom1.Interval;

public class MeetingRoom2 {
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
	public static int valid(Interval[] intervals){
		
		
		if(intervals.length==0){
			return 0;
		}
		Arrays.sort(intervals,new Comparator<Interval>(){
			public int compare(Interval e1,Interval e2){
				return e1.start-e2.start;
			}
		});
		Queue<Interval> que=new PriorityQueue<Interval>(intervals.length,new Comparator<Interval>(){
			public int compare(Interval i1,Interval i2){
				return i1.end-i2.end;
			}
		});
		que.offer(intervals[0]);
		for(int i=1;i<intervals.length;i++){
			Interval c=que.poll();
			if(intervals[i].start>=c.end){
				c.end=intervals[i].end;
			}
			else{
				que.offer(intervals[i]);
			}
			que.offer(c);
		}
		return que.size();
	}

}
