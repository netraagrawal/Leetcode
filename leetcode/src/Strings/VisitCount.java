package Strings;
import java.util.*;
public class VisitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in={"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		subdomainVisits(in);
	}
	
	public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> res=new ArrayList<>();
        if(cpdomains.length==0)
            return res;
        Map<String,Integer> map=new HashMap<>();
        for(String sub:cpdomains){
            String[] first=sub.split("\\s+");
            String[] split=first[1].split("\\.");
            String s="";
            for(int i=split.length-1;i>=0;i--){
                s=(i==split.length-1)?split[i]: split[i]+"."+s;
                if(!map.containsKey(s))
                    map.put(s,Integer.valueOf(first[0]));
                else
                    map.put(s,map.get(s)+Integer.valueOf(first[0]));
            }    
        }
        for(String s:map.keySet()){
            res.add(map.get(s)+" "+s);
        }
        return res;
    }

}
