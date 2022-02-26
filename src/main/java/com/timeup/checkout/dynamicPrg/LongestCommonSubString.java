package com.timeup.checkout.dynamicPrg;

//https://www.youtube.com/watch?v=Lj90FqNCIJE&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&index=6
public class LongestCommonSubString {

    public static void main(String[] args) {
     char X[] = "JAVAID".toCharArray();
     char Y[] = "JAVAAID".toCharArray();
     int m=X.length, n=Y.length, lcsCount=0;

     System.out.println("count1 :"+LCSSubStr_m4(X, Y, X.length, Y.length));
     //System.out.println("count2 :"+LCSSubStr_m1(X, Y, m, n, lcsCount));


    }

    /*
    Best solution
     */
    public static int LCSSubStr_m4(char X[], char Y[], int m, int n){
        int memo[][] = new int[m+1][n+1];
        int result = 0;

        for(int i=0; i <= m ; i++) {
            System.out.println("X :"+X[i]);
            for(int j=0; j <= n; j++) {
                System.out.println("Y :"+Y[i]);
                if (i == 0 || j == 0) {
                    return memo[i][j] = 0;
                }else if (X[i-1] == Y[j-1]){
                    memo[i][j] = memo[i-1][j-1]+1;
                    result = Math.max(result, memo[i][j]);
                    System.out.println("result :"+result);
                }else{
                    memo[i][j]= 0;
                }
            }
        }
        return result;
    }

    public static int LCSSubStr_m1(char X[], char Y[], int m, int n, int lcsCount){
        if(m<=0 || n <=0){
            return lcsCount;
        }
        int lcsCount1 = lcsCount;
        if(X[m-1] == Y[n-1]){
            lcsCount1 = LCSSubStr_m1(X,Y,m-1, n-1, lcsCount+1);
        }

        int lcsCount2 = LCSSubStr_m1(X,Y,m, n-1, 0);
        int lcsCount3 = LCSSubStr_m1(X,Y,m-1, n, 0);

        return Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
    }


}
