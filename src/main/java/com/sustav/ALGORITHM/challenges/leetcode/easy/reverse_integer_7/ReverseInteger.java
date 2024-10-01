package com.sustav.ALGORITHM.challenges.leetcode.easy.reverse_integer_7;

/**
 * @author Anton Sustavov
 * @since 2020/09/15
 */
public class ReverseInteger {

    public static void main(String[] args) {
        final ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(Integer.MIN_VALUE / 10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MAX_VALUE);
        reverseInteger.reverse(Integer.MIN_VALUE / 10);
        reverseInteger.reverse(Integer.MAX_VALUE / 10);
        reverseInteger.reverse(-123);
        reverseInteger.reverse(1534236469);
    }

    public int reverse(int x) {
        int result = 0;
        final StringBuilder stringBuilder = new StringBuilder();
        final String s = String.valueOf(x);
        for (int i = s.length() - 1; i >= 0; i--) {
            final int digit = Character.digit(s.charAt(i), 10);
            if (digit == -1) {
                stringBuilder.insert(0, "-");
            } else {
                stringBuilder.append(digit);
            }
        }
        try {
            result = Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
        }

        return result;
    }

    public int reverse2(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return reversed;

    }

    public int reverse3(int x) {
        long store = x;
        long ans = 0;

        // if x is +ve just reverse it;
        if (x > 0) {
            ans = helper(x, 0);
            if (ans > Integer.MAX_VALUE) store = 0;
            else store = ans;

        } else {

            // if x is -ne make it +ve by mutliplying with -1;
            long positive = x * -1;
            ans = helper(positive, 0);

            // if answer goes out of Integer range, set as 0;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) store = 0;
            else store = -(ans);
        }

        return (int) store;
    }

    private long helper(long n, long rev) {
        // base case;
        if (n == 0) {
            return rev;
        }

        long rem = n % 10;

        return helper (n = n / 10, rev = (rev * 10) + rem);
    }
}
