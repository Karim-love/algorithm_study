package com.karim.algorithm.baekJoon;

/**
 * Created by sblim
 * Date : 2021-12-24
 * Time : 오전 11:28
 */

import java.io.*;
import java.util.Scanner;

/**
 * NOTE : for문
 */
public class Step3 {

    /**
     * NOTE : 구구단을 출력하는 문제
     */
    public void gugudan(){
        int a;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();

        if (a > 1){
            for (int i=1; i<10; i++){
                System.out.println(a + " * " + i +" = " + a*i);
            }
        }
    }

    /**
     * NOTE : A+B를 여러 번 출력하는 문제
     */
    public void testCase(){
        int a,b,c;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();

        for(int i=0; i<a; i++){
            b = scan.nextInt();
            c = scan.nextInt();
            System.out.println(b+c);
        }
    }

    /**
     * NOTE : 1부터 N까지의 합을 구하는 문제. 물론 반복문 없이 풀 수도 있습니다.
     */
    public void arithmeticSequence(){
        int a, result = 0;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();

        for (int i=1; i < a+1; i++){
            result = result + i;
        }
        System.out.println(result);
    }

    /**
     * NOTE : 빠르게 입력받고 출력하는 문제
     * Java를 사용하고 있다면, Scanner와 System.out.println 대신
     * BufferedReader와 BufferedWriter를 사용할 수 있다. BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다
     */
    public void fastTestCase(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            int a = Integer.parseInt(bufferedReader.readLine());

            for (int i=1; i < a+1; i++){
                String b = bufferedReader.readLine();
                int blank = b.indexOf(" ");

                int c = Integer.parseInt(b.substring(0,blank));
                int d = Integer.parseInt(b.substring(blank+1));

                bufferedWriter.write(c+d+"\n");
            }

            bufferedWriter.flush();

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

