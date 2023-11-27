package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class TarroBuilder implements Builder {
	   private Sound sonidoHerido;
	   private Rectangle bucket;
	   private Texture bucketImage;
	   private int vidas;
	   private int velx;
	   private int vely;
	   private TipoTarro tipoTarro;
	   private boolean movimientoLibre;
	   
	@Override
	public void setTipoTarro(TipoTarro tipo) {
		this.tipoTarro = tipo;
		
	}
	@Override
	public void setVidas(int vidas) {
		this.vidas = vidas;
		
	}
	@Override
	public void setVelocidadBase(int vel) {
		this.velx = vel;
		
	}
	@Override
	public void setMovimientoLibre(boolean movimiento) {
		this.movimientoLibre = movimiento;
		if(this.movimientoLibre) {
			vely = velx;
		}
			
		
	}
	@Override
	public void setTamano(Rectangle tamano) {
		this.bucket = tamano;
		
	}
	@Override
	public void setSkin(Texture textura) {
		this.bucketImage = textura;
		
	}
	@Override
	public void setSound(Sound sound) {
		this.sonidoHerido = sound;
		
	}
	
	public Tarro getTarro() {
		return new Tarro(sonidoHerido, bucket, bucketImage, vidas, velx , vely, tipoTarro, movimientoLibre);
	}
}
