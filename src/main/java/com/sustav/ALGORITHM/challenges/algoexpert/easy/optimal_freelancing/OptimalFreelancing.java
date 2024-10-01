package com.sustav.ALGORITHM.challenges.algoexpert.easy.optimal_freelancing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class OptimalFreelancing {
  private static final int WEEK = 7;

  public static void main(String[] args) {
    Map<String, Integer>[] jobs = new Map[7];

    jobs[0] = new HashMap<>();
    jobs[0].put("deadline", 2);
    jobs[0].put("payment", 1);

    jobs[1] = new HashMap<>();
    jobs[1].put("deadline", 2);
    jobs[1].put("payment", 2);

    jobs[2] = new HashMap<>();
    jobs[2].put("deadline", 2);
    jobs[2].put("payment", 3);

    jobs[3] = new HashMap<>();
    jobs[3].put("deadline", 2);
    jobs[3].put("payment", 4);

    jobs[4] = new HashMap<>();
    jobs[4].put("deadline", 2);
    jobs[4].put("payment", 5);

    jobs[5] = new HashMap<>();
    jobs[5].put("deadline", 2);
    jobs[5].put("payment", 6);

    jobs[6] = new HashMap<>();
    jobs[6].put("deadline", 2);
    jobs[6].put("payment", 7);

    System.out.println(optimalFreelancing(jobs));
  }

  public static int optimalFreelancing(Map<String, Integer>[] jobs) {
    int[] result = new int[WEEK];
    Arrays.sort(jobs, Comparator.comparing((Map<String, Integer> job) -> job.get("payment")).reversed());
    System.out.println(Arrays.toString(jobs));

    for (Map<String, Integer> job : jobs) {
      for (int i = job.get("deadline") - 1; i >= 0; i--) {
        if (i < WEEK && result[i] == 0) {
          result[i] = job.get("payment");
          break;
        }
      }
    }

    return Arrays.stream(result).sum();
  }

  public static int optimalFreelancing2(Map<String, Integer>[] jobs) {
    int[] result = new int[7];
    int profit = 0;
    Arrays.sort(jobs, Comparator.comparing((Map<String, Integer> job) -> job.get("payment")).reversed());

    for (Map<String, Integer> job : jobs) {
      int maxTime = Math.min(job.get("deadline") - 1, 6);
      for (int i = maxTime; i >= 0; i--) {
        if (result[i] == 0) {
          result[i] = job.get("payment");
          profit += result[i];
          break;
        }
      }
    }

    return profit;
  }
}