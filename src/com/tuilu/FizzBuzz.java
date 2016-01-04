package com.tuilu;

/**
 * Created by Administrator on 2015/12/29.
 */
public class FizzBuzz {
    private void arrayN(int n){
        for(int i=0;i<n;i++){
            System.out.println(outprint(i+1));
        }
    }
    private String outprint(int n){
        String result;
        if(n%3==0&&n%5==0){
            result = "Fizz Buzz";
        }else if(n%3==0){
            result = "Fizz";
        }else if(n%5==0){
            result = "Buzz";
        }else{
            result = String.valueOf(n);
        }
        return result;
    }
}
