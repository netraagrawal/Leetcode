package GoogleLocked;
import java.util.*;
public class GroupShiftedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result=new ArrayList<>();
        if(strings.length==0){
            return result;
        }
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strings.length;i++){
            String temp=strings[i];
            StringBuilder code=new StringBuilder();
            code.append(0+"");
            char ch=temp.charAt(0);
            for(int j=1;j<temp.length();j++){
                if(temp.charAt(j)-ch<0){
                    code.append(26+ temp.charAt(j)-ch+"");
                }
                else{
                    code.append(temp.charAt(j)-ch+"");
                }
                ch=temp.charAt(j);
            }
            System.out.println("temp:"+temp+" code:"+code.toString());
            if(!map.containsKey(code.toString())){
                map.put(code.toString(),new ArrayList<>());
            }
            map.get(code.toString()).add(temp);
        }
        
        for(List<String> list: map.values()){
            result.add(list);
        }
        return result;
    }
}
