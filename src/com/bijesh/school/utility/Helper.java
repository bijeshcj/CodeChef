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


    public int[] getInputs(){
        FastScanner scanner = new FastScanner();
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();

        log(input1+" "+input2);
        return new int[]{input1,input2};
    }

    public String getS(){
        FastScanner fastScanner = new FastScanner();
        return fastScanner.nextToken();
    }

    public int getI(){
        FastScanner fastScanner = new FastScanner();
        return fastScanner.nextInt();
    }

    public void log(String s){
        System.out.println(s);
    }

}
