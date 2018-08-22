package leetcode;

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val={3,2,1,5,6,4};
		System.out.println(findKthLargest(val, 2));
	}
	
	public static int findKthLargest(int[] a, int k) {
	    int n = a.length;
	    int p = quickSelect(a, 0, n - 1, n - k + 1);
	    return a[p];
	  }
	  
	  
	  public static int quickSelect(int[] a, int lo, int hi, int k) {
	    
	    // put nums that are <= pivot to the left
	    // put nums that are  > pivot to the right
	    int i = lo, j = hi, pivot = a[hi];
	    while (i < j) {
	      if (a[i++] > pivot) swap(a, --i, --j);
	    }
	    swap(a, i, hi);
	    
	    // count the nums that are <= pivot from lo
	    int m = i - lo + 1;
	    
	    // pivot is the one!
	    if (m == k)     return i;
	    // pivot is too big, so it must be on the left
	    else if (m > k) return quickSelect(a, lo, i - 1, k);
	    // pivot is too small, so it must be on the right
	    else            return quickSelect(a, i + 1, hi, k - m);
	  }
	  
	  public static void swap(int[] a, int i, int j) {
	    int tmp = a[i];
	    a[i] = a[j];
	    a[j] = tmp;
	  }

}
