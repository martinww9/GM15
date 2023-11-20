package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level3 implements Level {
	
    @Override
    public void applyLevelStrategy(Tarro tarro, float delta, SpriteBatch batch, Lluvia lluvia) {
        lluvia.desactivarZigZag();
        lluvia.activarGotasMortales();
        lluvia.setPorcentajeBueno(55);
        lluvia.setPorcentajeMalo(35);
        lluvia.setPorcentajeMortal(10);
    }

    @Override
    public int getPuntajeMinimo() {
        return 750;
    }

    @Override
    public Texture obtenerFondo() {
        // Obtener la textura del fondo para este nivel
        return new Texture(Gdx.files.internal("Level3BG.png"));
    }
    
	@Override
	public Level obtenerSiguienteNivel() {
		return null;
	}
}