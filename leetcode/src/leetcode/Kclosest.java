package leetcode;

public class Kclosest {
	
	public static class Point {
	    public double x;
	    public double y;

	    public Point(final double x, final double y) {
	        this.x = x;
	        this.y = y;
	    }
	}
	
	public static double kthSmallest(final double[] A, final int p, final int r, final int k) {
	    if (p < r) {
	        final int q = partition(A, p, r);

	        final int n = q - p + 1;
	        if (k == n) {
	            return A[q];
	        } else if (k < n) {
	            return kthSmallest(A, p, q - 1, k);
	        } else {
	            return kthSmallest(A, q + 1, r, k - n);
	        }
	    } else {
	        return Double.MIN_VALUE;
	    }
	}
	
	private static void swap(final double input[], final int i, final int j) {
	    final double temp = input[i];
	    input[i] = input[j];
	    input[j] = temp;
	}

	private static int partition(final double[] A, final int p, final int r) {
	    final double pivot = A[r];
	    int i = p-1;
	    int j = p;

	    for (j = p; j < r; j++) {
	        if (A[j] <= pivot) {
	            swap(A, ++i, j);
	        }
	    }

	    swap(A, i + 1, r);
	    return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] input=new double[]{5,1,3,2,4};
		System.out.println(kthSmallest(input,0,input.length-1, 2));

	}

}
