package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia implements ElementoJuego {
    private Array<Gota> gotas;
    private long lastDropTime;
    private Sound dropSound;
    private Music rainMusic;
    private boolean juegoTerminado;
	   
    public Lluvia(Sound ss, Music mm) {
        rainMusic = mm;
        dropSound = ss;
        juegoTerminado = false;
        gotas = new Array<Gota>();
    }
	
    public void crear() {
        crearGotaDeLluvia();
        // Inicia la música de fondo
        rainMusic.setLooping(true);
        rainMusic.setVolume(0.0f);
        rainMusic.play();
    }
	
	/* private void crearGotaDeLluvia() {
	      Rectangle raindrop = new Rectangle();
	      raindrop.x = MathUtils.random(0, 800-64);
	      raindrop.y = 480;
	      raindrop.width = 64;
	      raindrop.height = 64;
	      rainDropsPos.add(raindrop);
	      // ver el tipo de gota
	      if (MathUtils.random(1,10)<7)	    	  
	         rainDropsType.add(1);
	      else 
	    	 rainDropsType.add(2);
	      lastDropTime = TimeUtils.nanoTime();
	   }	
	*/

    private void crearGotaDeLluvia() {
        Gota gota;

        int randomValue = MathUtils.random(1, 10);

        if (randomValue <= 7) {
            // Crear instancia de GotaBuena
        	Texture texturaBuena = new Texture(Gdx.files.internal("Tesoro.png"));
            gota = new GotaBuena(0, 0, 1, 64, 64, texturaBuena);
        } else {
            // Crear instancia de GotaMala
        	Texture texturaMala = new Texture(Gdx.files.internal("Bomba.png"));
            gota = new GotaMala(0,0,2,64,64,texturaMala);
        }

        // Configurar posición inicial de la gota
        gota.setX(MathUtils.random(0, 800 - 64));
        gota.setY(480);
        
        // Otra configuración específica de Gota, si es necesaria
        // gota.setOtraPropiedad(/* valor */);

        // Agregar la gota al array
        gotas.add(gota);

        // Actualizar el tiempo de la última gota creada
        lastDropTime = TimeUtils.nanoTime();
    }
   
   @Override
   public void destruir() {
      dropSound.dispose();
      rainMusic.dispose();
   }
   public void pausar() {
	  rainMusic.stop();
   }
   public void continuar() {
	  rainMusic.play();
   }
   @Override
   public void actualizar(Tarro tarro, SpriteBatch batch) {
       // Generar gotas de lluvia
       if (TimeUtils.nanoTime() - lastDropTime > 100000000) {
           crearGotaDeLluvia();
       }

       // Actualizar y eliminar gotas
       for (Gota gota : gotas) {
           gota.caer(tarro, batch);  // Usar el método caer definido en la clase Gota

           // Eliminar gotas que hayan caído al suelo o colisionado con el tarro
           if (gota.getY() + gota.getHeight() < 0 || gota.getArea().overlaps(tarro.getArea())) {
               gotas.removeValue(gota, true);
           }
       }
    // Verificar si las vidas del tarro son menores o iguales a cero
       if (tarro.getVidas() <= 0) {
           juegoTerminado = true;
       }
   }
	
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

@Override
public void dibujar(SpriteBatch batch) {
    // Dibujar cada gota
    for (Gota gota : gotas) {
        gota.dibujar(batch);
    }
}
   
}
