/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private boolean[] status;
    private boolean[] statusd;
    private int openSites;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufd;


    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n cannot be negative: " + n);
        }
        N = n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        ufd = new WeightedQuickUnionUF(n * n + 2);

        status = new boolean[n * n + 2];
        statusd = new boolean[n * n + 2];
        status[0] = true;
        statusd[n * n + 1] = true;
        statusd[0] = true;

    }

    private int getIndex(int x, int y) {
        return (x - 1) * N + y;

    }

    private void opening(int n, boolean[] status, WeightedQuickUnionUF uf, int flag) {

        if (!status[n]) {

            if (((n + 1) % N != 1) && status[n + 1]) {
                uf.union(n + 1, n);
            }
            if (((n - 1) % N != 0) && status[n - 1]) {
                uf.union(n - 1, n);
            }
            switch (flag) {
                case 1:
                    if (!(n + N > N * N) && status[n + N]) {
                        uf.union(n + N, n);
                    }
                    if (n - N < 0) {
                        uf.union(0, n);
                    }
                    else if (status[n - N]) {
                        uf.union(n - N, n);
                    }
                    break;
                case 2:
                    if (n + N > N * N) {
                        uf.union((N * N) + 1, n);
                    }
                    else if (status[n + N]) {
                        uf.union(n + N, n);
                    }
                    if (n - N < 0) {
                        uf.union(0, n);
                    }
                    else if (status[n - N]) {
                        uf.union(n - N, n);
                    }
            }
            status[n] = true;

        }
    }

    public void open(int row, int col) {
        int n = getIndex(row, col);
        if (n < 1 || n > N * N) {
            throw new IllegalArgumentException("site (" + row + "," + col + ") does not exist");
        }
        opening(n, status, uf, 1);
        opening(n, statusd, ufd, 2);
        openSites++;


    }

    public boolean isOpen(int row, int col) {
        int n = getIndex(row, col);
        if (n < 1 || n > N * N) {
            throw new IllegalArgumentException("site (" + row + "," + col + ") does not exist");
        }
        return status[n];
    }

    public boolean isFull(int row, int col) {
        int n = getIndex(row, col);
        if (n < 1 || n > N * N) {
            throw new IllegalArgumentException("site (" + row + "," + col + ") does not exist");
        }
        return uf.find(n) == uf.find(0);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return ufd.find(N * N + 1) == ufd.find(0);
    }
}

