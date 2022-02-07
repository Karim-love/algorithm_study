package com.karim.algorithm.baekJoon;

/**
 * Created by sblim
 * Date : 2022-01-13
 * Time : 오전 10:23
 */

import java.io.*;
import java.util.StringTokenizer;

/**
 * NOTE : 기본 수학 1
 */
public class Step8 {

    /**
     * NOTE : 손익분기점
     * => 이익이 발생하는 지점을 찾는 문제
     * COMMAND : 시간초과 때매 너무 힘들었다....
     */
    public void saleComputer(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            // 가변 비용이 더 많이 들거나 가변비용과 제품가격이 똑같으면 손익분기점이 존재하지 않는다.!
            if ((c < b) || (c == b)) {
                bufferedWriter.write("-1" + "\n");
            }else {
                // a /(c-b) <- 손익분기점보다 작거나 같을 때 넘을 땐 +1!
                bufferedWriter.write(a /(c-b) +1 + "\n");
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 벌집
     * => 벌집이 형성되는 규칙에 따라 벌집의 위치를 구하는 문제
     * COMMAND : tmp 변수는 범위다
     */
    public void beeHouse(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(bufferedReader.readLine());

            int result;
            if (n == 1){
                result = 1;
            }else {
                result = 1;
                int tmp = 1;
                while (true){
                    tmp = tmp + (6 * result);
                    if ( tmp >= n){
                        break;
                    }
                    result++;
                }
                // 1부터 세니깐 1를 더해주자!
                result++;
            }
            bufferedWriter.write(result + "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 	분수찾기
     * => 벌분수의 순서에서 규칙을 찾는 문제
     * COMMAND :
     */
    public void findRule(){

    }
}
