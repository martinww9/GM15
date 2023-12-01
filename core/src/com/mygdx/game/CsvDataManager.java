	package com.mygdx.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CsvDataManager {
    private static final String CSV_FILE_PATH = "highscores.csv";
    private static final CsvDataManager instance = new CsvDataManager();
    private List<HighScore> highScores;

    private CsvDataManager() {
        highScores = cargarHighScoresDesdeCsv();
    }

    public static CsvDataManager getInstance() {
        return instance;
    }

    public List<HighScore> getHighScores() {
        return highScores;
    }

    private List<HighScore> cargarHighScoresDesdeCsv() {
        List<HighScore> highScores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    highScores.add(new HighScore(playerName, score));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        
        Collections.sort(highScores, new Comparator<HighScore>() {
            @Override
            public int compare(HighScore hs1, HighScore hs2) {
                return Integer.compare(hs2.getScore(), hs1.getScore());
            }
        });

        return highScores;
    }

    public void guardarHighScoresEnCsv() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
            for (HighScore highScore : highScores) {
                writer.println(highScore);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
