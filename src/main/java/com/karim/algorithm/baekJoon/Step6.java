package com.karim.algorithm.baekJoon;

/**
 * Created by sblim
 * Date : 2022-01-11
 * Time : 오전 11:47
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * NOTE : 함수
 */
public class Step6 {

    /**
     * NOTE : 정수 N개의 합
     * => 수를 구현해 봅시다. (이 문제는 C, C++, Python, Java, Go만 지원합니다. 그 외의 언어를 사용하신다면 이 문제를 무시해 주세요.)
     */
    public long sum(int[] a){
        long result = 0;
        for (int tmp : a){
            result = result + tmp;
        }
        return result;
    }

    /**
     * NOTE : 셀프 넘버
     * => 함수 d를 정의하여 문제를 해결해 봅시다.
     */
    public void getSelfNumber(){

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = 1;
        List<Integer> pullNum = new ArrayList<>();
        List<Integer> kaprekar = new ArrayList<>();
        while (a<10001){
            pullNum.add(a);
            kaprekar.add(d(a));
            a++;
        }

        pullNum.removeAll(kaprekar);

        try {
            for (int result : pullNum){
                bufferedWriter.write(result + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int d(int a){
        String tmp = String.valueOf(a);
        int tmpSize = tmp.length();
        for (int i=0; i<tmpSize; i++){
            a = a + tmp.charAt(i)-'0';
        }
        return a;
    }

    /**
     * NOTE : 한수
     * => X가 한수인지 판별하는 함수를 정의하여 문제를 해결해 봅시다.
     * NOTE : 한수를 이해하느라 너무 오래 걸렸다..ㅠㅠ
     */
    public void calcHansu(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int input = Integer.parseInt(bufferedReader.readLine());

            bufferedWriter.write(arithmeticSequenceCount(input) + "\n");
            bufferedWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static int arithmeticSequenceCount(int number){
        int count = 0;

        if (number < 100){
            count = number;
        }else {
            count = 99;
            for (int i=100; i<=number; i++){
                String tmp = String.valueOf(i);
                int a = tmp.charAt(0)-'0';
                int b = tmp.charAt(1)-'0';
                int c = tmp.charAt(2)-'0';
                if ((b-a)==(c-b)){
                    count++;
                }
            }
        }
        return count;
    }
}
