package org.example;

import java.util.Arrays;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        String[] scores = new String[]{ "1", "W", "2", ".", "1", "N", "4", "4", "6" };
        String[] scores = new String[]{ "1", "W", "2", ".", "1", "N", "4", "4", "6" };

        HashMap<String, Integer> scoreMap = new HashMap<>();
        for(String score : scores){
            if(scoreMap.containsKey(score)){
                Integer val = scoreMap.get(score);
                val = val + 1;
                scoreMap.put(score, val);
            } else {
                scoreMap.put(score, 1);
            }
        }
        System.out.println(Arrays.toString(scores));
        System.out.println(scoreMap);

    }
}