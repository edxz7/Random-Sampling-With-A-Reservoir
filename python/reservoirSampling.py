import random
import sys
from pathlib import Path            # support since python 3.4 

#*****************************************************************************
#  Execution:    python reservoirSampling.py size file_name
#  Dependencies: pathlib, sys
#
#  Random sampling using a reservoir implemented using a randomized Queue
#
#  Complexity: O(k) where k is the size of the sample
#
#  @author Eduardo Ch Colorado
#******************************************************************************/

class reservoirSampling(object):
    def __init__(self, max_size):
        self.samples = []           # list to store the sample
        self.max_size = max_size    # size of the reservoir
        self.i = 0

    def read_file(self, file):
        f = open(file)
        for line in f:
            for el in line.split():
                yield el
        
    def sampling(self, element):
        size = len(self.samples)
        if(size >= self.max_size):
            idx = random.randint(0,self.i-1)
            if idx < size:
                self.samples[idx] = element
        else:
            self.samples.append(element)
        self.i += 1

def main():
    # file_path is a path object, '/' overloads append
    try:
        k         = int(sys.argv[1])         # size of the sample  
        file_name = sys.argv[2]              # file name
        path      = Path(__file__).resolve().parents[1]
        file_path = path / 'TestData' / file_name
    except:
        k         = 50                        # default sample size
        file_name = 'Moby-Dick.txt'           # defaul file
        path      = Path(__file__).parents[1]
        file_path = path / 'TestData' / file_name
     
    #set the size of the reservoir
    reservoir = reservoirSampling(k)                                                              
    source = reservoir.read_file(file_path)
    for el in source:
        # if(el.isalpha):            # case sensitive conditioning
        reservoir.sampling(el)
    print(reservoir.samples)

if __name__ == '__main__':
    main()