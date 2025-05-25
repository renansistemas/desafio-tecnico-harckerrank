package org.renan;

import java.util.HashMap;
import java.util.Map;

interface GameTracker {
    void addMatch(String team1, String team2, String score);
    String findFirst();
}

public class VolleyballGameTracker implements GameTracker {

    private Map<String, Integer> teamScores;

    public VolleyballGameTracker(String[] teamNames) {
        teamScores = new HashMap<>();
        for (String name : teamNames) {
            teamScores.put(name, 0);
        }
    }


    @Override
    public void addMatch(String team1, String team2, String score) {
        String[] parts = score.split(":");
        int score1 = Integer.parseInt(parts[0]);
        int score2 = Integer.parseInt(parts[1]);

        teamScores.put(team1, teamScores.get(team1) + score1);
        teamScores.put(team2, teamScores.get(team2) + score2);

    }

    @Override
    public String findFirst() {
        String topTeam = null;
        int maxScore = -1;

        for(Map.Entry<String, Integer> entry : teamScores.entrySet()) {
            String team = entry.getKey();
            int score = entry.getValue();

            if(score > maxScore) {
                maxScore = score;
                topTeam = team;
            }
        }
        return topTeam;
    }
}
