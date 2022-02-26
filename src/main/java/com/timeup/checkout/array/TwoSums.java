package com.timeup.checkout.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    /*
     to go fast go slow - spend time planning
     1.what your going to do(map usecases, BU/product considerations) ?
     2.how you going to do it (techinical approach, hosting and deployment approach) ,
     3. what are the constraints your working with (ambiguity, time, cost, resources), what are possiblr mitigations
     that you can put in place to reduce your risk score to increase you favorability for successful outcome
     */
    //TODO : Problem statement
    //Return Sum of Two number equals to 7 and return index of the addition digits

    //TODO : Given requiremnts
    /*
    Given an array of integers and an integer target,
    return indices of the two numbers that add up to the target.
    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.
    You can return the answer in any order.
    */

    /*
     TODO what are your constraints ? do boundary checks ?
     1. are they always intergers ? or we need to factor in floating points as well in the future ?
      1.1 - do we need to check of min/max integer range (MVP2)
     2. are they always positive ? or positive and negative ?
     3. are they going to be ordered ?
     4. can the array contain duplicates ?
     5. do we need multiple sums / or should we break out on the first sum
     */

    /*
       INPUT - OUTPUT
       Input -  a) array of Number b) sum number
       Output - index of two numbers that make the number
     */
    //TODO : Approach
    /*
      * Approach1 : Brute Force Sudo O(n2) - if this array was 100k - your result would be 100K * 100k
      * comparing out loop elements -  to each of the inner loop elements
      *  for(int i=0;i<arr.length;i++){
      *      int firstIndex = arr[i];
      *      for(int j=0;< arr.lenght; j++){
      *         int secondIndex = arr[j];
      *         if(firstIndex+secondIndex == output){
      *           System.out.println("FirstIndex :"+firstIndex+" Second Inndex"+secondIndex)
      *           break;
      *         }
      *      }
      *  }
      *
      * Approach2
      * Have minimum seeks - In enterprise apps(if the array was a database you want to have minimum seeks to optimize time complexity)
      * Know what we processed last - In enterprise apps(optimize computes to reduce recalculating each permuations again - calculate and store)
      *                             - have a cache that stores each compute value
      * Keep Processing to minimum- so if you find first match break (O Log n) - Logrithimic Compute time
      *                            - IF it iterates till the very last numner O(n) - liner time
      * Keep it to one Pass - for optimize solution
      * Read One Index and add it with all the other indexes - Get the sum and see if equals to
      *
      * if we have to loop thru it just once
      * 1 we would need an alternative data structure to store our past moves - that makes it easier for us to lookup a number
      * 2. use a set if we have duplicate numbers - so we dont restore the same value
      * expected result - minus curret number = delta
      * 3. have we already encountered the delta
      * if we use a set we lose the position of the data vale (so we use a map) and can have a dup numer check
      *
      *
      *
     */

     //TODO :  Time and Space Complixity
    /*
     * optimization - connection pool factory(min - max conection pool - so db call are not a bottle neck)
     *
     */

    //TODO : Validations
    /*
    Data Validation at each level - client side, service side
    1. if input array is null - calling client could send you EMPTY array and you fail (add a preconditions class generic error handling)
    2. array size should be greater than 2 - Define a generic error Object (so accross the application
    3. Numbers in array should be in Integer boundary
    4. output number should be non negative
    5. Send back Exception if you dont find any match
    6. Have static error code - (errorcode class - so calling client knows what the error exactly is and can dislpay a guest facing informative error)
    */

    //TODO filters
    //Timeline filter - how long did each call thread takr in the successful execution of the application
    // request - response interception filter (log your request, response)
    //token filter - check if token
    // version - pre processing, post processing filter (data masking filter)

    // TODO considerations - name your variables correctly,keep code blocks small, dont duplicate code,
    //  make common reuasbble functions, make commom libs for cross cutting concers(filters,logging,errorhandling)
    //  keep code clen, well intended,
    //  keep it readable/workable for someone else
    //TODO Error handling
    /*
        1. Define a generic error Object (so across the application you have standard error objects and any client can read them in the same way)
           { //You could handle it multiple way - if its sequence of transactions determine which ones are blockers versus which ones are non-blockers
             //My case - account creation - Creating profile API call -> call to profile service and db entry
             "errors":[
              {
               "errorType": "SEVERE",
               "errorCode":"ARRAY_INPUT_IS_EMPTY",
               "erroeMessage":"Input way empty"
               "httpErrorCode" : "400" //map the error Type the correct error code for the client
              },
              {
               "errorType": "WARN",
               "errorCode":"OUTPUT NUMBER IS ",
               "erroeMessage":"Input way empty"
               "httpErrorCode" : "400" //Marketing system - that send email - log this in an error event queue and try it again.
                                       //Or when the user logs in again prompt him to go accpet MKT options again
              }
             ]
           }

        2. Send back valid error codes
     */
         //TODO Resilence
     /* https://medium.com/capital-one-tech/resiliency-patterns-at-the-edge-capital-one-a5b4d41d477e

      * Client-Side Load Balancing Pattern - With microservice architectures, the client-side load balancing pattern is
      preferred in comparison with server-side load balancing. The reason is because it easily scales, handles updates efficiently,
      and eliminates scenarios such as bottlenecks or single points of failures.
      This pattern includes a discovery service, such as Netflix Eureka or HashiCorp Consul. On startup, a service instance
      registers with the discovery server, publicizing its location. The discovery service will cache the location and health
      status of the service instance. A discovery client will then look up the instances of a particular service from the pool
      of healthy instances.

      * Circut breaker - This pattern prevents a client from continuing to call a service that is failing or experiencing performance issues.
        Software circuit breaker patterns are modeled after electrical circuit breakers

      * Bulk Head Pattern
      Services can use multiple distributed resources in order to display the response to a user request.
      The Bulkhead Pattern compartmentalizes these calls so that poor performance of one service does not negatively impact
      the results of other services, and in the end, the user experience. The Bulkhead Pattern is based on a familiar concept
      implemented in ship designs. Ships are divided into watertight compartments in order to keep water from spreading from
      one compartment to other areas in the ship during a hull breach. Each of these compartments is called a “bulkhead.”
      This way if the ship’s hull is compromised the risk of the ship sinking is reduced.
      Hystrix provides an implementation of the Bulkhead Pattern by limiting the

      * Fallback pattern
       The Fallback Pattern consists of detecting a problem and then executing on an alternative code path.
       This pattern is used when the original code path fails and provides a mechanism that will allow the service
       client to respond through alternative means. Other paths may include static responses, stubbed fallbacks, cached responses, or even alternative services that provide similar information.
      */

    //TODO Logging
    /*
     * Have Descriptive logging to triage problems and issues in production
     * Have standardized logging to see API call Co-relation
     */

    // TODO Security
    /*
        1. Security at each level - client side, service side
        1 : If i was exposing this as an API i need security - secure API Adding OAUTH Token validation
        2. handle API Management - API gateway [Ratelimiting, request bucketing, AUth token max usage]
             Gate request for same authtoken (DDD attack - token bucket 5 try then invalidate token)
             Have API caching if he passes the same request then return result for cache
             IP / Account gating - if your reciveing high volume (1K request in 5sec-30sec) autoblock IP
     */
    // TODO Elastic compute for Horizontal scaling
    /*
       1. My API is gone viral - moved from 100 req a min to 10K request a min -
           Have auto scaling set based on request count
           HAve auto scaling set based on CPU,memory, target resposne time - counts

       2. DB layer - Based on Read and Write count - ON Demand scale DB instances
     */
    //TODO
    /*
     * Guest Facing (B2C) or (B2B)
     * Versioning strategy
     *
     */

    public static void main(String args[]) throws IllegalAccessException {

        //First usease
        //Integer[] arrOfNumbers = {2};
        //int sum = 10;

        //Second usecase
        int[] arrOfNumbers = {5,7,1,2,8,3,4};
        int sum = 8;

        //BIG O - is an equation that expression how the runtime changes, how it scales

        /*
           Approach1 : ----- Brute force -----
            Time complexity - O(n^2) - Quadratic  [n-size of array * 2 [two for loops]]
            Space Complexity - O(1) - constant time [as we are not storing any values in memory]
         */
         /*
         System.out.println("-------------Brute force ----------------");
         printIndexes(bruteforce_TwoSum(arrOfNumbers, sum));
         System.out.println("------------------------------------------");
          */

        /*
            Approach2 : ----- Linear ----
            Time complexity - O(n) - [one pass]
            Space coplexity - O(n) - [use a data struct to store what you have already read]
            we could use saved value + current value to get SUM
         */

          System.out.println("---------------- Linear ----------------");
          Map<Integer, Integer> map = linerTime_TwoSum(arrOfNumbers, sum);
            map.entrySet().stream().forEach(e ->
                    System.out.println("Key : " + e.getKey() + " value : " + e.getValue())
            );
          System.out.println("------------------------------------------");


         /*
            Approach3 : ----- Logarithmic if its an ordered set----
            Time complexity - O(n) - [one pass]
            Space coplexity - O(n) - [use a data struct to store what you have already read]
            we could use saved value + current value to get SUM
         */
        /*System.out.println("------------- Logarithmic ----------------");
        printIndexes(logarithmic_pointer_TwoSum(arrOfNumbers, sum));
        System.out.println("------------------------------------------");*/

    }

    private static void printIndexes(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void precondition(int[] arrOfNumbers){
        if(arrOfNumbers == null || arrOfNumbers.length < 2 ){
            System.out.println("Input array is Empty or Less than 2");
            throw new IllegalArgumentException("Input array is Empty or Less than 2");
        }
        //TODO : Add IntegerMax Range
    }

    private void isInIntRange(int value){
        if (value < Integer.MAX_VALUE && value > Integer.MIN_VALUE){
            throw new IllegalArgumentException("Value out of integer range");
        }
    }

    private static int[]  bruteforce_TwoSum(int[] arrOfNumbers, int sum){
        //Pre condition Check
        precondition(arrOfNumbers);
        //We can loop thru each element in the outer loop and then in the inner loop and
        for(int i = 0; i<arrOfNumbers.length; i++){
            for(int j =0; j<arrOfNumbers.length; j++) {
                if(arrOfNumbers[i]+arrOfNumbers[j] == sum){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static Map<Integer, Integer> linerTime_TwoSum(int[] arrOfNumbers, int sum){
        //Use a Dta structure to store elements you have visited already.
        //Using that tracked number find out the next number
        //I can find out the differential for current number - sum and then see if i have already passed thru the number
        Map<Integer, Integer> numIdxMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> sumOfIndx =  new HashMap<Integer, Integer>();

        for(int i = 0; i<arrOfNumbers.length; i++){
            int delta = sum - arrOfNumbers[i];
            if(numIdxMap.containsKey(delta)){
                sumOfIndx.put(numIdxMap.get(delta), i);
            }
            numIdxMap.put(arrOfNumbers[i], i);
        }
        return sumOfIndx;
    }

  // DOSENT WORK FIGURE THIS OUT
    private static Map<Integer, Integer> divisibleBy_60(int[] arrOfNumbers, int sum){
        //Use a Dta structure to store elements you have visited already.
        //Using that tracked number find out the next number
        //I can find out the differential for current number - sum and then see if i have already passed thru the number
        Map<Integer, Integer> numIdxMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> sumOfIndx =  new HashMap<Integer, Integer>();

        for(int i = 0; i<arrOfNumbers.length; i++){
            int delta = sum - arrOfNumbers[i];
            if(numIdxMap.containsKey(delta)){
                sumOfIndx.put(numIdxMap.get(delta), i);
            }
            numIdxMap.put(arrOfNumbers[i], i);
        }
        return sumOfIndx;
    }

    private static int[] logarithmic_pointer_TwoSum(int[] arr, int sum)
    {
        //1. sort the array O(n logn)
        //2. use two pointer to
        precondition(arr);
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] + arr[end] == sum) {
                System.out.println("First Index : " + start + " Second Index : " + end);
                return new int[]{start,end};
            }else if (arr[start] + arr[end] < sum)
                start++;
            else // A[i] + A[j] > sum
                end--;
        }
        return new int[]{-1,-1};
    }



 /*
 || !(currentIdx > 0 && (arrOfNumbers[currentIdx-1] == arrOfNumbers[currentIdx]))
                        || !(currentIdx < arrOfNumbers.length && arrOfNumbers[currentIdx+1] == arrOfNumbers[currentIdx]
  */
    /*
    //TODO
     1. Iterate thru list
         1.1 if list is null / empty Send Error
         1.2 input array size should be greater than 2
     2. Store result for the last compute
        - Store difference between
        - Substract the difference and store that as Key and index as value
     */

   private static int[] getSumIndex(Integer[] arrOfNumber, int outputNum)throws IllegalAccessException{

       //Check IF Input is null - Use PreConditions for clean implementation
       if(arrOfNumber == null || arrOfNumber.length == 0 || arrOfNumber.length < 2 ){
           System.out.println("Input array is Empty or Less than 2");
           throw new IllegalArgumentException("Input array is Empty or Less than 2");
       }

       Map<Integer, Integer> computeValMap = new HashMap<Integer, Integer>();
       for(int i=0; i<arrOfNumber.length;i++){
           int delta = outputNum - arrOfNumber[i];

           if(computeValMap.containsKey(delta)){
               System.out.println("First Index :"+computeValMap.get(delta)+" Seconds Index :"+i);
               return new int[]{computeValMap.get(delta), i};
           }else{
               computeValMap.put(arrOfNumber[i], i);
           }
       }
       return new int[]{-1,-1};
   }




}
