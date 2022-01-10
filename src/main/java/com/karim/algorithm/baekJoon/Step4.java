package com.karim.algorithm.baekJoon;

/**
 * Created by sblim
 * Date : 2022-01-06
 * Time : 오전 01:06
 */


import java.io.*;
import java.util.StringTokenizer;

/**
 * NOTE : while문
 */
public class Step4 {

    /**
     * NOTE : 0 0이 들어올 때까지 A+B를 출력하는 문제
     */
    public void plusAB(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                if (a != 0 && b != 0){
                    bufferedWriter.write(a+b+"\n");

                    bufferedWriter.flush();
                }else {
                    bufferedWriter.close();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * NOTE : 입력이 끝날 때까지 A+B를 출력하는 문제. EOF에 대해 알아 보세요.
     */
    public void plusAB2(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {
            String readAll;

            while((readAll = bufferedReader.readLine()) != null){
                stringTokenizer = new StringTokenizer(readAll, " ");
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                bufferedWriter.write(a+b+"\n");
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 원래 수로 돌아올 때까지 연산을 반복하는 문제
     */
    public void plusCycle(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int a = Integer.parseInt(bufferedReader.readLine());
            int copy = a;
            int cycleCount = 0;
            while (true){
                a = (a % 10)*10 + (((a / 10) + (a % 10)) > 9 ? (((a / 10) + (a % 10)) % 10) : ((a / 10) + (a % 10)));

                cycleCount++;
                if (copy == a){
                    bufferedWriter.write(cycleCount + "\n");
                    break;
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

