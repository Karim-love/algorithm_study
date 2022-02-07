package com.karim.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int input = Integer.parseInt(bufferedReader.readLine());
            int sumResult = 0;
            int line = 0; // 라인수가 될것이다.

            //일단 몇 번째 줄에 있는지 구하기
            for (int i=1; i < input+1; i++){
                sumResult = sumResult + i;
                if (sumResult >= input){
                    line = i;
                    break;
                }
            }

            // 그 열 분수 구하기
            String[] fraction = new String[line];
            // 쩍수면
            if (line%2 == 0){
                for (int i=0; i<line; i++){
                    fraction[i] = (i+1)+"/"+(line-i);
                }
            }else {
                for (int i=0; i<line; i++){
                    fraction[i] = (line-i)+"/"+(i+1);
                }
            }

            // 해당 번 째 구하기
            int pick = input - (sumResult - line) - 1;

            bufferedWriter.write( fraction[pick] + "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
