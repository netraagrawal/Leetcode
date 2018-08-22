package leetcode;

import java.util.ArrayList;
import java.util.List;

public class X2Y2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate(5));
	}
	
	public static List<int[]> calculate(int N){
		List<int[]> list=new ArrayList<>();
		for(int x=0;x*x<N*N;x++){
			for(int y=0;y*y<N*N ;y++){
				if((x*x)+(y*y)==N*N){
					list.add(new int[]{x,y});
					int[] temp=list.get(list.size()-1);
				}
			}
		}
		return list;
	}

}
