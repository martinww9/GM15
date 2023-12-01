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
    private boolean zigZagActivado;
    private int porcentajeBueno;
    private int porcentajeMalo;
    private int porcentajeMortal;
    private boolean gotasMortalesActivas;
	   
    public Lluvia(Sound ss, Music mm) {
        rainMusic = mm;
        dropSound = ss;
        juegoTerminado = false;
        gotas = new Array<Gota>();
        zigZagActivado = false;
        porcentajeBueno = 0;
        porcentajeMalo = 0;
        porcentajeMortal = 0;
        gotasMortalesActivas = false;
    }
	
    public void crear() {
        crearGotaDeLluvia();
        // Inicia la música de fondo
        rainMusic.setLooping(true);
        rainMusic.setVolume(0.0f);
        rainMusic.play();
    }
	

    private void crearGotaDeLluvia() {
    	Gota gota;

    	int randomValue = MathUtils.random(1, 100);

    	if (randomValue <= porcentajeBueno) {
    	    // Crear instancia de GotaBuena
    	     gota = new GotaBuena(0, 0, 1, 64, 64, null);
    	} else if (gotasMortalesActivas && randomValue > porcentajeBueno && randomValue <= (porcentajeBueno + porcentajeMortal)) {
    	    // Crear instancia de GotaMortal solo si el booleano GotasMortales está activo
    	     gota = new GotaMortal(0, 0, 3, 64, 64, null);
    	} else if (randomValue > (porcentajeBueno + porcentajeMortal) && randomValue <= (porcentajeBueno + porcentajeMortal + porcentajeMalo)) {
    	    // Crear instancia de GotaMala
    	     gota = new GotaMala(0, 0, 2, 64, 64, null);
    	} else {
            // Manejar el caso predeterminado, por ejemplo, creando una gota buena
    	    // Crear instancia de GotaBuena
    	     gota = new GotaBuena(0, 0, 1, 64, 64, null);
        }
    

        // Configurar posición inicial de la gota
        gota.setX(MathUtils.random(0, 800 - 64));
        gota.setY(480);
        
        // Otra configuración específica de Gota, si es necesaria

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
           gota.caer(tarro, batch, zigZagActivado);  // Usar el método caer definido en la clase Gota

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
	public void activarZigZag() {
	    zigZagActivado = true;
	}
	
	public void desactivarZigZag() {
	    zigZagActivado = false;
	}
	
	public int getPorcentajeBueno() {
		return porcentajeBueno;
	}
	
	public void setPorcentajeBueno(int porcentajeBueno) {
		this.porcentajeBueno = porcentajeBueno;
	}
	
	public void setPorcentajeMalo(int porcentajeMalo) {
		this.porcentajeMalo = porcentajeMalo;
	}
	
	public void setPorcentajeMortal (int porcentajeMortal) {
		this.porcentajeMortal = porcentajeMortal;
	}
	
	
	
	public void activarGotasMortales () {
		gotasMortalesActivas = true;
	}
	
	public void desactivarGotasMortales() {
		gotasMortalesActivas = false;
	}
   
}
