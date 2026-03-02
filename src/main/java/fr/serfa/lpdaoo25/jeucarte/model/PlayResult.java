package fr.serfa.lpdaoo25.jeucarte.model;


import java.util.HashMap;
import java.util.Map;

public record PlayResult(PlayStatus playStatus, Card newHand) {

    public enum PlayStatus {
        OK("OK", 30),
        ERROR("ERROR",-10),
        ERROR_OBVIOUS("ERROR_OBVIOUS", -20),
        CHEAT("CHEAT", -50),
        GAME_OVER("GAME_OVER", 0);

        private String name;
        private int scoreValue;

        PlayStatus(String name, int scoreValue) {
            this.name = name;
            this.scoreValue = scoreValue;
        }

        public String getName() {
            return name;
        }

        public int getScoreValue() {
            return scoreValue;
        }

        public Map<String, Object> serialize() {
            Map<String, Object> map = new HashMap<>();
            map.put("name", name);
            map.put("scoreValue", scoreValue);
            return map;
        }


    }
}
