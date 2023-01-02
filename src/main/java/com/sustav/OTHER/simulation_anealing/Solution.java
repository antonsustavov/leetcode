package com.sustav.OTHER.simulation_anealing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

public class Solution {

    static final Random random = new Random();

    public static void main(String[] args) {
        int Tmax = 10;
        int Tmin = -600;
        double Eglob = random.nextDouble();
        double Xopt1 = 0;
        double Xopt2 = 0;
        double x01 = -50 + random.nextDouble() * 350;
        double x02 = -50 + random.nextDouble() * 350;
        double x1 = x01;
        double x2 = x02;
        double T = Tmax;
        double E = func(new X(x1, x2));
//        System.out.println(Eglob);
//        System.out.println(x1 + " " + x2);

        for (int i = 0; i < 1000; i++) {
            if (E < Eglob) {
                Eglob = E;
            }
            double c = -2 + random.nextDouble() * 4;
            x1 = x1 + T * c;
            x2 = x2 + T * c;
            E = func(new X(x1, x2));
            double a = random.nextDouble();
            double dE = func(new X(Xopt1, Xopt2)) - func(new X(x1, x2));
            double h = 1 / (1 + Math.exp(dE / T));
            System.out.println("a: " + a);
            System.out.println("h: " + h);
            System.out.println("dE: " + dE);
            if (a < h) {
                Xopt1 = x1;
                Xopt2 = x2;
                Eglob = E;
                if (i > 0) {
                    T = Tmax / Math.log(1 + i);
                    System.out.println("T: " + T);
                } else {
                    T = Tmax / Math.log(2 + i);
                }
            }
            if (T <= Tmin) {
                break;
            }
        }

        System.out.println("Xopt1: " + Xopt1);
        System.out.println("Xopt2: " + Xopt2);
        System.out.println("f(x): " + func(new X(Xopt1, Xopt2)));
    }

    public static Double func(X xx) {
        return Math.pow(xx.x1 + 2, 4) + 300 * (Math.pow(xx.x2 + 2, 2));
    }
}

@Data
@AllArgsConstructor
class X {
    public double x1;
    public double x2;
}
