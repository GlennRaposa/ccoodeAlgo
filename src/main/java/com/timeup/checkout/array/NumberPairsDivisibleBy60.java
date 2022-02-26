package com.timeup.checkout.array;

public class NumberPairsDivisibleBy60 {

         /*
          Time Complexity - O(n2)
         */
        public int numPairsDivisibleBy60(int[] time) {
            int count = 0, n = time.length;
            for (int i = 0; i < n; i++) {
                // j starts with i+1 so that i is always to the left of j
                // to avoid repetitive counting
                for (int j = i + 1; j < n; j++) {
                    if ((time[i] + time[j]) % 60 == 0) {
                        count++;
                    }
                }
            }
            return count;
        }


    /*
      Time Complexity - O(n)
     */
    public int numPairsDivisibleBy60_LinerTime(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}
