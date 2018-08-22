package leetcode;

public class BinaryAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1010", "1011"));
	}
	
	public static String addBinary(String a, String b) {
        
        if(a.length()==0 && b.length()==0){
            return "";
        }
        
        StringBuilder result=new StringBuilder();
        int i=0,j=0;
        int carry=0;
        while(i<a.length() || j<b.length()){
            int sum=carry;
            if(i<a.length()){
                sum+=Integer.parseInt(a.charAt(i)+"");
                i++;
            }
            if(j<b.length()){
                sum+=Integer.parseInt(b.charAt(j)+"");
                j++;
            }
            result.append(sum%2);
            carry=sum/2;
        }
        if(carry==1){
            result.append(carry);
        }
        return result.reverse().toString();
        
    }
	

}
