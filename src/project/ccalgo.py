import os
from random import randint
class CheckingFunction:
    def check(self,index,arr):
        print('docker run --cpus=\".%d\" ccproject2 /project/driver.sh' % arr[index])
        ans = os.popen('docker run --cpus=\".%d\" rohansumant/ccproject2 /project/driver.sh' % arr[index]).read()
        print(ans)
        return not (ans[0] == '1')
        


class MainAlgorithm:
    def __init__(self,ls):
        self.arr = ls
        self.fn = CheckingFunction()
        
    def infer(self):
        currIndex = randint(0,len(self.arr)-1)
        print('Starting at index %d' % currIndex)
        index = self.go(0,len(self.arr)-1,currIndex)
        if index > len(self.arr): index = len(self.arr)-1
        return self.arr[index]
        
    def go(self,l,r,currIndex):
        if l == r: return l
        if l == r-1: return r
        if self.fn.check(currIndex,self.arr):
            i = 0
            while currIndex+(1<<i) <= r and self.fn.check(currIndex+(1<<i),self.arr):
                i += 1
            upperBound = currIndex+(1<<i)
            if i == 0:
                lowerBound = currIndex
            else: 
                lowerBound = currIndex+(1<<(i-1))
            
            if upperBound > r: upperbound = r
            return self.go(lowerBound+1,upperBound,lowerBound+1)
        else:
            i = 0
            while currIndex-(1<<i) >= l and (not self.fn.check(currIndex-(1<<i),self.arr)):
                i += 1
            lowerBound = currIndex-(1<<i)+1
            if i == 0:
                upperBound = currIndex
            else:
                upperBound = currIndex-(1<<(i-1))
            
            if lowerBound < l: lowerbound = l
            return self.go(lowerBound,upperBound,lowerBound+1)
       

def main():
    algo = MainAlgorithm([10,20,30,40,50,60,70,80,90])
    print('Final config %d' % algo.infer())
    
main()
    

