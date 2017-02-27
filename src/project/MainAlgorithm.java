package project;
import java.util.Arrays;
import java.util.Random;

public class MainAlgorithm {

    private int[] arr;

    /*
    The CheckingFunction class is a dummy class, which returns whether the current CPU power
    is sufficient or not. The 'req' data member is the required value which the simulator sets
    either randomly or via input prompt. This is the hypothetical value which would suffice
    the application needs adequately.
    */

    private class CheckingFunction {
        private int req;

        CheckingFunction(int req) {
            this.req = req;
        }

        /*
        If the check method returns true then that implies that the required CPU power is
        more than what current VM can avail.
         */
        boolean check(int index) {
            return req > arr[index];
        }
    }

    private CheckingFunction fn;
    MainAlgorithm(int[] CPUConfig,int req) {
        this.arr = CPUConfig;
        fn = new CheckingFunction(req);
    }

    private int go(int l,int r,int currIndex) {

        //Base case
        if(l == r) return l;

        if(fn.check(currIndex)) {
            //Better CPU config is needed, move to the right.

            int i = 0;
            for(;currIndex+(1<<i) <= r && fn.check(currIndex+(1<<i));i++);

            int upperBound = currIndex+(1<<i);
            int lowerBound = Math.max(currIndex+1,currIndex+(1<<(i-1)));

            if(upperBound > r) return arr.length-1;

            /*
            Here the last parameter is passed as lowerBound for purposes of ease.
            Replacing it with a random index will improve the asymptotic runtime of the algorithm.
             */

            return go(lowerBound,upperBound,lowerBound);
        } else {
            //Current CPU config is either appropriate or exceeds necessary prowess.
            //Move to the left.

            int i = 0;
            for(;currIndex-(1<<i) >= l && !fn.check(currIndex-(1<<i));i++);

            int lowerBound = currIndex-(1<<i);
            int upperBound = currIndex-(1<<(i-1)) < 0 ? currIndex : currIndex-(1<<(i-1));

            if(lowerBound < l) return 0;

            return go(lowerBound+1,upperBound,lowerBound+1);
        }
    }

    public int infer() {
        Random rm = new Random();
        int currIndex = rm.nextInt(arr.length);
        System.out.println("Starting at index "+currIndex);
        int index = go(0,arr.length-1,currIndex);
        return arr[index];
    }
}
