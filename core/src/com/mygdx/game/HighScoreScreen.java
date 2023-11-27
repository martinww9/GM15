package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class HighScoreScreen implements Screen {
    private final GameLluviaMenu game;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private BitmapFont font;

    public HighScoreScreen(final GameLluviaMenu game) {
        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        // Dibujar fondo u otros elementos según sea necesario
        Texture fondoActual = new Texture(Gdx.files.internal("Level1BG.png"));
        batch.draw(fondoActual, 0, 0, 800, 500, 1.0f, 1.0f, 0, 0);
        font.draw(batch, "Top Scores:" , 300, 450);

        // Dibujar los high scores
        int y = 400; // Ajustar la posición vertical según sea necesario
        int i=1;
        for (HighScore highScore : CsvDataManager.getInstance().getHighScores()) {
        	if(i==11) break;
            font.draw(batch, "No."+ i+ ": " + highScore.getScore(), 300, y);
            y -= 40; // Ajustar el espaciado vertical según sea necesario
            i++;
        }

        batch.end();
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.H)){
            game.setScreen(new MainMenuScreen(game)); // Cambiar a la pantalla de menú principal al tocar
            dispose();
        }
    }

    // Otras implementaciones de métodos de la interfaz Screen

    @Override
    public void show() {
        // TODO: Implementar si es necesario
    }

    @Override
    public void resize(int width, int height) {
        // TODO: Implementar si es necesario
    }

    @Override
    public void pause() {
        // TODO: Implementar si es necesario
    }

    @Override
    public void resume() {
        // TODO: Implementar si es necesario
    }

    @Override
    public void hide() {
        // TODO: Implementar si es necesario
    }

    @Override
    public void dispose() {
        // TODO: Implementar si es necesario
    }
}