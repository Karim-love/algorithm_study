package com.karim.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        try {
            int count = Integer.parseInt(bufferedReader.readLine());
            for (int i=0; i<count; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                double plusScore=0;
                List<Double> score = new ArrayList<Double>();

                int deepCount = Integer.parseInt(stringTokenizer.nextToken());
                for (int j=0; j<deepCount; j++){
                    double tmp = Double.parseDouble(stringTokenizer.nextToken());
                    score.add(tmp);
                    plusScore = plusScore + tmp;
                }

                double deepAvg = 0;
                for (double a : score){
                    if (a > (plusScore/deepCount)){
                        deepAvg++;
                    }
                }

                bufferedWriter.write( String.format("%.3f", deepAvg/deepCount * 100) +"%"+ "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
