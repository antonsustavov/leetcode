package com.sustav.ALGORITHM.exception;

public class ExceptionMain {
    public static void main(String[] args) {
        try {
            System.out.println("A");
            throw new NullPointerException();
        } catch (RuntimeException ex) {
            System.out.println("B");
        } catch (Exception ex) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
    }
}
