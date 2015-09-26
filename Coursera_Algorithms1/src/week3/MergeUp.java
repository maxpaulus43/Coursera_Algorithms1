package week3;

public class MergeUp {

	private static Comparable[] sorted;
	
	private static boolean less (Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void merge (Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int lower = lo;
		int center = mid;
		
		while(lo < center && mid < hi) {
			sorted[i++] = (less(a[lo], a[mid]) ? a[lo++] : a[mid++]);
		}
		while (lo < center) {
			sorted[i++] = a[lo++];
		}
		while(mid < hi) {
			sorted[i++] = a[mid++];
		}
		
		for (int k = lower; k < hi; k++) {
			a[k] = sorted[k];
		}
	}
	
	public static void sort (Comparable[] a) {
		int N = a.length;
		if (N <= 1) return;
		
		sorted = new Comparable[N];
		
		for (int len = 2; len < N; len *= 2) {
			for (int lo = 0; lo < N; lo += len) {
				int hi = Math.min(lo + len, N);
				int mid = (lo + hi) / 2;
				merge(a, lo, mid, hi);
			}
		}
	}
	
}
