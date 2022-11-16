package com.sustav.algoexpert.easy.caesar_cipher_encryptor;

public class Solution {
    public static void main(String[] args) {
        var str = "xyz";
        var key = 2;
        System.out.println(caesarCypherEncryptor(str, key));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder encryptString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int currentSymbol = str.charAt(i) + key;
            encryptString.append((char)currentSymbol);
        }

        System.out.println((int)'x');
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println(((int)'z' + key) % 25);

        return encryptString.toString();
    }
}
