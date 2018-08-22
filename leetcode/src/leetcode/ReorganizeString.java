package leetcode;
import java.util.*;
public class ReorganizeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reorganizeString("aaaabbbbc");
	}
	static class Elements{
        char letter;
        int count;
        
        Elements(char l,int c){
            this.letter=l;
            this.count=c;
        }
    }
    public static String reorganizeString(String S) {
        
        if(S==null){
            return null;
        }
        int[] val=new int[26];
        
        for(int i=0;i<S.length();i++){
            val[S.charAt(i)-'a']++;
            if(val[S.charAt(i)-'a']>(S.length()+1)/2){
                return "";
            }
        }
        PriorityQueue<Elements> pq=new PriorityQueue<>((a,b) -> a.count==b.count? a.letter-b.letter: b.count-a.count);
        for(int i=0;i<26;i++){
            if(val[i]!=0){
                pq.add(new Elements((char)(i+'a'),val[i]));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(pq.size()>=2){
            Elements e1=pq.poll();
            Elements e2=pq.poll();
            
            sb.append(e1.letter);
            sb.append(e2.letter);
            
            if(--e1.count>0){
                pq.add(e1);
            }
            if(--e2.count>0){
                pq.add(e2);
            }
        }
        
        if(pq.size()>0){
            sb.append(pq.poll().letter);
        }
        return sb.toString();
        
    }

}
