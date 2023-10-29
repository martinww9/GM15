package com.mygdx.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class LevelManager {
    private Array<Level> niveles;
    private int nivelActual;
    private Music bgm;

    public LevelManager(Music mm) {
        niveles = new Array<Level>();
        niveles.add(new Level1());
        niveles.add(new Level2());
        bgm = mm;
        bgm.setVolume(0.1f);
        bgm.play();
        bgm.setLooping(false);

        // Se agregaran mas niveles a medida que necesitemos
    }

    public void actualizarNivel(int puntaje) {
        for (int i = niveles.size - 1; i >= 0; i--) {
            if (puntaje >= niveles.get(i).getPuntajeMinimo()) {
                nivelActual = i;
                break;
            }
        }
    }
    
    public void actualizar(float delta, Tarro tarro, SpriteBatch batch) {
        // Actualizar el nivel actual en función del puntaje
        actualizarNivel(tarro.getPuntos());

        // Obtener el nivel actual
        Level nivelActual = obtenerNivelActual();

        // Actualizar la música y el fondo del nivel
        //Music musicaActual = nivelActual.obtenerMusica();
        Texture fondoActual = nivelActual.obtenerFondo();
        //nivelActual.obtenerFondo();
        batch.draw(fondoActual,0,0, 800, 500, 1.0f, 1.0f, 0, 0);
            
    }
    
    public Level obtenerNivelActual() {
        return niveles.get(nivelActual);
    }
    
    public void pausar () {
    	bgm.pause();
    }
    
    public void resume () {
    	bgm.play();
    }
    
    
    
}

