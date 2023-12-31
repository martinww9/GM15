package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class GotaMala extends Gota {
	private float tiempoZigZag;
	private float velocidadX;
	private float velocidadY;
	private static Texture texturaMala;  // Variable de clase para almacenar la textura
    public GotaMala(float x, float y, int tipo, float width, float height, Texture texture) {
        super(x, y, tipo, width, height, texture); // Tipo 2 para gota buena
        tiempoZigZag = 0; // Inicializar el tiempo de zigzag
        velocidadX = 400;
        velocidadY = 400;
        texturaMala = new Texture(Gdx.files.internal("Bomba.png"));
    }

    @Override
    public void mover() {
        // Velocidad a la que la gota buena se desplaza hacia abajo
        float velocidadY = -400; // Ajusta la velocidad según tus necesidades

        // Calcular la nueva posición en el eje Y
        float newY = getY() + velocidadY * Gdx.graphics.getDeltaTime();

        // Actualizar la posición de la gota
        setY(newY);
    }
    
    @Override
    public void moverZigZag() {
        // Calcular nueva posición en el eje X usando una función sinusoidal para el zigzag
        float newX = getX() + velocidadX * Gdx.graphics.getDeltaTime() * MathUtils.sin(tiempoZigZag);
        
        // Calcular nueva posición en el eje Y
        float newY = getY() - velocidadY * Gdx.graphics.getDeltaTime();
        
        tiempoZigZag += Gdx.graphics.getDeltaTime();

        // Verificar y ajustar si se alcanzan los límites de la pantalla
        if (newX < 0) {
            // Si se sale por el lado izquierdo, rebota ajustando la posición
            newX = 0;
            velocidadX = -velocidadX; // Invertir la dirección
        } else if (newX + getWidth() > 800) {
            // Si se sale por el lado derecho, rebota ajustando la posición
            newX = 800 - getWidth();
            velocidadX = -velocidadX; // Invertir la dirección
        }

        // Actualizar la posición de la gota
        setX(newX);
        setY(newY);
    }


    @Override
    public void actualizarEfectos(Tarro tarro) {
        // Verificar overlap con el tarro
        if (getArea().overlaps(tarro.getArea())) {
            // Restar 1 vida al tarro
            tarro.dañar();
        }
    }

	@Override
	public void dibujar(SpriteBatch batch) {
		batch.draw(texturaMala, getX(), getY());
		
	}

}

