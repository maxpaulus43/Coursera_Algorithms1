package week3;

public class Merge {

	private static Comparable[] sorted;
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		
		for(int k = lo; k <= hi; k++) {
			sorted[k] = a[k];
		}
		
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k < hi; k++) {
			if (i > mid)							a[k] = sorted[j++];
			else if (j > hi)						a[k] = sorted[i++];
			else if (less(sorted[i], sorted[j]))	a[k] = sorted[i++];
			else 									a[k] = sorted[j++];
		}
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		
		//base case
		if (hi <= lo) return;
		
		int mid = lo + (hi - lo) / 2; 
		
		//sort first half
		sort(a, lo, mid);
		//sort second half
		sort(a, mid + 1, hi);
		//merge two halves
		merge(a, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		if (N <= 1) return;
		
		sorted = new Comparable[N];
		for (int i = 0; i < N; i++) { sorted[i] = a[i]; }
		
		sort(a, 0, N - 1);
	}
}
