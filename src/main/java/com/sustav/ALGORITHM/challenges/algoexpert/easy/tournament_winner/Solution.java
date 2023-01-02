package com.sustav.ALGORITHM.challenges.algoexpert.easy.tournament_winner;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>() {
            {
                add(new ArrayList<>() {{ add("HTML"); add("C#"); }});
                add(new ArrayList<>() {{ add("C#"); add("Python"); }});
                add(new ArrayList<>() {{ add("Python"); add("HTML"); }});
                add(new ArrayList<>() {{ add("HTML"); add("C#"); }});
                add(new ArrayList<>() {{ add("HTML"); add("C#"); }});
            }
        };

        ArrayList<Integer> results = new ArrayList<>() {
            {
                add(0);
                add(0);
                add(1);
                add(0);
                add(0);
            }
        };

        System.out.println(tournamentWinnerOnlogn(competitions, results));
        System.out.println(tournamentWinnerOn(competitions, results));
        System.out.println(tournamentWinnerOn2(competitions, results));

    }

    public static String tournamentWinnerOnlogn(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> result = new HashMap<>();

        for (int idx = 0; idx < results.size(); idx++) {
            ArrayList<String> competition = competitions.get(idx);
            String wonTeam = competition.get(results.get(idx) == 0 ? 1 : 0);
            result.put(wonTeam, result.getOrDefault(wonTeam, 0) + 3);
        }

//        System.out.println(result);

        Map<String, Integer> result2 = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

//        System.out.println(result2);

        return result2.keySet().stream().findFirst().orElse("");
    }

    public static String tournamentWinnerOn(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Integer winnerPoint = 0;
        String winnerTeam = "";
        Map<String, Integer> scoreTable = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            String wonTeam = competition.get(results.get(i) == 0 ? 1 : 0);
            scoreTable.put(wonTeam, scoreTable.getOrDefault(wonTeam, 0) + 3);
            Integer currentWinnerScore = scoreTable.get(wonTeam);
            if (currentWinnerScore > winnerPoint) {
                winnerPoint = currentWinnerScore;
                winnerTeam = wonTeam;
            }
        }

        return winnerTeam;
    }

    public static String tournamentWinnerOn2(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String winnerTeam = "";
        Map<String, Integer> scoreTable = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            String wonTeam = competition.get(results.get(i) == 0 ? 1 : 0);
            scoreTable.put(wonTeam, scoreTable.getOrDefault(wonTeam, 0) + 3);
            winnerTeam = scoreTable.get(wonTeam) > scoreTable.getOrDefault(winnerTeam, 0) ? wonTeam : winnerTeam;
        }

        return winnerTeam;
    }
}
