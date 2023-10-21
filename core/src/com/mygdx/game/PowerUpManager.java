package com.mygdx.game;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class PowerUpManager {
    private Array<PowerUp> powerUps;
    private float tiempoUltimoSpawn; // Controla la generación de power-ups
    private float intervaloGeneracion = 5f; // Intervalo de generación

    public PowerUpManager() {
        powerUps = new Array<PowerUp>();
        tiempoUltimoSpawn = 0f;
    }

    public void update(float delta, Tarro tarro) {
        // Actualiza el tiempo transcurrido desde el último power-up
    	tiempoUltimoSpawn += delta;

        // Genera un nuevo power-up si ha pasado suficiente tiempo
        if (tiempoUltimoSpawn >= intervaloGeneracion) {
            generarPowerUpAleatorio();
            tiempoUltimoSpawn = 0; // Reinicia el contador
        }

        // Actualiza la posición y duración de los power-ups
        for (PowerUp powerUp : powerUps) {
            powerUp.update(delta);
            // Elimina power-ups caducados
            if (powerUp.isExpired()) {
                powerUps.removeValue(powerUp, true);
                powerUp.revertEffect(tarro);
            }
        }
    }
    


    public void generarPowerUpAleatorio() {
        int randomNumber = MathUtils.random(0, 1); // Número aleatorio entre 0 y 2 (o el número de tipos de power-ups que tengas)
        int xInicial = MathUtils.random(0, 800 - 64); // Coordenada x aleatoria
        int yInicial = 480; // Coordenada y fija
        float anchoPowerUp = 64; // Ancho fijo
        float altoPowerUp = 64; // Alto fijo


        switch (1) {
            case 0:
            	//power up 1
            	break;
            case 1:
            // power up 2
            	break;
        }
    }


    public void comprobarColisiones(Tarro tarro) {
        // Comprueba las colisiones entre el tarro y los power-ups
        for (PowerUp powerUp : powerUps) {
            if (tarro.getArea().overlaps(powerUp.getBounds())) {
                powerUp.applyEffect(tarro);
                powerUps.removeValue(powerUp, true);
            }
        }
    }

    public void draw(SpriteBatch batch) {
        // Dibuja los power-ups en la pantalla
        for (PowerUp powerUp : powerUps) {
            powerUp.draw(batch);
        }
    }
}
