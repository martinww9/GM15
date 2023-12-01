package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;

	public class ExtraLifePowerUp extends PowerUp {
	    public ExtraLifePowerUp(Texture texture, float duration, float x, float y, float width, float height, float velocidad) {
	        super(texture, duration, x, y, width, height, velocidad);
	    }
	


	@Override
    public void applyEffect(Tarro tarro) {
        tarro.setVidas(tarro.getVidas()+1);   // Agregar una vida extra al tarro
    }



	@Override
	public void revertEffect(Tarro tarro) {
		tarro.setVidas(tarro.getVidas());
	}
}
