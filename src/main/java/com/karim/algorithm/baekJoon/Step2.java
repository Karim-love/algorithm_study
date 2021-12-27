package com.karim.algorithm.baekJoon;

import java.util.Scanner;

/**
 * Created by sblim
 * Date : 2021-12-27
 * Time : 오후 3:19
 */
public class Step2 {

    /**
     * NOTE : 두 수 비교하기
     */
    private void compareAB(){
        int a,b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        if (a > b){
            System.out.println(">");
        }else if(a < b) {
            System.out.println("<");
        }else {
            System.out.println("==");
        }
    }

    /**
     * NOTE : 시험 성적
     */
    private void testScore(){
        int a;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();

        if ( a >= 90 ){
            System.out.println("A");
        }else if ( a >= 80){
            System.out.println("B");
        }else if ( a >= 70){
            System.out.println("C");
        }else if ( a >= 60 ){
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }

    /**
     * NOTE : 윤년
     */
    private void leapYear(){
        int a;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();

        int result = a%4 == 0 && a%100 != 0 || a%400 == 0 ? 1 : 0;

        System.out.println(result);
    }

    /**
     * NOTE : 사분면 고르기
     */
    private void pickFour(){
        int x,y;
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();

        if (x > 0 && y > 0){
            System.out.println("1");
        }else if (x > 0 && y < 0){
            System.out.println("4");
        }else if (x < 0 && y < 0){
            System.out.println("3");
        }else {
            System.out.println("2");
        }
    }

    /**
     * NOTE : 알람 시계
     */
    private void alarmClock(){
        int a,b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        b = b - 45;
        if (b < 0){
            b = 60 + b;
            a = a - 1;
            if (a < 0){
                a = 23;
            }
        }

        System.out.println(a + " " + b);
    }
}
