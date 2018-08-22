package Strings;

public class CompareVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("01","1"));
	}
	
	public static int compareVersion(String version1, String version2) {
        if(version1.length()==0 || version2.length()==0)
            return 0;
        if(version1.equals(version2))
            return 0;
        String[] v1=version1.split("\\.");
      
        String[] v2=version2.split("\\.");
        int i=0,j=0;
        while(i<v1.length && j<v2.length){
            if(Integer.valueOf(v1[i++])==Integer.valueOf(v2[j++]))
                continue;
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[j]))
                return 1;
            else
                return -1;
        }
        
        if(i!=v1.length)
            return 1;
        else if(j!=v2.length)
            return -1;
        else
        	return 0;
    }

}
