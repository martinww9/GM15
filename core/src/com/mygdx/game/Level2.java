package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level2 implements Level {
	
    @Override
    public void applyLevelStrategy(Tarro tarro, float delta, SpriteBatch batch, Lluvia lluvia) {
        lluvia.activarZigZag();
        lluvia.setPorcentajeBueno(70);
        lluvia.setPorcentajeMalo(30);
    }

    @Override
    public int getPuntajeMinimo() {
        return 500;
    }

    @Override
    public Texture obtenerFondo() {
        // Obtener la textura del fondo para este nivel
        return new Texture(Gdx.files.internal("Level2BG.png"));
    }
    
	@Override
	public Level obtenerSiguienteNivel() {
		return new Level3();
	}
}