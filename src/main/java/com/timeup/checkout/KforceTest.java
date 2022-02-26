package com.timeup.checkout;

public class KforceTest {

    public static void main(String args[]){
        KforceTest t = new KforceTest();
        System.out.println("booom------1"+t.addKbeforeFs("Force"));
        System.out.println("booom------2"+t.addKbeforeFs("fluffy"));
        //String text = "force";
        //System.out.println("1--"+text.substring(0, text.indexOf('f')));
        //System.out.println("2--"+text.substring(text.indexOf('f'), text.length()));

    }

   /* String addKbeforeFs(String text){
        return text.substring(0, text.indexOf('f')) + "K" + text.substring(text.indexOf('f'), text.length());
    }*/

    String addKbeforeFs(String text){
        StringBuilder strBuilder = new StringBuilder();
        char[] str = text.toCharArray();
        for (int i = 0; i < str.length; i++){
            if(str[i] == 'f' || str[i] == 'F'){
                strBuilder.append("K").append(str[i]);
            }else{
                strBuilder.append(str[i]);
            }
        }
        return strBuilder.toString();
    }
}
