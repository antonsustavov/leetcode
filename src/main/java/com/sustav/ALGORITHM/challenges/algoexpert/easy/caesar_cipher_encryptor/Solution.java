package com.sustav.ALGORITHM.challenges.algoexpert.easy.caesar_cipher_encryptor;

public class Solution {
    public static void main(String[] args) {
        var str = "xyz";
//        var str = "ovmqkwtujqmfkao";
        var key = 2;
        System.out.println(caesarCypherEncryptor(str, key));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder encryptString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int currentSymbol = str.charAt(i) + (key % 26);
            if (currentSymbol > 122) {
                currentSymbol -= 26;
            }

            encryptString.append((char)currentSymbol);
        }

//        System.out.println((int)'x');
        System.out.println((int)'a');
        System.out.println((int)'z');
//        System.out.println(((int)'z' + key) % 25);
//        System.out.println((int)'a' - (int)'z');
//        System.out.println((int)'z' % 25);
//        System.out.println((int)'a' % 25 + (2 + 25));

        return encryptString.toString();
    }
}
