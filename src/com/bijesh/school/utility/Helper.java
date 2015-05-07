package com.bijesh.school.utility;

/**
 * Created by bijesh on 5/7/2015.
 */
public abstract class Helper {

    public int getNumberOfTestCases(){
        log("Enter number of test cases :");
        FastScanner scanner = new FastScanner();
        return scanner.nextInt();
    }

    public void log(String s){
        System.out.println(s);
    }

}
