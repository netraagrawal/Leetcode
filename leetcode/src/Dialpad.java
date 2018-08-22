import java.util.*;
public class Dialpad {
	
	// function is called from main method.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input={ "4938532894754", "1234567", "472844278465445","103023567"};
		System.out.println(validTicket(input));
	}
	
	// function to return all the valid ticket number strings
	// Idea is to take each string and try to divide the string in such a way that total subcount is equal to 7 and each digit lies in between 1 to 59.
	public static List<String> validTicket(String[] input){
		List<String> result=new ArrayList<>();
		if(input==null)
			return null;
		
		// loop to traverse the list of strings
		for(int i=0;i<input.length;i++){
			
			// if length of string is greater than 14 then it is invalid
			// because each digit can be at max 2 digit long(<=59) and we want 7 unique digits so 7*2=14 
			if(input[i].length()>14){
				continue;
			}
			
			//if length is <=14, we can run the helper function to check if we can divide it in in 7 unique numbers
			// if it returns true we will add that string in our result
			Set<Integer> set=new HashSet<>();
			if(helper(input[i],set,0,0)){
				result.add(input[i]+" ->"+set);
			}
		}
		return result;

	}
	
	public static boolean helper(String input,Set<Integer> set,int count,int start){
		
		//base condition
		//if count is 7 and we have reach end of the string we will return true
		if(count==7 && start==input.length())
			return true;
		else if(count>=7)
			return false;
		
		//this variable is used to keep into account substring length
		int c=0;
		
		//this loop runs from the start to start+2 
		//because we can have at max 2 digit number
		for(int i=start+1;i<=start+2 && i<=input.length();i++){
			
			// in worst case input, if we have letters like +,-,a,b,$ and so on we will return false
			if(Character.isLetter(input.charAt(i-1)))
				return false;
			
			//if number is starting from 0 it is invalid
			// e.g 0,01,02
			if(input.charAt(start)=='0')
				return false;
			int num=Integer.parseInt(input.substring(start, i));
			c++;
			
			//to check range of the numbers
			// set to check uniqueness of the number
			if((num<1 || num>59) || !set.add(num))
				return false;
			
			if(helper(input,set,count+1,start+c))
				return true;
			set.remove(num);
		}
		return false;	
		
	}

}
