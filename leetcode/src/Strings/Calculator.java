package Strings;
import java.util.*;
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate("2147483647"));
	}
	public static int calculate(String s) {
        if(s.length()==0)
            return 0;
        Stack<Integer> st=new Stack<>();
        int pre=1;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(result);
                st.push(pre);
                result=0;
                pre=1;
            }
            else if(Character.isDigit(s.charAt(i))){
                int num=s.charAt(i)-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num=(num*10)+s.charAt(i+1)-'0';
                    i++;
                }
                result+=num*pre;
            }
            else if(s.charAt(i)=='-')
                pre=-1;
            else if(s.charAt(i)=='+')
                pre=1;
            else if(s.charAt(i)==')'){
                result=result*st.pop()+st.pop();        
            }
            
        }
        
        return result;
    }

}
