package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GotaMala extends Gota {
    public GotaMala(float x, float y, int tipo, float width, float height, Texture texture) {
        super(x, y, tipo, width, height, texture); // Tipo 2 para gota buena
    }

    @Override
    protected void mover() {
        // Velocidad a la que la gota buena se desplaza hacia abajo
        float velocidadY = -400; // Ajusta la velocidad según tus necesidades

        // Calcular la nueva posición en el eje Y
        float newY = getY() + velocidadY * Gdx.graphics.getDeltaTime();

        // Actualizar la posición de la gota
        setY(newY);
    }


    @Override
    protected void actualizarEfectos(Tarro tarro) {
        // Verificar overlap con el tarro
        if (getArea().overlaps(tarro.getArea())) {
            // Restar 1 vida al tarro
            tarro.setVidas(tarro.getVidas()-1);
        }
    }

	@Override
	protected void dibujar(SpriteBatch batch) {
		batch.draw(getTextura(), getX(), getY());
		
	}

}

