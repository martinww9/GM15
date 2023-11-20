package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class Tarro implements ElementoJuego {
	   private Rectangle bucket;
	   private Texture bucketImage;
	   private Sound sonidoHerido;
	   private int vidas = 2;
	   private int puntos = 0;
	   private int velx = 400;
	   private boolean herido = false;
	   private int tiempoHeridoMax=50;
	   private int tiempoHerido;
	   private int defaultSpeed = 400;
	   
	   
	   public Tarro(Texture tex, Sound ss) {
		   bucketImage = tex;
		   sonidoHerido = ss;
	   }
	   
		public int getVidas() {
			return vidas;
		}
	
		public int getPuntos() {
			return puntos;
		}
		public Rectangle getArea() {
			return bucket;
		}
		public void sumarPuntos(int pp) {
			puntos+=pp;
		}
		
	    public void setVidas(int vidas) {
	        this.vidas = vidas;
	    }
	    
	    public int getVelx() {
	    	return velx;
	    }
	    
	    public void setVelx (int velx) {
	    	this.velx = velx;
	    }
	    
	    public void resetSpeed() {
	        velx = defaultSpeed;
	    }
	
	   public void crear() {
		      bucket = new Rectangle();
		      bucket.x = 800 / 2 - 79 / 2;
		      bucket.y = 20;
		      bucket.width = 79;
		      bucket.height = 79;
	   }
	   public void dañar() {
		  vidas--;
		  herido = true;
		  tiempoHerido=tiempoHeridoMax;
		  sonidoHerido.play();
	   }
 	   
	    
	
   public boolean estaHerido() {
	   return herido;
   }

	@Override
	public void actualizar(Tarro tarro, SpriteBatch batch) {
		   //movimiento desde teclado
		   if(Gdx.input.isKeyPressed(Input.Keys.A)) bucket.x -= velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.D)) bucket.x += velx * Gdx.graphics.getDeltaTime();
		   // que no se salga de los bordes izq y der
		   if(bucket.x < 0) bucket.x = 0;
		   if(bucket.x > 800 - 79) bucket.x = 800 - 79;
		
	}
	
	@Override
	public void dibujar (SpriteBatch batch) {
		 if (!herido)  
			   batch.draw(bucketImage, bucket.x, bucket.y);
			 else {
			   batch.draw(bucketImage, bucket.x, bucket.y+ MathUtils.random(-5,5));
			   tiempoHerido--;
			   if (tiempoHerido<=0) herido = false;
			 }
	}
	
	@Override
	public void destruir() {
		    bucketImage.dispose();
	   }
	
}
