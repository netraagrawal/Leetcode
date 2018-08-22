package Strings;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("adobecodebanc", "abc"));
	}
	
	public static String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        if(m==0 || n==0 || m<n){
            return "";
        }
        
        int[] require=new int[128];
        int minLen=Integer.MAX_VALUE, index=0,count=0;
        for(int i=0;i<n;i++){
            require[t.charAt(i)]++;
        }
        for(int e=0,w=0;e<m;e++){
            require[s.charAt(e)]--;
            if(require[s.charAt(e)]>=0){
                count++;
            }
            while(count==n){
                if(e-w+1<minLen){
                    minLen=e-w+1;
                    index=w;
                }
                require[s.charAt(w)]++;
                if(require[s.charAt(w)]>0){
                    count--;
                }
                w++;
            }
        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        else{
            return s.substring(index,index+minLen);
        }
        
    }

}
