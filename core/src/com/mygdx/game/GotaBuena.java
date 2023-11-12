package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GotaBuena extends Gota {
    public GotaBuena(float x, float y, int tipo, float width, float height, Texture texture) {
        super(x, y, tipo, width, height, texture); // Tipo 1 para gota buena
    }

    @Override
    protected void mover() {
        // Velocidad a la que la gota buena se desplaza hacia abajo
        float velocidadY = -200; // Ajusta la velocidad según tus necesidades

        // Calcular la nueva posición en el eje Y
        float newY = getY() + velocidadY * Gdx.graphics.getDeltaTime();

        // Actualizar la posición de la gota
        setY(newY);
    }


    @Override
    protected void actualizarEfectos(Tarro tarro) {
        // Verificar overlap con el tarro
        if (getArea().overlaps(tarro.getArea())) {
            // Añadir 10 puntos al tarro
            tarro.sumarPuntos(10);
        }
    }

	@Override
	protected void dibujar(SpriteBatch batch) {
		batch.draw(getTextura(), getX(), getY());
		
	}

}

