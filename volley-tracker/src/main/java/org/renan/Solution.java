package org.renan;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of teams:");
        int numTeams = Integer.parseInt(scanner.nextLine().trim());
        String[] teamNames = new String[numTeams];

        for (int i = 0; i < numTeams; i++) {
            System.out.println("Enter team name " + (i + 1) + ":");
            teamNames[i] = scanner.nextLine().trim();
        }

        VolleyballGameTracker gameTracker = new VolleyballGameTracker(teamNames);

        System.out.println("Enter the number of matches:");
        int numMatches = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numMatches; i++) {
            System.out.println("Enter match info (team1 team2 score) like 'team1 team2 score'25:10");
            String matchInfo = scanner.nextLine().trim();
            String[] parts = matchInfo.split(" ");
            String team1 = parts[0];
            String team2 = parts[1];
            String score = parts[2];

            gameTracker.addMatch(team1, team2, score);
        }

        String topTeam = gameTracker.findFirst();
        System.out.println("The team with the highest score is:");
        System.out.println(topTeam);

    }
}
