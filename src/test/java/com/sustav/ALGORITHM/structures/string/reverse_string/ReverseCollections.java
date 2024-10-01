package com.sustav.ALGORITHM.structures.string.reverse_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseCollections {
    public static void main(String[] args) {
        String given = "geeksforgeeks";

        //String Builder
        StringBuilder stringBuilder = new StringBuilder(given);
        stringBuilder.reverse();
        System.out.println("StringBuilder: " + stringBuilder);

        //List
        char[] hello = given.toCharArray();
        List<Character> trial = new ArrayList<>();

        for (char c : hello)
            trial.add(c);

        Collections.reverse(trial);
        System.out.println("List: " + stringBuilder);

        //New String
        char[] ch = given.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        System.out.println("String: " + rev);

    }
}
