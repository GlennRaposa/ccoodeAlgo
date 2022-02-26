package com.timeup.checkout.array;

import java.util.Arrays;

/*
-----------------------------------------------------
     //1. Problem Statement
     given an array of integers find the sum
-----------------------------------------------------
     //2. Scope
       //2.1 Given
             Read array elements
             no duplicates
             no negatives
             only one data type
             Is sorted
       //2.2 Future scope
          - handle multiple data Types
          - Read array from Database or cache or system file
---------------------------------------------------------
    //3 BU Usecase:

      3.1 - Queries:
             can we get duplicates
             can we get negatives
             do we need to design it to handle multiple data type - have overriding functions that take differnt data types
             Is it always going to be a sorted array

      3.2 - Constraints:
             Scope -
             Time -
             Resource -

      3.3 - Edge-cases:
                are we going to get mixed data types in the array
                do we need to value data type range for int min/max

      3.4 - Assumption:
               for MVP1 one we are going with the current assumption of Given's
                no duplicates
                no negatives
                only one data type
                Is sorted
-----------------------------------------------------
    //4. Error usecases
         Error handling
         if Array is Empty = have NullPointer check
         if Array size is less than 2 = throw IllegalArgumentException

         Failure usecase : what do you do in case of failure - retry, notify, undo(ACID)
-----------------------------------------------------
    //5. Plan - Design, Approach, Sudo Implementation Details
-----------------------------------------------------
    Design1: Iterate -> Read Values
    Approach1: Have two loops - outer loop
    [2,3,4,5] sum=6
    firstIdx=0 firstValue=2 secondIdx=0 secondValue=2 -> 4
    firstIdx=0 firstValue=2 secondIdx=1 secondValue=3 -> 5
    firstIdx=0 firstValue=2 secondIdx=2 secondValue=4 -> 6
        return new int[] {0,2}

    Pro: Straight Forward / Brute force
    Con: if the array is 10K * 10K = 100K compute at runtime

    Implementation Details :
    for(int firstIdx=0; firstIdx<arr.length; firstIdx++){
       for(int secondIdx=0; secondIdx<arr.length; secondIdx++){
         if(arr[firstNum]+arr[secondNum] == target){
            // return new int[]{firstNum,secondNum}
         }
       }
    }
    Time Complexity : O(n2)
    Space Complexity : O(1)
-----------------------------------------------------

    Design2: Read Value in One Pass
    Pro: Reduce Seeks, Compute
    Con: we would be using space(jvm memory,cache,externally)
    Approach2: read once use a data structure value and index pointer
    [2,3,4,5] sum=6
    index=0 idxValue=2 map{(2,0)}
    index=1 idxValue=3 delta(sum-idxValue)=3 --> map(dosent have value) -> map{(2,0)}
    index=2 idxValue=4 delta(sum-idxValue)=2 --> map(does have value) -> map{(2,0)}
        return new int[] {0,2}

    Implementation Details :
    Map<Integer, Integer> numIdxMap = new HashMap<Integer, Integer>
    for(int num=0; num<arr.length; num++){
       //Number that we are paring is save thats goign to be our first number
       //For our second number that adds to be the sum we need to have a variable that stores a differential/delta
       int delta = sum - arr[num]
       if(numIdxMap.containsKey(delta)){
         //In this case we have a first num and a second number that gives us our output
         return new int[]{numIdxMap.get(delta),num}
       }
       numIdxMap.put(arr[num], num)
    }

    Time Complexity : O(n)
    Space Complexity : O(n)
-----------------------------------------------------

    Design3: lets try not to iterate over every index - optimize it further
    Pro: Reduce Seeks, Compute
    Con: have be an ordered set / we can order it before we process it
    Approach3: use index pointer in array to read start and end pointer so we can traverse in either direction
    [2,3,4,5]sum=6

    startIdx=0 startValue=2 endIdx=3 endValue=5 -> 7
       if(greater move indx closer to start endIdx--)
    startIdx=0 startValue=2 endIdx=2 endValue=4 -> 6

    Implementation Details :
    Arrays.sort(arr); // O(nlogn)
    int start = 0;
    int end = arr.length-1
    while(start<end){
      if(arr[start]+arr[end] == sum){
       return new int[] {start, end};
      }else if(arr[start]+arr[end] > sum){
        end --;
      }else if(arr[start]+arr[end] < sum){
        start++
      }
    }

    Time Complexity : O(log n)
    Space Complexity : O(1)
-----------------------------------------------------
**** Be mindful
 - Use Intentional reveling naming - Name class, method and variables mindfully
 - Be consistent in class fuction naming patters (get() versus fetch() / restXX versus webserviceXX)
 - Dont duplicate code -> make common reusabe functions
 - Keep code blocks small and readable
 - A Fuction should do only one thing
 - no nested control Strucutre
 - Less argumets better (more than four args)-> parse an Object if you have a lot of arguments
 - make common util class/function for cross cutting concerns (logging, error handling, http response code, pre-post process filters)
 - Add business usecase and approach intention in Method notes
 - Noise comments are bad, never leave comment Code
 **** code smells and heuristics
 -Dead Code
 -Large classes
 -God object
 -Long if conditions - replace with function
 -Circular dependency
 -Circular references
 -Hard-coding
 -Too much inheritance - composition(HAS-A) is better than inheritance(IS-A)

-----------------------------------------------------
if this is Exposed as an API service

//Versioning - V1, V2 - so clients are not impacted
//Security - OAUTH token
// API Management - gateway (clients call gateway and not the service directly)
   - rate limiting
   - token bucketing
   - api caching




 */
public class TwoSumsV2 {
  public static final String INPUT_DATA_ERROR = "DataValidationError: Input Array is Empty or Less that Two";
 public static void main(String args[]){
     TwoSumsV2 t = new TwoSumsV2();
     int[] arr = null;
     int sum = 6;
     Arrays.stream(t.getsum(arr, sum)).forEach(System.out::println);
 }

    /**
     * Method Take in an Arr or ordered Integers and computes the sum of
     * @param arr
     * @param sum
     * @return
     */
 private int[] getsum(int[] arr, int sum) {
     preConditions(arr);
     int start = 0;
     int end = arr.length - 1;
     while (start < end) {
         if (arr[start] + arr[end] == sum) {
             return new int[]{start, end};
         } else if (arr[start] + arr[end] > sum) {
             end--;
         } else if (arr[start] + arr[end] < sum) {
             start++;
         }
     }
     return new int[]{-1, -1};
 }

 private void preConditions(int[]arr){
     hasValidData(arr);
     //Negative Value check
     //Duplicate Check
 }

 private void hasValidData(int[]arr){
     if(arr == null || arr.length < 2){
         throw new IllegalArgumentException(INPUT_DATA_ERROR);
     }
 }

 private void logUtil(String msg){
     //
 }
}
