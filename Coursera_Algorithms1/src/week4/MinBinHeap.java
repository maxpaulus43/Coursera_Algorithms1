package week4;

import week2.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class MinBinHeap {
	private Comparable[] bh;
	private int size;
	
	public MinBinHeap() {
		bh = new Comparable[10];
		size = 0;
	}
	
	public Comparable pop() {
		Comparable min = bh[1];
		swap(1, size--);
		sink(1);
		bh[size + 1] = null; //prevent loitering
		
		if (size <= bh.length / 4) {
            resize(bh.length / 2);
        }
		
		return min;
	}
	
	public void push(Comparable x) {
		if (size >= bh.length - 1) {
            resize(bh.length * 2);
        }
		
		bh[++size] = x;
		swim(size);
	}
	
	private void sink(int i) {
		while(i <= (size / 2)) {
			
			int child = smallerChild(i);
			
			if (less(child, i)) {
				swap(i, child);
				i = child;
			}
			else break;
		}
	}
	
	private void swim(int i) {
		while (i > 1 && less(i, parent(i))) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	private void resize(int newSize) {
		Comparable[] newBH = new Comparable[newSize];
		for (int i = 0; i <= size; i++) {
			newBH[i] = bh[i];
		}
		bh = newBH;
	}
	
	private int smallerChild(int i) {
		if (bh[rChild(i)] == null) return lChild(i);
		return less(lChild(i), rChild(i)) ? lChild(i) : rChild(i);
	}
	
	private int lChild(int i) {
		return i * 2;
	}
	
	private int rChild(int i) {
		return i * 2 + 1;
		
	}
	
	private int parent(int i) {
		return i / 2;
	}
	
	private boolean less(int i, int j) {
		return bh[i].compareTo(bh[j]) <= 0;
	}
	
	private void swap(int i, int j) {
		Comparable temp = bh[i];
		bh[i] = bh[j];
		bh[j] = temp;
	}
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		if (n <= 0) throw new IllegalArgumentException("sort(): list size <= 0");
		
		MinBinHeap bh = new MinBinHeap();
		for (int i = 0; i < n; i++) {
			bh.push(a[i]);
		}
		for (int i = 0; i < n; i++) {
			a[i] = bh.pop();
		}		
	}
}
