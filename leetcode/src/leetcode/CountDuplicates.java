package leetcode;

public class CountDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printRepeating(new int[]{2,2,3,3,3}, 5);
	}
	
	static void printRepeating(int arr[], int size)
    {
        int i;  
        System.out.println("The repeating elements are : ");
        int count=0;
        for (i = 0; i < size; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
            	count++;
               
        }  
        System.out.println(count);
    } 
 

}
