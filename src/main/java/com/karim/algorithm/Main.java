package com.karim.algorithm;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            BigDecimal A = new BigDecimal(stringTokenizer.nextToken());
            BigDecimal B = new BigDecimal(stringTokenizer.nextToken());

            bufferedWriter.write( A.add(B) +  "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


