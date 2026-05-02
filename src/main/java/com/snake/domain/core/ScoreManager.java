package com.snake.domain.core;

import java.io.*;
import java.util.*;

public class ScoreManager {
    private final List<Integer> highScores = new ArrayList<>();
    private static final String SCORE_FILE = System.getProperty("user.home") + File.separator + ".eves_apple_scores.txt";

    public void loadHighScores() {
        this.highScores.clear();
        File file = new File(SCORE_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    this.highScores.add(Integer.parseInt(line.trim()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (this.highScores.size() < 10) {
            this.highScores.add(0);
        }
        this.highScores.sort(Collections.reverseOrder());
    }

    public void saveHighScores() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SCORE_FILE))) {
            for (int score : this.highScores) {
                writer.println(score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isNewRecord(int score) {
        if (score <= 0) return false;
        if (this.highScores.isEmpty()) return true;
        return score > this.highScores.get(0);
    }

    public void updateHighScores(int newScore) {
        this.highScores.add(newScore);
        this.highScores.sort(Collections.reverseOrder());
        while (this.highScores.size() > 10) {
            this.highScores.remove(this.highScores.size() - 1);
        }
        this.saveHighScores();
    }

    public List<Integer> getHighScores() {
        return Collections.unmodifiableList(highScores);
    }
}
