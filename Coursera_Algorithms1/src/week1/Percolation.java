/**
 * Max Paulus
 * 09/08/2015
 * 
 * The Percolation class is an implementation of a percolation algorithm. It uses Princeton's 
 * WeightedQuickUnionFind data structure. To use Percolation.java,
 * create a new instance with a given size N (the grid can only be square). 
 */

//package week1;

package week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    /**
     * The size of the n x n grid
     */
    private int n;
    /**
     * The UnionFind data structure used to keep track of connected sites.
     */
    private WeightedQuickUnionUF uf;
    /**
     * The grid holding the open/blocked state of each site
     */
    private byte[][] grid;

    /**
     * Construct a new N x N Percolation object.
     * 
     * @param N
     *            the size of the percolation grid.
     */
    public Percolation(int N) { // create N-by-N grid, with all sites blocked
        if (N <= 0) throw new IllegalArgumentException("N cannot be less than zero");
        this.n = N;
        uf = new WeightedQuickUnionUF((n * n) + 2);
        grid = new byte[n][n];

    }

    /**
     * Open site row i, column j if it is not already open. Also possibly
     * connects site (i, j) to any adjacent open sites.
     * 
     * @param i
     *            specified row
     * @param j
     *            specified column
     * @throws IllegalArgumentException
     *             if i or j is out of bounds
     */
    public void open(int i, int j) {

        if (isOutOfBounds(i - 1, j - 1)) {
            throw new IndexOutOfBoundsException("out of bounds");
        }

        if (isOpen(i, j))
            return;

        grid[i - 1][j - 1] = 1;

        if (i == 1) { // first row
            uf.union(0, idx(i, j));
        }
        if (i == n) { // last row
            uf.union(idx(i, j), (n * n) + 1);
        }

        if (i < n && isOpen(i + 1, j)) { // bottom adjacent
            uf.union(idx(i, j), idx(i + 1, j));
        }
        if (i > 1 && isOpen(i - 1, j)) { // top adjacent
            uf.union(idx(i, j), idx(i - 1, j));
        }
        if (j < n && isOpen(i, j + 1)) { // right adjacent
            uf.union(idx(i, j), idx(i, j + 1));
        }
        if (j > 1 && isOpen(i, j - 1)) { // left adjacent
            uf.union(idx(i, j), idx(i, j - 1));
        }

    }

    /**
     * Checks if the site at location (i, j) is currently open.
     * 
     * @param i
     *            the row
     * @param j
     *            the column
     * @return true if site (i, j) is open
     * @throws IllegalArgumentException
     *             if i or j is out of bounds
     */
    public boolean isOpen(int i, int j) { // is site (row i, column j) open?
        if (isOutOfBounds(i - 1, j - 1)) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        return grid[i - 1][j - 1] == 1;
    }

    /**
     * Checks if the site at location (i, j) is currently connected to the top
     * row.
     * 
     * @param i
     *            the row
     * @param j
     *            the column
     * @return true if site (i, j) is connected to the top row
     * @throws IllegalArgumentException
     *             if i or j is out of bounds
     */
    public boolean isFull(int i, int j) { // is site (row i, column j) full?
        if (isOutOfBounds(i - 1, j - 1)) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        return uf.connected(0, idx(i, j));
    }

    /**
     * Checks if the current percolation grid percolates. That is, the top is
     * connected to the bottom through open sites.
     * 
     * @return true if any site in the top row is connected to any site in the
     *         bottom row
     */
    public boolean percolates() { // does the system percolate?
        return uf.connected(0, (n * n) + 1);
    }

    /**
     * Converts 2-Dimensional array coordinates into a 1-Dimensional array
     * index.
     * 
     * @param i
     *            the row
     * @param j
     *            the column
     * @return the index in a 1-Dimensional array
     */
    private int idx(int i, int j) {
        return ((i - 1) * n + j);
    }

    /**
     * 
     * @param i
     *            the row
     * @param j
     *            the column
     * @return i or j is out of bounds of the grid
     */
    private boolean isOutOfBounds(int i, int j) {
        return (i < 0 || i >= n || j < 0 || j >= n);
    }
}
