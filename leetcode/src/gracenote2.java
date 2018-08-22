
public class gracenote2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={1,3,5,8,10};
		int target=20;
		System.out.println(searchElement(input,target));
	}
	
	public static boolean searchElement(int[] arr,int target){
		
		if(arr.length==0)
			return false;
		
		int i=0,j=arr.length-1;
		while(i<=j){
			int mid=(i+j)/2;
			if(arr[mid]==target)
				return true;
			else if(arr[mid]<target)
				i=mid+1;
			else if(arr[mid]>target)
				j=mid-1;
		}
		
		return false;	
	}

}
