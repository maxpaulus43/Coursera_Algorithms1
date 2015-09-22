package week2;

public class Insertion {

	private Insertion() {}
	
	public static void sort(Comparable[] a) throws Exception {
		sort(1, a);
	}
	
	/**
	 * Sorts an array of comparable objects delta indices apart.
	 * @param delta - the stride between each sorted element
	 * @param a - the array to be sorted
	 * @throws Exception if the array is empty
	 */
	public static void sort(int delta, Comparable[] a) throws Exception {
		int N = a.length;
		
		if (N <= 0) throw new Exception("sort: cannot sort array of size 0");
		if (delta >= N) return;
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j >= delta; j -= delta) {
				if (less(a[j], a[j - delta])) {
					swap(a, j, j - delta);
				}
				else break;
			}
		}		
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return (a.compareTo(b) < 0);
	}
	
	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
