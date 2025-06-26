import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int T;
    private double[] frOpen;






    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trials must be greater than 0");
        }
        T=trials;
        frOpen=new double[T];
        int randInt;
        int row;
        int col;

        Percolation p;
        for(int i=0;i<T;i++){

            p=new Percolation(n);

            while(!p.percolates()){
                randInt = StdRandom.uniformInt(1, n * n + 1);
                row=(randInt-1)/n+1;
                col=(randInt-1)%n+1;
                if(!p.isOpen(row,col)){
                    p.open(row,col);


                }



            }
            frOpen[i]=p.numberOfOpenSites()/((double)(n*n));
        }


    }

    // sample mean of percolation threshold
    public double mean(){

        return StdStats.mean(frOpen);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){

        return StdStats.stddev(frOpen);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return StdStats.mean(frOpen)-(1.96*StdStats.stddev(frOpen)/(Math.sqrt(T)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return StdStats.mean(frOpen)+(1.96*StdStats.stddev(frOpen)/(Math.sqrt(T)));
    }

    // test client (see below)
    public static void main(String[] args){
        PercolationStats ps=new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        System.out.println("mean"+"                              "+"= "+ps.mean());
        System.out.println("stddev"+"                            "+"= "+ps.stddev());
        System.out.println("95% confidence interval           "+"= ["+ps.confidenceLo()+", "+ps.confidenceHi()+"]");


    }

}
