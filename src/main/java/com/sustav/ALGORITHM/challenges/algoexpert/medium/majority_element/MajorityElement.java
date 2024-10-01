package com.sustav.ALGORITHM.challenges.algoexpert.medium.majority_element;

public class MajorityElement {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 2, 2, 1, 2 };

    System.out.println(majorityElement(arr));
  }

  public static int majorityElement(int[] array) {
    int counter = 1;
    int majorityElement = array[0];

    for (int i = 1; i < array.length; i++) {
      if (array[i] != majorityElement) {
        counter--;
      } else {
        counter++;
      }
      if (counter == 0) {
        majorityElement = array[i];
        counter = 1;
      }
    }
    return majorityElement;
  }

  public static int majorityElement2(int[] array) {
    int counter = 1;
    int majorityElement = array[0];

    for (int i = 1; i < array.length; i++) {
      counter = array[i] == majorityElement ? counter + 1 : counter - 1;
      if (counter == 0) {
        majorityElement = array[i];
        counter = 1;
      }
    }
    return majorityElement;
  }
}
