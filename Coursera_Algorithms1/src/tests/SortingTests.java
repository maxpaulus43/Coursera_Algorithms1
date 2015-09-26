package tests;

import java.util.Arrays;

import week2.Shell;
import week3.MergeUp;
import week4.MinBinHeap;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortingTests {
	
	public static void print(Object[] a) {
		StdOut.print("[");
		int n = Math.min(a.length, 20);
		for (int i = 0; i < 20; i++) {
			StdOut.print(" " + a[i] + " ");
		}
		StdOut.print("... ]");
		StdOut.println();
	}

	public static void main(String[] args) {
		int N = 20;
		Integer[] nums1 = new Integer[N];
		Integer[] nums2 = new Integer[N];
		Integer[] nums3 = new Integer[N];
		Integer[] nums4 = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			Integer n = StdRandom.uniform(N);
			nums1[i] = n;
			nums2[i] = n;
			nums3[i] = n;
			nums4[i] = n;
		}
		print(nums1);
		
		try {
			StdOut.println();
			
			Stopwatch sw = new Stopwatch();
			Arrays.sort(nums1);
			StdOut.printf("\nArrays.sort Elapsed time: %f\n", sw.elapsedTime());
			print(nums1);
			
			sw = new Stopwatch();
			Shell.sort(nums2);
			StdOut.printf("\nShell.sort Elapsed time: %f\n", sw.elapsedTime());
			print(nums2);	
			
//			sw = new Stopwatch();
//			MergeUp.sort(nums3);
//			StdOut.printf("\nMerge.sort Elapsed time: %f\n", sw.elapsedTime());
//			print(nums3);
			
			sw = new Stopwatch();
			MinBinHeap.sort(nums4);
			StdOut.printf("\nMaxBinHeap.sort Elapsed time: %f\n", sw.elapsedTime());
			print(nums4);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
