package com.timeup.checkout.string;

public class StringReverse {

  /*  public static void main(String args[]){
        StringReverse stringReverse = new StringReverse();
        String str = "Glenn";
        System.out.println("REVERSE::"+ stringReverse.reverse(str));
    }*/

    private static String reverse(String str){
        StringBuilder builder = new StringBuilder();
        for(int i = str.length()-1; i>=0; i--){
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        //Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        //System.out.print("Enter a string: ");
        //String str= sc.nextLine(); //reads string
        //System.out.print("You have entered: "+str);

        String str = "Glenn";
        System.out.println("REVERSE::"+ reverse(str));

        StringReverse solution = new StringReverse();
        solution.isPalidrome("GOOG");
    }

    private String isPalidrome(String value){
        StringBuilder bff = new StringBuilder();
        for(int i = value.length()-1; i>=0; i--){
            bff.append(value.charAt(i));
        }
        if(value.equals(bff.toString())){
            System.out.println("Yes");
            return "Yes";
        }else{
            System.out.println("No");
            return "No";
        }
    }


}
