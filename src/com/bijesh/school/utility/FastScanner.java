package com.bijesh.school.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bijesh on 5/7/2015.
 */
public class FastScanner{

    BufferedReader br;
    StringTokenizer st;

    public FastScanner(){
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken(){
        while(st==null||!st.hasMoreElements())
            try{st=new StringTokenizer(br.readLine());}catch(Exception e){e.printStackTrace();}
        return st.nextToken();
    }
    public int nextInt(){return Integer.parseInt(nextToken());}
    public long nextLong(){return Long.parseLong(nextToken());}
    public double nextDouble(){return Double.parseDouble(nextToken());}
}
