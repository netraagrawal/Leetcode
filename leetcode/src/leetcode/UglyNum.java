package leetcode;
import java.util.*;
public class UglyNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nthSuperUglyNumber(10, new int[]{2,7,13,19});
	}
	
	public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for (int i=0;i<primes.length;i++)
            queue.offer(new int[]{primes[i], primes[i], 0});

        int[] nums=new int[n+1];
        nums[0]=1;
        
        int i=1;
        while (i<n){
            int[] entry=queue.poll();
            int num=entry[0], prime=entry[1], index=entry[2];
            if (num!=nums[i-1]){
                nums[i]=num;
                i++;
            }
            queue.offer(new int[]{prime*nums[index+1], prime, index+1});
        }
        return nums[n-1];
    }

}
