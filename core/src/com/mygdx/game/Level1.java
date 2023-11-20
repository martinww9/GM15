	package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level1 implements Level {
    @Override
    public void applyLevelStrategy(Tarro tarro, float delta, SpriteBatch batch, Lluvia lluvia) {
        lluvia.setPorcentajeBueno(85);
        lluvia.setPorcentajeMalo(15);
    }
    

    @Override
    public int getPuntajeMinimo() {
        return 250;
    }

    @Override
    public Texture obtenerFondo() {
        return new Texture(Gdx.files.internal("Level1BG.png"));
    }


	@Override
	public Level obtenerSiguienteNivel() {
		return new Level2();
	}
}
