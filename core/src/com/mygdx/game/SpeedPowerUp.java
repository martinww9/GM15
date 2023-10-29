package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class SpeedPowerUp extends PowerUp {
    public SpeedPowerUp(Texture texture, float duration, float x, float y, float width, float height, float velocidad) {
        super(texture, duration, x, y, width, height, velocidad);
    }

    @Override
    public void applyEffect(Tarro tarro) {
    	tarro.resetSpeed();
        // Implementa el efecto del power-up de velocidad directamente
        tarro.setVelx(tarro.getVelx() * 2); // Por ejemplo, duplicar la velocidad del tarro
    }

	@Override
	public void revertEffect(Tarro tarro) {
		tarro.resetSpeed();
		
	}
}
