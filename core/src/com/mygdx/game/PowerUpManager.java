package com.mygdx.game;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class PowerUpManager {
    private Array<PowerUp> powerUps;
    private float tiempoUltimoSpawn; // Controla la generación de power-ups
    private float intervaloGeneracion = 1f; // Intervalo de generación

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
        int randomNumber = MathUtils.random(0, 1); // Número aleatorio entre 0 y 1
        int xInicial = MathUtils.random(0, 800 - 64); // Coordenada x aleatoria
        int yInicial = 480; // Coordenada y fija
        float anchoPowerUp = 64; // Ancho fijo
        float altoPowerUp = 64; // Alto fijo
        Texture texture = new Texture(Gdx.files.internal("optimization.png"));
        Texture texture2 = new Texture(Gdx.files.internal("hearts.png"));

        switch (randomNumber) {
            case 0:
            	powerUps.add(new SpeedPowerUp(
            			texture, // Texture para la apariencia del power-up
            		    2f, // Duración de 10 segundos
            		    xInicial, // Coordenada x inicial aleatoria
            		    yInicial, // Coordenada y fija
            		    anchoPowerUp, // Ancho fijo
            		    altoPowerUp, // Alto fijo
            		    400f // Velocidad del power-up
            		));
            	break;
            case 1:
            	powerUps.add(new ExtraLifePowerUp(
            			texture2, // Texture para la apariencia del power-up
            		    10f, // Duración de 10 segundos
            		    xInicial, // Coordenada x inicial aleatoria
            		    yInicial, // Coordenada y fija
            		    anchoPowerUp, // Ancho fijo
            		    altoPowerUp, // Alto fijo
            		    400f // Velocidad del power-up
            		));
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
