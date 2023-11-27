package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class Tarro implements ElementoJuego {

	   
	   private int puntos = 0;
	   private boolean herido = false;
	   private int tiempoHeridoMax=50;
	   private int tiempoHerido;
	   private int defaultSpeed;
	   
	   private Sound sonidoHerido;
	   private Rectangle bucket;
	   private Texture bucketImage;
	   private int vidas;
	   private int velx;
	   private int vely;
	   private TipoTarro tipoTarro;
	   private boolean movimientoLibre;
	   
		public Tarro(Sound sonidoHerido, Rectangle bucket, Texture bucketImage, int vidas, int velx, int vely,
			TipoTarro tipoTarro, boolean movimientoLibre) {
			   this.bucketImage = bucketImage;
			   this.sonidoHerido = sonidoHerido;
			   this.vidas = vidas;
			   this.tipoTarro = tipoTarro;
			   this.bucket = bucket;
			   this.velx = velx;
			   this.vely = vely;
			   defaultSpeed = velx;
	}

		public TipoTarro getTipoTarro() {
		return tipoTarro;
		}

		public void setTipoTarro(TipoTarro tipoTarro) {
			this.tipoTarro = tipoTarro;
		}
	
	
		public boolean isMovimientoLibre() {
			return movimientoLibre;
		}
	
	
		public void setMovimientoLibre(boolean movimientoLibre) {
			this.movimientoLibre = movimientoLibre;
		}


		public void setVidas(int vidas) {
	        this.vidas = vidas;
	    }
	   
		public int getVidas() {
			return vidas;
		}
		
		public Rectangle getArea() {
			return bucket;
		}
		
		public void setArea(Rectangle bucket) {
			this.bucket = bucket;
		}
	
		public int getPuntos() {
			return puntos;
		}

		public void sumarPuntos(int pp) {
			puntos+=pp;
		}
		
	    public int getVelx() {
	    	return velx;
	    }
	    
	    public void setVelx (int velx) {
	    	this.velx = velx;
	    }
	    
	    public int getVely() {
		return vely;
	    }

		public void setVely(int vely) {
			this.vely = vely;
		}
	    
	    public void resetSpeed() {
	        velx = defaultSpeed;
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
		   if(Gdx.input.isKeyPressed(Input.Keys.S)) bucket.y -= vely * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.W)) bucket.y += vely * Gdx.graphics.getDeltaTime();
		   // que no se salga de los bordes izq y der
		   if(bucket.x < 0) bucket.x = 0;
		   if(bucket.x > 800 - 79) bucket.x = 800 - 79;
		   
		   if(bucket.y < 0) bucket.y = 0;
		   if(bucket.y > 500 - 79) bucket.y = 500 - 79;
		
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
