package com.timeup.checkout.dynamicPrg;
import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoizationAlgorithm {

        private Map<Integer, Integer> memoizeTable = new HashMap<>(); // O(1)

        // Fibonacci with Memoization
        /*public int fibonacciMemoize(int n){

            if( n == 0 ) return 0;
            if( n == 1 ) return 1;

            if( this.memoizeTable.containsKey(n) )
            {
                System.out.println("Getting value from computed result for "+n);
                return this.memoizeTable.get(n);
            }

            int result = fibonacciMemoize(n-1)+ fibonacciMemoize(n-2);

            System.out.println("Putting result in cache for "+n);
            this.memoizeTable.put(n, result);

            return result;

        }*/


        public int fibonacciMemoize(int n){
            Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
            if(n == 0) return 0;
            if(n == 1) return 1;
            return getFib(n, resultMap);
        }

        private int getFib(int n, Map<Integer, Integer> resultMap){
            if(resultMap.containsKey(n)){
                return resultMap.get(n);
            }
            int result = (fibonacciMemoize(n-1)+fibonacciMemoize(n-2));
            resultMap.put(n, result);
            return resultMap.get(n);
        }

        //Fibonnaci series GetNthFib Number
        // so for given array index what is the fib number
         /*
            lastTwo[0]::0 lastTwo[1]:1 nextfib= 1
            lastTwo[0]::1 lastTwo[1]:1 nextfib= 2
            lastTwo[0]::1 lastTwo[1]:2 nextfib= 3
            lastTwo[0]::2 lastTwo[1]:3 nextfib= 5
            lastTwo[0]::3 lastTwo[1]:5 nextfib= 8
            lastTwo[0]::5 lastTwo[1]:8 nextfib= 13
         */
        public static int GetNthFib(int n){
            int[] lastTwo = {0,1};
            int counter = 3;
            while(counter <=n){
                System.out.println("lastTwo[0]::"+lastTwo[0]+" lastTwo[1]:"+lastTwo[1]);
                int nextfib = lastTwo[0]+lastTwo[1];
                lastTwo[0] = lastTwo[1];
                lastTwo[1] = nextfib;
                counter++;
            }
            return n > 1 ? lastTwo[1] : lastTwo[0];
        }

        public static void main(String[] args) {

            FibonacciMemoizationAlgorithm fibonacciAlgorithm = new FibonacciMemoizationAlgorithm();
            System.out.println("Fibonacci value for n=8:  "+fibonacciAlgorithm.fibonacciMemoize(8));

            System.out.println("fib value : "+GetNthFib(8)); //13

        }
}
