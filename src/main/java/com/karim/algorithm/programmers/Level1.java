package com.karim.algorithm.programmers;

import java.util.*;

public class Level1 {

    /**
     * NOTE : 크기가 작은 부분문자열
     * COMMAND : Integer.parseInt 는 런타임 에러나는데 Long.parseLong 이건 왜 안날까..
     */
    private int method1( String t, String p ){
        int answer = 0;
        t = "10203";
        p = "15";
        long pp = Long.parseLong(p);
        int pSize = p.length();

        for ( int i = 0; i <= t.length() - pSize; i++ ) {

            if (Long.parseLong(t.substring(i, i + pSize )) <= pp) {

                answer++;
            }
        }

        return answer;
    }

    /**
     * NOTE : 가장 가까운 같은 글자
     * COMMAND :
     */
    private int[] method2( String s ){
        s = "banana";

        String[] arr = new String[ s.length() ];
        int[] answer = new int[ s.length() ];

        for ( int i = 0; i < s.length(); i++) {

            String find = String.valueOf(s.charAt(i));

            if ( !Arrays.asList(arr).contains( find ) ){ // 없으면 -1

                answer[i] = -1;
                arr[i] = find;
            }else {

                int findCount = Arrays.asList( arr ).lastIndexOf( find );
                answer[i] = i - findCount;
                arr[i] = find;
            }
        }

        return answer;
    }

    /**
     * NOTE : 문자열 나누기
     * COMMAND :
     */
    public int method3( String s ){
        int answer = 0;

        char first = s.charAt(0);
        int countA = 0;
        int countB = 0;
        for ( int i = 0 ; i <  s.length(); i++ ){

            // 현재 값이랑 해당 값이 같은 경우 (처음은 무조건 같음)
            if ( first == s.charAt(i) ){

                countA ++; // 현재 값 카운트 ++
            }else {

                countB++; // 다른 경우우
            }

            // 현재 값 카운트 값이랑 다음 단어 카운트 값이 같거나 마지막이면 ++
            if ( countA == countB || i == s.length() -1 ){

                answer++;
                countA = 0;
                countB = 0; //초기화

                if ( i != s.length() -1 ){ // 해당 인덱스가 마지막이 아니면
                    first = s.charAt(i+1); // 비교 값을 해당 i 값으로 바꾼다
                }
            }
        }

        return answer;
    }

    /**
     * NOTE : 명예의 전당 (1)
     * COMMAND :
     */
    public int[] method4( int k, int[] score ) {

        int scoreLength = score.length;
        int[] answer = new int[ scoreLength ];
        List<Integer> room = new ArrayList<>();

        for( int i = 0; i< scoreLength; i++ ){

            room.add( score[i] );
            Collections.sort( room ); //정렬

            if ( k <= i ){

                room.remove(0);
            }

            answer[i] = room.get(0);
        }

        return answer;
    }

    /**
     * NOTE : 기사단원의 무기
     * COMMAND : 시간 초과가 제일 무섭다...
     * TIP : Math.sqrt( n ) n의 제곱근 ex ) Math.sqrt( 25 ) = 5
     * TIP : 약수는 제곱근을 제외한 나머지는 대칭을 이룬다! ( 시간 초과를 위해 외워두자 )
     */
    public int method5( int number, int limit, int power ) {

        int answer = 0;

        for ( int i = 1; i <= number ; i++ ){

            int count = 0;
            for ( int j = 1; j <= Math.sqrt( i ) ; j++ ){ // 제곱근

                if ( i % j == 0 ){ // 약수 이면

                    if ( i / j == j ){ // 해당 값의 제곱근 이면 한번만 카운트

                        count++;
                    }else { //

                        count+=2;
                    }
                }
            }

            if ( count > limit ){ // 제한수치를 넘을 경우 정한 공격력으로 더하기

                answer += power;
            }else {

                answer += count; // 아닐경우 그냥 더하기
            }
        }

        return answer;

    }

    /**
     * NOTE : 과일 장수
     * COMMAND : 문제 이해가 어려웠당
     * TIP :
     */
    public int method6( int k, int m, int[] score ) {

        int answer = 0;

        // 내림 차순 정렬
        Integer[] reverseScore = Arrays.stream( score ).boxed().toArray(Integer[]::new);
        Arrays.sort( reverseScore, Collections.reverseOrder() );

        for ( int i = m-1; i < reverseScore.length; i+=m ) { // 한 상자에 담긴 사과 개수 만큼 증가

            if (reverseScore[i] > k) { // 만약 점수가 최대 점수 k 보다 크면 k로 바꿔준다.

                reverseScore[i] = k;
            }

            // 최저 점수 * 한 상자에 담긴 사과 개수
            answer += ( reverseScore[i] * m );
        }

        return answer;
    }

    /**
     * NOTE : 푸드 파이트 대회
     * COMMAND :
     * TIP :
     */
    public String method7( int[] food ) {
        String answer = "";

        Deque<Integer> deque = new ArrayDeque<>();

        // 처음에 물을 넣는다
        deque.add( 0 );

        for ( int i = food.length -1 ; i > 0; i-- ){ // 작은 숫자 부터 먹을려면, 큰 숫자 부터 넣어야 하니깐 배열 크기 부터

            // 몫 값으로 넣는다 ( 나머지는 버려질 음식, 0 이면 넣지 않는다.)
            for ( int j = 0; j < food[i] / 2; j++ ) { // 나눈 갯수 만큼 넣기

                deque.addFirst( i );
                deque.addLast( i );
            }
        }

        for (Integer integer : deque) {

            answer += integer;
        }

        return answer;
    }

    /**
     * NOTE : 푸드 햄버거 만들기 대회
     * COMMAND :
     * TIP :
     */
    public int method8( int[] ingredient ) {
        int answer = 0;
        return answer;
    }
}
