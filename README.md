# Random-Sampling-With-A-Reservoir
Code for random sampling without replacement with a reservoir. It randomly choose a sample of k items from a file containing n items. Typically n is large enough that it doesn't fit into the main memory. This algorithm is also suitable for streaming data


## Getting Started

The python and java code are independent from each other and any of them can be used separately.
The java code uses a randomized queue

### Prerequisites
For the python code: python 3.4 or grater

For the java code: java 8 or grater
and the library [algs4.jar](https://algs4.cs.princeton.edu/code/)

### Installing

**Python code:**

Ready to work using your favorite IDE. If you are in the folder containing the code, you can run it using:

```
python reservoirSampling.py k file_name
```


where k is the size of the sample and file_name is the file where you can extract the sample. You must put your
file inside the directory called TestData. If no arguments are provided, default arguments takes place (k = 50
file_name = Moby-Dick.txt). You can also hardcode your file name in the code. To avoid incompatibilities between
OS the pathlib was used to set the path to the files.

**Java code:**

You can build the project using your favorite IDE. You must add the [algs4.jar](https://algs4.cs.princeton.edu/code/) library to your classpath.

To run the code you must provide the size of the sample and the file names as arguments.



## License

Licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* This short project was inspire from the Princeton course [Algorithms I](https://www.coursera.org/learn/algorithms-part1)

