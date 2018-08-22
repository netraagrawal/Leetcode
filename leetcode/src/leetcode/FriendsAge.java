package leetcode;

public class FriendsAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numFriendRequests(new int[]{16,16}));
	}
	 public static int numFriendRequests(int[] ages) {
	        if(ages.length==0)
	            return 0;
	        int[] count=new int[120+1];
	        for(int i=0;i<ages.length;i++)
	            count[ages[i]]++;
	        int sum=0;
	        for(int i=1;i<=120;i++){
	            sum+=count[i];
	            count[i]=sum;
	        }
	        sum=0;
	        for(int i=0;i<ages.length;i++){
	            if(count[ages[i]]!=0 && ages[i]>14){
	                    int range=(ages[i]/2)+7;
	                    sum+=(count[ages[i]]-count[range])-1;
	            }
        	}
	        return sum;
	    }
	 
	 
	/* public static int numFriendRequests(int[] ages) {
	        int res = 0;
	        int[] numInAge = new int[121], sumInAge = new int[121];
	        
	        for(int i : ages) 
	            numInAge[i] ++;
	        
	        for(int i = 1; i <= 120; ++i) 
	            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
	        
	        for(int i = 15; i <= 120; ++i) {
	            if(numInAge[i] == 0) continue;
	            int count = sumInAge[i] - sumInAge[i / 2 + 7];
	            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
	        }
	        return res;
	    }*/

}
