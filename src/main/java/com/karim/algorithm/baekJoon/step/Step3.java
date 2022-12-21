package com.karim.algorithm.baekJoon.step;

/**
 * Created by sblim
 * Date : 2021-12-24
 * Time : 오전 11:28
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

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

    /**
     * NOTE : 1부터 N까지 출력하는 문제
     */
    public void printN(){
        int a;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        for (int i=1; i<=a; i++){
            System.out.println(i);
        }
    }

    /**
     * NOTE : 제문 는하력출 지까N 터부1
     */
    public void printNN(){
        int a;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        for (int i=a; i>=1; i--){
            System.out.println(i);
        }
    }

    /**
     * NOTE : A+B를 조금 더 아름답게 출력하는 문제
     */
    public void printPrettyAB(){
        int count, result;
        int a, b;
        Scanner scan = new Scanner(System.in);
        count = scan.nextInt();

        for (int i=1; i<=count; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            result = a+b;
            System.out.println("Case #"+i+": "+ result);
        }
    }

    /**
     * NOTE : A+B를 조금 더 아름답게 출력하는 문제
     */
    public void printUpgradePrettyAB(){
        int count, result;
        int a, b;
        Scanner scan = new Scanner(System.in);
        count = scan.nextInt();

        for (int i=1; i<=count; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            result = a+b;
            System.out.println("Case #"+i+": "+ a+" + "+ b +" = " + result);
        }
    }

    /**
     * NOTE : 별을 찍는 문제 1
     */
    public void printStar(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(bufferedReader.readLine());

            for (int i=1; i<=count; i++){
                for (int j=1; j<=i; j++){
                    bufferedWriter.write("*");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 별을 찍는 문제 2
     */
    public void printStar2(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(bufferedReader.readLine());

            for (int i=1; i<=count; i++){
                for (int k=1; k<=count-i; k++){
                    bufferedWriter.write(" ");
                }
                for (int j=1; j<=i; j++){
                    bufferedWriter.write("*");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : X보다 작은 수
     * COMMAND : StringTokenizer 사용
     */
    public void printUnderX(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            //첫 번째 줄 입력
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int count = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());

            //두 번째 줄 입력
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int i=0; i<count; i++){
                int output = Integer.parseInt(stringTokenizer.nextToken());
                if (output < x){
                    bufferedWriter.write(output+" ");
                }
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

