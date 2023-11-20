package com.mygdx.game;


import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class LevelManager {
    //private Array<Level> niveles;
	private Level nivelActual;
    private Music bgm;

    public LevelManager(Music mm) {
    	nivelActual = new Level1();
        bgm = mm;
        bgm.setVolume(0.1f);
        bgm.play();
        bgm.setLooping(true);

    }
    
    public void actualizar(float delta, Tarro tarro, SpriteBatch batch, Lluvia lluvia) {
        // Actualizar el nivel actual en función del puntaje
        int puntajeActual = obtenerPuntajeActual(tarro);
        if (puntajeActual >= nivelActual.getPuntajeMinimo()) {
            // Cambiar al siguiente nivel
            cambiarAlSiguienteNivel();
        }

        // Aplicar la estrategia del nivel actual
        nivelActual.applyLevelStrategy(tarro, delta, batch, lluvia);

        // Actualizar el fondo del nivel
        Texture fondoActual = nivelActual.obtenerFondo();
        batch.draw(fondoActual, 0, 0, 800, 500, 1.0f, 1.0f, 0, 0);
    }
    
    private void cambiarAlSiguienteNivel() {
        // Obtener el siguiente nivel
        Level siguienteNivel = nivelActual.obtenerSiguienteNivel();

        // Verificar que haya un siguiente nivel
        if (siguienteNivel != null) {
            // Cambiar al siguiente nivel
            setNivelActual(siguienteNivel);
        }
    }
    
    public void setNivelActual(Level nuevoNivel) {
        this.nivelActual = nuevoNivel;
    }
    
    public Level obtenerNivelActual() {
        return this.nivelActual;
    }
    
    public int obtenerPuntajeActual(Tarro tarro) {
        return tarro.getPuntos();       
    }
    
    public void pausar () {
    	bgm.pause();
    }
    
    public void resume () {
    	bgm.play();
    }
    
    
    
}

