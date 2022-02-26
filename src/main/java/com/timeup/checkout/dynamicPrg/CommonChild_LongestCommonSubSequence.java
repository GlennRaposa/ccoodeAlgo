package com.timeup.checkout.dynamicPrg;
//https://www.youtube.com/watch?v=DuikFLPt8WQ
//https://www.youtube.com/watch?v=ItRZRx8kvwY
/*
                    base condition if i<=0 || j<=0
   LCS (X,Y,i,j) =   case one when Char are same  1+ LCS (X,Y,i-1, j-1) of X[i] == Y[j]
                     case two when CHars are different
                       max  LCS (X,Y,i,j-1)     If X[i] != Y[j]
                            LCS (X,Y,i-1, j)
 */
public class CommonChild_LongestCommonSubSequence {

    public static int LCSM4(char[] X , char[] Y, int m, int n){
     int memo[] = new int[n+1];

     for(int i=1; i<=m; i++){
         int prev= 0;
         for(int j=1; j<=n; j++){
             int temp = memo[j];
             if(X[i-1] == Y[j-1]){
                 memo[j] = prev+1;
             }else{
                 memo[j] = Math.max(memo[j], memo[j-1]);
             }
             prev = temp;
         }
     }
     return memo[n];

    }

    static int commonChild(String s1, String s2){
        return LCSM4(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }
}
