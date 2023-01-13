package com.karim.algorithm.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Level1_16_30 {

    /**
     * NOTE : 부족한 금액 계산하기
     * COMMAND : 리턴형이 long 인 이유가 있었네;;
     * TIP :
     */
    public long method16(int price, int money, int count) {
        long answer = -1;
        long tmp = 0L;
        Long xLong= (long) price;
        Long yLong= (long) money;

        for ( int i = 1; i <= count; i++ ){

            tmp += xLong * i;
        }

        if ( tmp > yLong ){

            answer = tmp - yLong;
        }else {

            answer = 0;
        }

        return answer;
    }

    /**
     * NOTE : 숫자 문자열과 영단어
     * COMMAND :
     * TIP :
     */
    public int method17(String s) {
        String[] matches = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0 ; i <matches.length; i++) {

            s = s.replaceAll( matches[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

    /**
     * NOTE : 개인정보 수집 유효기간
     * COMMAND :
     * TIP :
     */
    public int[] method18(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar cal = Calendar.getInstance();
        Date dt;
        Date dt2 = null;

        try {

            dt2 = dtFormat.parse( today );
            
            for (String term : terms) {

                String[] a = term.split(" ");
                termsMap.put( a[0], Integer.parseInt( a[1] ));
            }

            for (int i = 1; i <= privacies.length; i++ ) {

                String[] a = privacies[ i - 1 ].split(" ");

                dt = dtFormat.parse( a[0] );
                cal.setTime(dt);
                cal.add(Calendar.DATE,  -1); // 범위가 하루 전
                cal.add(Calendar.MONTH,  termsMap.get( a[1] ) );

                if ( cal.getTime().before( dt2 ) ){ // 범위 초과
                    list.add(i);
                }
            }

            answer = new int[ list.size() ];
            for (int i = 0 ; i < list.size() ; i++) { // 범위 넘은거 보기
                
                answer[i] = list.get(i);
            }

        } catch (ParseException e) {

            throw new RuntimeException(e);
        }

        return answer;
    }

    /**
     * NOTE : 약수의 개수와 덧셈
     * COMMAND : 항상 말하지만 약수 = 제곱근 ( 제곱근이 0이면 홀수 ) 인데 난 왜 항상 이렇게 푸는지
     * TIP :
     */
    public int method19(int left, int right) {
        int answer = 0;

        for ( int i = left; i <= right; i++ ){
            int count = 0;

            for (int j = 1; j <= i; j++) {

                if ( i % j == 0) {

                    count++;
                }
            }

            if( count % 2 == 0 ){ // 갯수가 짝수면 더하고

                answer += i;
            }else { // 홀수면 뺴기

                answer -= i;
            }
        }

        return answer;
    }

    /**
     * NOTE : 로또의 최고 순위와 최저 순위
     * COMMAND :
     * TIP :
     */
    public int[] method20(int[] lottos, int[] win_nums) {
        int[] answer = {};
        return answer;
    }
}