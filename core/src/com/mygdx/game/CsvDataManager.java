package com.mygdx.game;

import java.io.*;
import java.util.ArrayList;
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
            // Manejar la excepción apropiadamente en tu aplicación
        }

        return highScores;
    }

    public void guardarHighScoresEnCsv() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
            for (HighScore highScore : highScores) {
                writer.println(highScore);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente en tu aplicación
        }
    }
}
