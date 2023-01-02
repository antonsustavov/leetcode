package com.sustav.ALGORITHM.challenges.beecrowd.beginner.level6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Solution {
    private static final List<Integer> NOTAS = List.of(100, 50, 20, 10, 5, 2);
    private static final List<Double> MOEDAS = List.of(1., 0.50, 0.25, 0.10, 0.05, 0.01);

    public static void main(String[] args) {
//        banknotes(576.73);
        banknotes(91.01);
    }

    public static void banknotes(Double input) {
//        var scanner = new Scanner(System.in);
//        Double input = scanner.nextDouble();
        if (input < 0 || input > 1000000.) throw new IllegalArgumentException("Should be 0 < n < 1000000.00");
        Integer balanceNotas = input.intValue();
        Double balanceMoedas =  input - input.intValue();
        System.out.println("NOTAS:");
        for (int i = 0; i < NOTAS.size(); i++) {
            var vs = balanceNotas / NOTAS.get(i);
            balanceNotas = balanceNotas - vs * NOTAS.get(i);
            System.out.println(vs + " nota(s) de R$ " + NOTAS.get(i) + ".00");
        }
        balanceMoedas += balanceNotas;
        double v = new BigDecimal(balanceMoedas).setScale(2, RoundingMode.HALF_UP).doubleValue();
        balanceMoedas = v * 100;
        System.out.println("MOEDAS:");
        for (int i = 0; i < MOEDAS.size(); i++) {
            double v1 = MOEDAS.get(i) * 100;
            if (v1 <=  balanceMoedas) {
                Double vs = balanceMoedas / v1;
                balanceMoedas = balanceMoedas - v1 * vs.intValue();
                System.out.println(vs.intValue() + " moeda(s) de R$ " + MOEDAS.get(i));
            } else {
                System.out.println(0 + " moeda(s) de R$ " + MOEDAS.get(i));
            }
        }
    }
}
