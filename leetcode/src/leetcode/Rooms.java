package leetcode;
import java.util.*;
public class Rooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> rooms=new ArrayList<>();
		rooms.add(new ArrayList<>(Arrays.asList(1,3,2)));
		rooms.add(new ArrayList<>(Arrays.asList(2,3)));
		rooms.add(new ArrayList<>(Arrays.asList(2,1,3,1)));
		rooms.add(new ArrayList<>());
		canVisitAllRooms(rooms);
	}
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size()==0)
            return true;
        boolean visited[]=new boolean[rooms.size()];
        
        helper(rooms,visited,0);
        for(int i=0;i<visited.length;i++)
            if(!visited[i])
                return false;
        return true;
    }
    
    public static void helper(List<List<Integer>> rooms,boolean visited[],int cur){
        if(visited[cur])
            return;
        visited[cur]=true;
        for(int i=0;i<rooms.get(cur).size();i++){
            helper(rooms,visited,rooms.get(cur).get(i));
        }
    }

}
