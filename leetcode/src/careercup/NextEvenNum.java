package careercup;

public class NextEvenNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNextEven(new char[]{'4','5','5','7','5','3','5'}));
	}
	
	public static int getNextEven(char[] num){
		
		int start=-1;
		for(int i=num.length-1 ;i>0;i--){
			if(num[i-1]-'0'<num[i]-'0' && num[i-1]%2==0){
				start=i-1;
				break;
			}
		}
		
		if(start==-1)
			return Integer.valueOf(String.valueOf(num));
		int max=num[start+1]-'0',begin=start+1;
		for(int i=start+1;i<num.length-1;i++){
			if(num[i+1]-'0'<max && num[i+1]>num[start]){
				max=num[i+1]-'0';
				begin=i+1;
			}
		}
		reverse(num,begin,num.length-1);
		reverse(num,start,num.length-1);
		return Integer.valueOf(String.valueOf(num));
		
	}
	
	public static void reverse(char[] num,int s,int e){
		while(s<e){
			char a=num[s];
			num[s++]=num[e];
			num[e--]=a;
			
		}
	}
}
