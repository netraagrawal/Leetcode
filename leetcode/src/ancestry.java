import java.util.*;
public class ancestry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input1={"how it was done","are you how","it goes to","goes done are it"};
		String[] input2={"done it","it"};
		text(input1,input2);
	}
	
	public static void text(String[] sent,String[] phrase){
		if(sent.length==0 || phrase.length==0)
			return;
		HashMap<String,List<Integer>> map=new HashMap<>();
		boolean flag1=false,flag2=true;;
		for(String ph: phrase){
			map.put(ph, new ArrayList<>());
			for(int p=0;p<sent.length;p++){
				String[] temp=sent[p].split(" ");
				String[] temp2=ph.split(" ");
				for(int i=0;i<temp2.length;i++){
					for(int j=0;j<temp.length;j++){
						if(temp2[i].length()==temp[j].length() && temp2[i].indexOf(temp[j])>=0){
							flag1=true;
							break;
						}
					}
					if(!flag1){
						flag2=false;
						break;
					}
					else
						flag1=false;
				}
				if(flag2){
					if(!map.containsKey(ph))
						map.put(ph, new ArrayList<>());
					map.get(ph).add(p);
				}
				else
					flag2=true;
				
			}
			List<Integer> list=map.get(ph);
			if(list.size()==0){
				System.out.println("-1");
			}
			else{
				for(int i=0;i<list.size();i++){
					System.out.print(list.get(i)+" ");
				}
				System.out.println();
			}
			
		}
		
		
	}

}
