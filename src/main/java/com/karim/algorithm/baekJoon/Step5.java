package com.karim.algorithm.baekJoon;

/**
 * Created by sblim
 * Date : 2022-01-06
 * Time : 오전 01:06
 */


import java.io.*;
import java.util.*;

/**
 * NOTE : 1차원 배열
 */
public class Step5 {

    /**
     * NOTE : 최솟값과 최댓값을 찾는 문제
     */
    public void getMinMax() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try{
            int count = Integer.parseInt(bufferedReader.readLine());
            int[] inputArray = new int[count];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int i=0; i<count; i++){
                inputArray[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(inputArray);

            bufferedWriter.write(inputArray[0] +" "+ inputArray[count-1]);

            bufferedWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 최댓값이 어디에 있는지 찾는 문제
     */
    public void findMax(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int count = 0;
        try {
            for (int i=0; i<9; i++){
                int a = Integer.parseInt(bufferedReader.readLine());

                if (a > result){
                    result = a;
                    count = i+1;
                }
            }
            bufferedWriter.write(result+"\n");
            bufferedWriter.write(count+"\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 각 숫자가 몇 번 나왔는지 저장하기 위해 일차원 배열을 만드는 문제
     */
    public void countNumber(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int a = Integer.parseInt(bufferedReader.readLine());
            int b = Integer.parseInt(bufferedReader.readLine());
            int c = Integer.parseInt(bufferedReader.readLine());

            String result = String.valueOf(a*b*c);
            for (int i=0; i<10; i++){
                int count=0;
                char charI = (char) i;
                for (int j=0; j<result.length() ; j++){
                    if (result.charAt(j)-'0' == charI){
                        count++;
                    }
                }
                bufferedWriter.write(count + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 위와 비슷한 문제
     */
    public void countNumber2(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> hashSet = new HashSet<>();
        try {
            for (int i=0; i<10; i++){
                int a = Integer.parseInt(bufferedReader.readLine());
                hashSet.add(a%42);
            }
            bufferedWriter.write(hashSet.size() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 평균을 조작하는 문제
     * COMMAND : 나누기 할 땐 double!
     */
    public void calcScore(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        try {
            int count = Integer.parseInt(bufferedReader.readLine());
            int[] input = new int[count];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int i=0; i<count; i++){
                input[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(input);
            double maxScore = input[count-1];
            double b = 0;
            for (int i=0; i<count; i++){
                b = b + ((input[i]/maxScore)*100);
            }
            bufferedWriter.write( b/count + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : OX 퀴즈의 결과를 일차원 배열로 입력받아 점수를 계산하는 문제
     */
    public void OXQuiz(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(bufferedReader.readLine());
            for (int i=0; i<count; i++){
                String input = bufferedReader.readLine();
                int plus=0;
                int score=0;
                int j = 0;
                while (true){
                    if (input.charAt(j) == 'O'){
                        plus++;
                        score = score + plus;
                    }else {
                        plus = 0;
                    }
                    j++;
                    if (j == input.length()){
                        break;
                    }
                }
                bufferedWriter.write( score + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 평균은 넘겠지 => 과연 그럴까요?
     */
    public void getAvg(){
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

