package com.sustav.OTHER.trilateration;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class LocationService {

    public static void main(String[] args) {
        Ponto A = new Ponto(0., 0.);
        Ponto B = new Ponto(0., 17.);
        Ponto C = new Ponto(22., 0.);
        double distance1 = 17.;
        double distance2 = 17.49285;
        double distance3 = 10.63014;
        System.out.println(getLocationByTrilateration(A, distance1, B, distance2, C, distance3));
        System.out.println(getLocationByTrilateration2(A, distance1, B, distance2, C, distance3));
        System.out.println(getLocationByTrilateration3());

        Ponto A1 = new Ponto(0., 0.);
        Ponto B1 = new Ponto(0., 17.);
        Ponto C1 = new Ponto(22., 0.);
        double distance11 = 5.;
        double distance22 = 14.56021;
        double distance33 = 18.24828;
        System.out.println(getLocationByTrilateration(A1, distance11, B1, distance22, C1, distance33));

        Vector2D p1 = new Vector2D(0, 0);
        Vector2D p2 = new Vector2D(0, 17);
        Vector2D p3 = new Vector2D(22, 0);

        System.out.println(getLocationByTrilateration3(p1, p2, p3, distance1, distance2, distance3));

    }

    public static Ponto getLocationByTrilateration(
            Ponto ponto1, double distance1,
            Ponto ponto2, double distance2,
            Ponto ponto3, double distance3) {

        //DECLARACAO DE VARIAVEIS
        Ponto retorno = new Ponto();
        double[] P1 = new double[2];
        double[] P2 = new double[2];
        double[] P3 = new double[2];
        double[] ex = new double[2];
        double[] ey = new double[2];
        double[] p3p1 = new double[2];
        double jval = 0;
        double temp = 0;
        double ival = 0;
        double p3p1i = 0;
        double triptx;
        double xval;
        double yval;
        double t1;
        double t2;
        double t3;
        double t;
        double exx;
        double d;
        double eyy;

        //TRANSFORMA OS PONTOS EM VETORES
        //PONTO 1
        P1[0] = ponto1.getX();
        P1[1] = ponto1.getY();
        //PONTO 2
        P2[0] = ponto2.getX();
        P2[1] = ponto2.getY();
        //PONTO 3
        P3[0] = ponto3.getX();
        P3[1] = ponto3.getY();

        //TRANSFORMA O VALOR DE METROS PARA A UNIDADE DO MAPA
        //DISTANCIA ENTRE O PONTO 1 E A MINHA LOCALIZACAO
        distance1 = (distance1 / 100000);
        //DISTANCIA ENTRE O PONTO 2 E A MINHA LOCALIZACAO
        distance2 = (distance2 / 100000);
        //DISTANCIA ENTRE O PONTO 3 E A MINHA LOCALIZACAO
        distance3 = (distance3 / 100000);

        for (int i = 0; i < P1.length; i++) {
            t1 = P2[i];
            t2 = P1[i];
            t = t1 - t2;
            temp += (t * t);
        }
        d = Math.sqrt(temp);
        for (int i = 0; i < P1.length; i++) {
            t1 = P2[i];
            t2 = P1[i];
            exx = (t1 - t2) / (Math.sqrt(temp));
            ex[i] = exx;
        }
        for (int i = 0; i < P3.length; i++) {
            t1 = P3[i];
            t2 = P1[i];
            t3 = t1 - t2;
            p3p1[i] = t3;
        }
        for (int i = 0; i < ex.length; i++) {
            t1 = ex[i];
            t2 = p3p1[i];
            ival += (t1 * t2);
        }
        for (int i = 0; i < P3.length; i++) {
            t1 = P3[i];
            t2 = P1[i];
            t3 = ex[i] * ival;
            t = t1 - t2 - t3;
            p3p1i += (t * t);
        }
        for (int i = 0; i < P3.length; i++) {
            t1 = P3[i];
            t2 = P1[i];
            t3 = ex[i] * ival;
            eyy = (t1 - t2 - t3) / Math.sqrt(p3p1i);
            ey[i] = eyy;
        }
        for (int i = 0; i < ey.length; i++) {
            t1 = ey[i];
            t2 = p3p1[i];
            jval += (t1 * t2);
        }

        xval = (Math.pow(distance1, 2) - Math.pow(distance2, 2) + Math.pow(d, 2)) / (2 * d);
        yval = ((Math.pow(distance1, 2) - Math.pow(distance3, 2) + Math.pow(ival, 2) + Math.pow(jval, 2)) / (2 * jval)) - ((ival / jval) * xval);

        t1 = ponto1.getX();
        t2 = ex[0] * xval;
        t3 = ey[0] * yval;
        triptx = t1 + t2 + t3;
        retorno.setX(triptx);
        t1 = ponto1.getY();
        t2 = ex[1] * xval;
        t3 = ey[1] * yval;
        triptx = t1 + t2 + t3;
        retorno.setY(triptx);

        return retorno;
    }

    public static Ponto getLocationByTrilateration2(
            Ponto ponto1, double distance1,
            Ponto ponto2, double distance2,
            Ponto ponto3, double distance3) {

        Ponto result = new Ponto();

        var Ex = (ponto2.getX() - ponto1.getX()) / Math.sqrt(Math.pow(ponto2.getX() - ponto1.getX(), 2) + Math.pow(ponto2.getY() - ponto1.getY(), 2));
        var i = Ex * (ponto3.getX() - ponto1.getX());

        var Ey = (ponto3.getX() - ponto1.getX() - i * Ex) / Math.sqrt(Math.pow(ponto3.getX() - ponto1.getX() - i * Ex, 2) + Math.pow(ponto3.getY() - ponto1.getY() - i * Ex, 2));

        var d = Math.sqrt(Math.pow(ponto2.getX() - ponto1.getX(), 2) + Math.pow(ponto2.getY() - ponto1.getY(), 2));

        var j = Ey * (ponto3.getX() - ponto1.getX());

        var x = (Math.pow(distance1, 2) - Math.pow(distance2, 2) + Math.pow(d, 2)) / 2 * d;
        var y = ((Math.pow(distance1, 2) - Math.pow(distance3, 2) + Math.pow(i, 2) + Math.pow(j, 2)) / (2 * j)) - (i * x / j);

        result.setX(x);
        result.setY(y);

        return result;
    }

    public static Ponto getLocationByTrilateration3(
            Vector2D ponto1,
            Vector2D ponto2,
            Vector2D ponto3,
            double distance1,
            double distance2,
            double distance3) {

//        double[] ex = normalize(difference(ponto2, ponto1));
//        double i = dotProduct(ex, difference(ponto3, ponto1));
//        double[] ey = normalize(difference(difference(ponto3, ponto1), scalarProduct(i, ex)));
//        double d = magnitude(difference(ponto2, ponto1));
//        double j = dotProduct(ey, difference(ponto3, ponto1));
//        double x = ((distance1*distance1) - (distance2*distance2) + (d*d)) / (2*d);
//        double y = (((distance1*distance1) - (distance3*distance3) + (i*i) + (j*j)) / (2*j)) - ((i*x) / j);
//        System.out.println(x + " " + y);

        return null;
    }

    public static Ponto getLocationByTrilateration3() {

        ArrayRealVector arrayRealVector = new ArrayRealVector(new double[]{1, -2}, false);
        ArrayRealVector arrayRealVector2 = new ArrayRealVector(new double[]{1, -7}, false);
        ArrayRealVector arrayRealVector1 = arrayRealVector.ebeMultiply(arrayRealVector2);

        RealMatrix matrix = new Array2DRowRealMatrix(new double[][] {
                {2, 3}
        }, false);
//        matrix.setRow(0, new double[]{2});
//        matrix.setRow(1, new double[]{5});
        RealMatrix matrix2 = new Array2DRowRealMatrix(new double[][] {
                {20, 5}
        }, false);
//        matrix2.setRow(0, new double[]{20});
//        matrix2.setRow(1, new double[]{5});
//        RealMatrix multiply = matrix.multiply(matrix2);
        RealMatrix multiply = matrix.subtract(matrix2);
        System.out.println(multiply);

//        double[][] positions = new double[][] { { 0.0, 0.0 }, { 0.0, 17.0 }, { 22.0, 0.0 } };
//        double[] distances = new double[] { 17.0, 17.49285, 10.63014 };

        double[][] positions = new double[][] { { 0.0, 0.0 }, { 0.0, 17.0 }, { 22.0, 0.0 } };
        double[] distances = new double[] { 5.0, 14.56021, 18.24828 };

        NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
        LeastSquaresOptimizer.Optimum optimum = solver.solve();

// the answer
        double[] calculatedPosition = optimum.getPoint().toArray();

// error and geometry information
        RealVector standardDeviation = optimum.getSigma(0);
        RealMatrix covarianceMatrix = optimum.getCovariances(0);

        return null;

    }

}
