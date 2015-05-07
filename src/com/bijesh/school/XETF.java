package com.bijesh.school;

import com.bijesh.school.utility.FastScanner;
import com.bijesh.school.utility.Helper;

/**
 * Created by bijesh on 5/7/2015.
 */
public class XETF extends Helper{

    public static void main(String[] str){
        new XETF().process();
    }

    private void process(){
        int numOfTestCases = getNumberOfTestCases();
        log("Enter two numbers with a space in between them");
        getInputs();
    }

    private void getInputs(){
        FastScanner scanner = new FastScanner();
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();

        log(input1+" "+input2);

    }

}
