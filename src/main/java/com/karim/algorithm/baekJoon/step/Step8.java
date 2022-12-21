package com.karim.algorithm.baekJoon.step;

/**
 * Created by sblim
 * Date : 2022-01-13
 * Time : 오전 10:23
 */

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
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
     * NOTE : 분수찾기
     * => 벌분수의 순서에서 규칙을 찾는 문제
     * COMMAND : 너무 어려워 ㅜㅜ
     */
    public void findRule(){
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

    /**
     * NOTE : 달팽이는 올라가고 싶다
     * => 달팽이의 움직임을 계산하는 문제
     * COMMAND : 마지막에 도달할 때의 down 의 길이를 뺀다.
     */
    public void upSnail(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int morningUp = Integer.parseInt(stringTokenizer.nextToken());
            int nightDown = Integer.parseInt(stringTokenizer.nextToken());
            int totalLength = Integer.parseInt(stringTokenizer.nextToken());

            int  dDay = (totalLength - nightDown)  / ( morningUp - nightDown) ;

            // 하루가 더 남아있다면
            if ( (totalLength - nightDown) % ( morningUp - nightDown) != 0 ){
                dDay = (totalLength - nightDown) / ( morningUp - nightDown) + 1 ;
            }

            bufferedWriter.write(dDay + "\n");

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : ACM 호텔
     * => 호텔 방 번호의 규칙을 찾아 출력하는 문제
     * COMMAND : 중간 0 때문에 오래 걸렸다...
     */
    public void ACMHotel(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {
            int testCase = Integer.parseInt(bufferedReader.readLine());

            for (int i=0; i<testCase; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                int height = Integer.parseInt(stringTokenizer.nextToken());
                int width = Integer.parseInt(stringTokenizer.nextToken());
                int count = Integer.parseInt(stringTokenizer.nextToken());

                String result ="";
                int zeroLength;

                // 첫 번째 줄에 있을 경우!
                if (height >= count){
                    result = count + "01";
                }else { // 줄 넘어가는 경우!
                    int heightCount;

                    // 맨 끝일 때 (맨 위)
                    if ( count % height == 0){
                        zeroLength = String.valueOf(((count / height))).length();

                        if (zeroLength >= 2){
                            result = height +""+ (count / height);
                        } else {
                            result = height + "0" + (count / height);
                        }
                    }else {
                        zeroLength = String.valueOf(((count / height)+1)).length();
                        heightCount = count % height ;

                        if (zeroLength >= 2){
                            result = heightCount +""+ ((count / height)+1);
                        } else {
                            result = heightCount + "0" + ((count / height)+1);
                        }
                    }
                }

                bufferedWriter.write(result + "\n");
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 부녀회장이 될테야
     * => 층과 거주자 수의 규칙을 찾는 문제
     * COMMAND : 문제 이해가 어려웠다... 나는 문제 이해부터 잘 해야겠다....
     */
    public void getApartmentLeader(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int testCase = Integer.parseInt(bufferedReader.readLine());

            for (int count=0; count<testCase; count++){
                int floors = Integer.parseInt(bufferedReader.readLine()); //층
                int number = Integer.parseInt(bufferedReader.readLine()); //호

                Map<Integer,int[]> sumMap = new HashMap<>();

                for(int i=0; i<=floors; i++){
                    if (i == 0){ // 0층에 미리 1,2,3,... 깔기
                        int[] countArray = new int[number];
                        for (int j=0; j<number; j++){
                            countArray[j] = j+1;
                        }
                        sumMap.put(i, countArray);
                    }else { // 1층 부터
                        int[] countArray = new int[number];
                        for (int j=0; j<number; j++){
                            if (j==0){  //아래층 1호는 무조건 1
                                countArray[0] = 1;
                            }else { //아래층 1호부터 number 호까지 더하기
                                countArray[j] = countArray[j-1] + sumMap.get(i-1)[j];
                            }
                        }
                        sumMap.put(i, countArray);
                    }
                }
                bufferedWriter.write( sumMap.get(floors)[number-1] + "\n");
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 설탕 배달
     * => 5와 3을 최소 횟수로 합하여 N을 만드는 문제
     * COMMAND : 와.. 어려운데?ㅠ
     */
    public void sugarDelivery(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int kilogram = Integer.parseInt(bufferedReader.readLine());
            int count = 0;

            // 5로 떨어지면 럭키
            if (kilogram % 5 != 0){
                int x = 1; // 3개수
                while (true){
                    // 반복문 돌면서 3씩 빼서 5 나머지가 0이면 럭키
                    if ((kilogram - (3 * x) ) % 5 == 0){
                        // 카운트 구하기
                        count = (kilogram - (3 * x) ) / 5 + x;
                        break;
                    } else if ((kilogram - (3 * x) < 0)){
                        //만약 3씩 빼는데 결국 못 찾고 마이너스가 되면 없는거임
                        count = -1;
                        break;
                    }
                    x++;
                }
            }else {
                count = kilogram / 5;
            }

            bufferedWriter.write(count + "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 큰 수 A+B
     * COMMAND : 큰 수 사칙연산은 'BigDecimal' or 'BigInteger'
     */
    public void addBigAB(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            BigInteger A = new BigInteger(stringTokenizer.nextToken());
            BigInteger B = new BigInteger(stringTokenizer.nextToken());

            bufferedWriter.write( A.add(B) +  "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : Fly me to the Alpha Centauri
     * COMMAND : 거리에 따른 장치 사용 횟수를 출력하는 문제
     */
}
