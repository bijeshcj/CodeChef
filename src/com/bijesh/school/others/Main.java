package com.bijesh.school.others;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by mz on 29/06/15.
 */
public class Main {

    public static void main(String[] args) {

        int T = 0;

        long n = 0, q = 0;
        int Q[] = null;
        Scanner scanner = new Scanner(System.in);
        String s = null;
        String cin;

        cin = scanner.nextLine();
        T = Integer.parseInt(cin);

        for (int t = 0; t < T; t++) {
            cin = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(cin);
            n = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            Q = new int[(int) q];

            s = scanner.nextLine();

            for (int i = 0; i < q; i++)
                Q[i] = Integer.parseInt(scanner.nextLine());

            TokensArray liste = new TokensArray(s);
            for (int i = 0; i < q; i++)
                System.out.println(liste.ki(Q[i]));
            System.gc();
        }



        scanner.close();

    }
}

class Token {

    public Token(String value) {
        valueHash = value.hashCode();
        occurances = 1;
    }

    public void increment() {
        occurances++;
    }

    public boolean equals(String s) {
        return s.hashCode() == valueHash;
    }

    public int getOccurences() {
        return occurances;
    }


    private int valueHash;
    private int occurances;

}

class TokensArray {
    public TokensArray(String s) {
        l = new ArrayList();
        String ss;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            ss = new String();
            for (int j = i; j < n; j++) {
                ss += s.charAt(j);
                Token t = seekToken(ss);
                if (t != null)
                    t.increment();
                else
                    l.add(new Token(ss));
            }

        }
    }

    private void addToken(Token t) {
        l.add(t);
    }

    private Token seekToken(String s) {
        int n = l.size();
        for (int i = 0; i < n; i++)
            if (((Token) l.get(i)).equals(s))
                return (Token) l.get(i);
        return null;
    }

    public long ki(int nb) {
        int n = l.size();
        long somme = 0;
        for (int i = 0; i < n; i++) {
            if (((Token) l.get(i)).getOccurences() >= nb)
                somme += anp(((Token) l.get(i)).getOccurences(), nb);
        }
        return somme;
    }

    private long factorielle(int x) {
        if (x == 0)
            return 1;
        return x * factorielle(x - 1);
    }

    private long anp(int n, int p) {
        return factorielle(n) / (factorielle(p) * factorielle(n - p));
    }

    public ArrayList l;
}