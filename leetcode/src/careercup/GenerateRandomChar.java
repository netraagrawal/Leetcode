package careercup;
import java.util.*;
public class GenerateRandomChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] in={'a','n','s'};
		double[] d={0.25,0.45,0.30};
		System.out.println(randomChar(in, d));
	}
	
	public static char randomChar(char[] ch,double[] d){
		if(ch.length==0 || d.length==0)
			return ' ';
		
		Random r=new Random();
		double random=r.nextDouble()*1.0+0.0;
		double sum=0.0;
		for(int i=0;i<ch.length;i++){
			sum+=d[i];
			if(random<sum)
				return ch[i];
		}
		return ' ';
		
	}

}
