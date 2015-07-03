package com.bijesh.school.easy;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bijesh on 03-07-2015.
 */
 class ChefAndString {


    public static void main(String[] str){
        new ChefAndString().process();
    }



    private void processEngine(int N,int Q,String S,int[] qs){
        List<String> stringAsSubStrings = getList(S);
        log("Substring at the end "+stringAsSubStrings);

        Collections.sort(stringAsSubStrings);

        log("after sort "+stringAsSubStrings);

        List<Integer> equalList = findEqualsStrings(stringAsSubStrings,qs);

        log("result "+equalList);


    }

    private List<Integer> findEqualsStrings(List<String> sortedStrings, int[] qs){
        List<Integer> returnList = new ArrayList<Integer>();
        Map<String,Integer> maps = findOccurance(sortedStrings);//new HashMap<String, Integer>();
        log("maps is "+maps);
        for (int i = 0; i < qs.length;i++){
            int temp = 0;
            int occurance = qs[i];
            Set<String> sets = maps.keySet();
            Iterator<String> iter = sets.iterator();
            while (iter.hasNext()){
                String k = iter.next();
                int value = maps.get(k);
                if(value > occurance){
                    temp += value;
                }else if(value == occurance)
                    temp = temp + 1;
            }
            returnList.add(temp);
        }


        return returnList;
    }

    private Map<String,Integer> findOccurance(List<String> sorted){
        Map<String,Integer> maps = new HashMap<String, Integer>();
        for(int i=0;i<sorted.size();i++){
            String key = sorted.get(i);
            int value = 0;
            for (int j=0;j<sorted.size();j++){
                if(sorted.get(j).equals(key))
                    value++;
            }
            maps.put(key,value);
        }
        return maps;
    }



    private ArrayList<String> getList(String S){
        ArrayList<String> stringAsSubStrings = new ArrayList<String>();
        int subStringValue=0;
        int len = S.length();
        for(int i=0;i<len;i++){
            if(subStringValue == S.length()){
                stringAsSubStrings.add(S);
                break;
            }
            subStringValue = subStringValue + (i+1);
            for (int j =0;j<len;j++) {
                if(subStringValue > len)
                    break;
                String temp = S.substring(j,subStringValue++);
                stringAsSubStrings.add(temp);
            }
            subStringValue = 0;
        }
        return stringAsSubStrings;
    }



    private void process(){

//        input block
        int T = getNumberOfTestCases();
        log("Enter two space-separated integers for N and Q");
        int[] inputs = getInputs();
        int N = inputs[0];
        int Q = inputs[1];

        log("Enter the string which should match the length of the N which you gave input previously");
        String S = getS();
        log("input "+Q+" questions");
        int[] qs = new int[Q];
        log("question as int ");
        for(int i=0;i<Q;i++){
            qs[i] = getI();
        }
        processEngine(N,Q,S,qs);

    }

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


    static  class FastScanner{

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


}
