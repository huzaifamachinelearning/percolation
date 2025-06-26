# percolation
This was an assignment of the second lecture of "Algorithms, Part1 Princeton University" course available on coursera.We were required to use weighted quick union datatype to model the percolation problem.
Given an n by n grid where sites are either open or blocked and a continuous chain of open sites from the top of the grid to the bottom means the system percolates. The problem is  if sites are independently set to be open with probability p (and therefore blocked with probability 1 − p), what is the probability that the system percolates? For large values of n it turns out there exists a sharp probability p* such that when p<p* the system almost never percolates and if p>p* the system percolates almost everytime. Our task is to find that probability

The percolation class gives method to initialize a grid ,open a blocked site tell if the system percolates among others The percolationstats give methods to run trials to determine the value of p*.

Classes other than these two were provided by the instructors themselves.  
