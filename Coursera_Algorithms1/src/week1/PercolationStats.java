package week1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int t;
    private double[] percThresholds;

    public PercolationStats(int N, int T) { // perform T independent experiments
                                            // // on an N-by-N grid
        
        if (N <= 0 || T <= 0) throw new IllegalArgumentException("N and T cannot be less than zero");
        this.t = T;
        percThresholds = new double[T];
        int idx = 0;

        for (int k = 0; k < t; k++) {
            Percolation p = new Percolation(N);
            double count = 0.0;
            while (!(p.percolates())) {
                int i = (int) (StdRandom.uniform() * N) + 1, j = (int) (StdRandom
                        .uniform() * N) + 1;
                if (!p.isOpen(i, j)) {
                    p.open(i, j);
                    count++;
                }
            }
            // System.out.println(count / (N*N));
            percThresholds[idx++] = count / (N * N);

        }
    }

    public double mean() { // sample mean of percolation threshold
        return StdStats.mean(percThresholds);
    }

    public double stddev() { // sample standard deviation of percolation
                             // thresholds
        return StdStats.stddev(percThresholds);
    }

    public double confidenceLo() { // low endpoint of 95% confidence interval
        return 0;
    }

    public double confidenceHi() { // high endpoint of 95% confidence interval
        return 0;
    }

    public static void main(String[] args) { // test client

        if (args.length < 1) {
            System.out
                    .println("usage: PercolationStats <grid_size> <iterations>");
        } else {
            try {
                PercolationStats ps = new PercolationStats(
                        Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                System.out.printf("mean =   %f%n", ps.mean());
                System.out.printf("stddev = %f%n", ps.stddev());
            } catch (NumberFormatException e) {
                System.out.println("Arguments must be integers.");
            }
        }
    }
}
