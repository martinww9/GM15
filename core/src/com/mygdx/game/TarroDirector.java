package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class TarroDirector {
	
	public void createDefaultTarro(Builder builder) {
		builder.setTipoTarro(TipoTarro.DEFAULT);
		
		Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("boatHit.wav"));
		
		builder.setSkin(new Texture(Gdx.files.internal("pirata79.png")));
		builder.setTamano(new Rectangle(800 / 2 - 79 / 2, 20, 79, 79)); //(float x, float y, float width, float height
		builder.setSound(hurtSound);
		builder.setVidas(3);
		builder.setVelocidadBase(400);
		builder.setMovimientoLibre(Boolean.FALSE);			
}
	public void createTankTarro(Builder builder) {
		builder.setTipoTarro(TipoTarro.TANK);
		
		Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("tankHit.mp3"));
		
		builder.setSkin(new Texture(Gdx.files.internal("tankSkin.png")));
		builder.setTamano(new Rectangle(800 / 2 - 79 / 2, 20, 123, 85)); //(float x, float y, float width, float height
		builder.setSound(hurtSound);
		builder.setVidas(10);
		builder.setVelocidadBase(200);
		builder.setMovimientoLibre(Boolean.FALSE);	
}
	public void createPlaneTarro(Builder builder) {
		builder.setTipoTarro(TipoTarro.PLANE);
		
		Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("planeHit.mp3"));
		
		builder.setSkin(new Texture(Gdx.files.internal("planeSkin.png")));
		builder.setTamano(new Rectangle(800 / 2 - 79 / 2, 20, 58, 58)); //(float x, float y, float width, float height
		builder.setSound(hurtSound);
		builder.setVidas(1);
		builder.setVelocidadBase(600);
		builder.setMovimientoLibre(Boolean.TRUE);	
		
}

	
}