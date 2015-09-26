package week2;

import java.util.Arrays;

import week3.MergeUp;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Shell { 
	
	private Shell() {}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) throws Exception {
		int N = a.length;
		
		int delta = 1;
		while (delta < N/3) {
			delta = 3 * delta + 1; //1, 4, 13, 40, 121, ...
		}
		
		while (delta >= 1) {
			Insertion.sort(delta, a);
			delta /= 3;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
