package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public interface Builder {
	void setTipoTarro(TipoTarro tipo);
	void setVidas(int vidas);
	void setVelocidadBase(int vel);
	void setMovimientoLibre(boolean movimiento);
	void setTamano(Rectangle tamano);
	void setSkin (Texture textura);
	void setSound (Sound sound);
}
