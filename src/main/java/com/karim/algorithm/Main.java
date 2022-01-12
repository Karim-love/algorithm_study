package com.karim.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
