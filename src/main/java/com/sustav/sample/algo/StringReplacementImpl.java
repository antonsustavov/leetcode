package com.sustav.sample.algo;

import java.util.List;

public class StringReplacementImpl implements StringReplacement {
    private final static int TOKEN_LENGTH = 2;
    private final static List<Rule> RULES = List.of(new Rule.ABIndexRule(), new Rule.CDIndexRule());

    @Override
    public String replace(String text) {
        if (text == null || text.isBlank()) {
            return text;
        }

        var builder = new StringBuilder();

        for (var i = 0; i < text.length(); i++) {
            builder.append(text.charAt(i));

            for (var rule : RULES) {
                if (builder.length() >= TOKEN_LENGTH) {
                    if (rule.match(builder.charAt(builder.length() - 2), builder.charAt(builder.length() - 1))) {
                        builder.delete(builder.length() - TOKEN_LENGTH, builder.length());
                        break;
                    }
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        StringReplacementImpl stringReplacement = new StringReplacementImpl();
        System.out.println(stringReplacement.replace("AACADC"));
    }
}
