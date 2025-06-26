# percolation
This is an INtellij Idea project. Remember to use -cp to include the algs4.jar file in the class path or include it using some other method.
This was an assignment of the second lecture of "Algorithms, Part1 Princeton University" course available on coursera.We were required to use weighted quick union datatype to model the percolation problem.
We have an  n by n grid with its sites  either open or blocked. A acontinuous chain of open sites from the top of the grid to the bottom means the system percolates. The problem is  if sites are independently set to be open with probability p (and therefore blocked with probability 1 − p), what is the probability that the system percolates? For large values of n it turns out there exists a sharp probability p* such that when p<p* the system almost never percolates and if p>p* the system percolates almost everytime. Our task is to find that probability

The percolation class gives method to initialize a grid ,open a blocked site, tell if the system percolates among other useful methods. The percolationStats give methods to run trials to determine the value of p*.

Classes PercolationVisualizer and Interactive PercolationVisualizer were provided by the instructors .The test-materials contain files and corresponding images that should be generated when you run the PercoalationVisualizer class with the file as a command line  argument. The InteractivePercolationVisualizer class lets you open sites interactively you just have to pass the size of the grid as a command line argument
