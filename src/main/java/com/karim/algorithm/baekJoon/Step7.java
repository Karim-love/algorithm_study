package com.karim.algorithm.baekJoon;

/**
 * Created by sblim
 * Date : 2022-01-11
 * Time : 오후 5:26
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * NOTE : 문자열
 * => 문자열을 다루는 문제들을 해결해 봅시다.
 */
public class Step7 {

    /**
     * NOTE : 아스키 코드
     * => 아스키 코드에 대해 알아보는 문제
     */
    public void getASCII(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = bufferedReader.readLine();

            bufferedWriter.write(input.getBytes(StandardCharsets.US_ASCII)[0] + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 숫자의 합
     * => 정수를 문자열로 입력받는 문제. Python처럼 정수 크기에 제한이 없다면 상관 없으나, 예제 3은 일반적인 정수 자료형에 담기에 너무 크다는 점에 주목합시다.
     */
    public void sumNumbers(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int count = Integer.parseInt(bufferedReader.readLine());
            String numbers = bufferedReader.readLine();
            int tmp = 0;
            for (int i=0; i < count; i++){
                tmp = tmp + numbers.charAt(i)-'0';
            }

            bufferedWriter.write(tmp + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 알파벳 찾기
     * => 한 단어에서 각 알파벳이 처음 등장하는 위치를 찾는 문제
     * NOTE : 중복에서 체크에서 오래 걸렸다!!
     */
    public void findAlphabet(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String words = bufferedReader.readLine();

            List<String> alphabetList = new ArrayList<>();
            for (int i=97; i<123; i++){
                alphabetList.add(Character.toString((char) i));
            }

            for (int i=0; i<alphabetList.size(); i++){
                // 알파벳 중복에 의한 시그널
                boolean firstSignal = true;
                for (int j=0; j<words.length(); j++){
                    if(alphabetList.get(i).equals(words.charAt(j)+"")){
                        // 처음이면 넣기
                        if (firstSignal){
                            bufferedWriter.write(j + (i != alphabetList.size()-1 ? " " : "\n"));
                        } // 위 실행이 되고 처음이 아니게 되니 false 로
                        firstSignal=false;
                    }
                }
                if (!words.contains(alphabetList.get(i))){
                    bufferedWriter.write("-1" + (i != alphabetList.size()-1  ? " " : "\n"));
                }
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 문자열 반복
     * => 각 문자를 반복하여 출력하는 문제
     */
    public void cycleAlphabet(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {
            int count = Integer.parseInt(bufferedReader.readLine());

            for (int i=0; i<count; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                int wordPlusLength = Integer.parseInt(stringTokenizer.nextToken());
                String word = stringTokenizer.nextToken();
                String result = "";

                for (int j=0; j<word.length(); j++){
                    for (int k=0; k<wordPlusLength; k++){
                        result = result + word.charAt(j);
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
     * NOTE : 단어 공부
     * => 주어진 단어에서 가장 많이 사용된 알파벳을 출력하는 문제
     * NOTE : 진짜 어려웠다.. ㅜㅜ 맵 벨류의 정렬과, 소문자를 대문자로 바꾸는거는 구글링했다..
     */
    public void studyWord(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> wordCountMap = new HashMap<>();

        try {
            // .toUpperCase() => 대,소문자 -> 대문자
            String input = bufferedReader.readLine().toUpperCase();

            for (int i=0; i<input.length(); i++){
                // map에 키가 없다면 null 반환
                Integer count = wordCountMap.get(input.charAt(i));
                // map에 키가 있다면 count + 1;
                wordCountMap.put(input.charAt(i), (count==null?1:count+1));
            }

            // value 내림차순으로 정렬
            List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(wordCountMap.entrySet());
            entryList.sort(((o1, o2) -> wordCountMap.get(o2.getKey()) - wordCountMap.get(o1.getKey())));
            // 사이즈가 1 이면 자기꺼 대문자로 그냥 출력
            if (entryList.size()==1){
                System.out.println(entryList.get(0).getKey());
            }else if (entryList.get(0).getValue().equals(entryList.get(1).getValue())){
                // 사이즈 같은게 여러 개 이면 무조건 ?
                System.out.println("?");
            }else {
                // 그렇지 않으면 제일 큰거 하나 출력
                System.out.println(entryList.get(0).getKey());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 단어의 개수
     * => 단어의 개수를 구하는 문제
     */
    public void countWord(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = bufferedReader.readLine();
            String[] a = input.split(" ");

            int count = 0;
            for (String tmp : a){
                if (!tmp.equals("")){
                    count++;
                }
            }
            bufferedWriter.write(count + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 상수
     * => 숫자를 뒤집어서 비교하는 문제
     */
    public void myNameIsSangSu(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            String a = stringTokenizer.nextToken();
            String b = stringTokenizer.nextToken();

            // charAt -> char
            // substring -> String
            // char + char => char number +
            // char + String => String
            a = a.charAt(2) + a.substring(1,2) + a.charAt(0);
            b = b.charAt(2) + b.substring(1,2) + b.charAt(0);

            if (Integer.parseInt(a) > Integer.parseInt(b)){
                bufferedWriter.write(a);
            }else {
                bufferedWriter.write(b);
            }

            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 다이얼
     * => 규칙에 따라 문자에 대응하는 수를 출력하는 문제
     */
    public void getDial(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = bufferedReader.readLine();

            // key는 알파벳 3개 또는 4개 list로 넣기
            // value는 걸리는 초를 넣을꺼임
            Map<List<String>, Integer> dialMap = new HashMap<>();

            int alphabetCount = 97;
            for (int i=2; i<10; i++){
                List<String> list = new ArrayList<>();
                if (i != 7 && i != 9){
                    for (int j=0; j<3; j++){
                        list.add(Character.toString((char) alphabetCount).toUpperCase());
                        alphabetCount++;
                    }
                }else {
                    for (int j=0; j<4; j++){
                        list.add(Character.toString((char) alphabetCount).toUpperCase());
                        alphabetCount++;

                    }
                }
                dialMap.put(list,i+1);
            }

            int result = 0;
            for( Map.Entry<List<String>, Integer> a : dialMap.entrySet()){
                for (int i=0; i<input.length(); i++){
                    if (a.getKey().contains(Character.toString(input.charAt(i)))){
                        result = result + a.getValue();
                    }
                }
            }

            bufferedWriter.write(result + "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 크로아티아 알파벳
     * => 크로아티아 알파벳의 개수를 세는 문제
     */
    public void croatiaAlphabet(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = bufferedReader.readLine();

            List<String> croatiaAlphabetList = new ArrayList<>();
            croatiaAlphabetList.add("c=");
            croatiaAlphabetList.add("c-");
            croatiaAlphabetList.add("dz=");
            croatiaAlphabetList.add("d-");
            croatiaAlphabetList.add("lj");
            croatiaAlphabetList.add("nj");
            croatiaAlphabetList.add("s=");
            croatiaAlphabetList.add("z=");

            for (int i=0; i<croatiaAlphabetList.size(); i++){
                if (input.contains(croatiaAlphabetList.get(i))){
                    input = input.replace(croatiaAlphabetList.get(i), "0");
                }
            }

            bufferedWriter.write(input.length() + "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 그룹 단어 체커
     * => 조건에 맞는 문자열을 찾는 문제
     */
    public void checkGroupWord(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int count = Integer.parseInt(bufferedReader.readLine());

            int groupWordCount = count;
            for (int i=0; i<count; i++){
                String input = bufferedReader.readLine();
                List<Character> groupWordList = new ArrayList<>();
                for (int j=0; j<input.length(); j++){
                    // 그룹에 있는지 확인
                    // 1. 있으면 연속으로 중복되었거나, 연속하지 않게 중복되어있을 경우
                    if (groupWordList.contains(input.charAt(j))){
                        // 중복되었는지 확인
                        // 1. 중복되었으면 괜찬!
                        // 2. 아니면 그룹에서 팽
                        if (!groupWordList.get(j-1).equals(input.charAt(j))){
                            // 팽 당했으므로 전체에서 팽한거 빼고 반복문 나가기 (더이상 볼 것도 없음)
                            groupWordCount--;
                            break;
                        }
                    }
                    groupWordList.add(input.charAt(j));
                }
            }

            bufferedWriter.write(groupWordCount + "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
