package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota {
    private float x;
    private float y;
    private int tipo;
    private float width;
    private float height;
    private Texture textura;
    private Rectangle area; // Representa el área rectangular de la gota
    private boolean moverZigZag;


    public Gota(float x, float y, int tipo, float width, float height, Texture textura) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.width = width;
        this.height = height;
        this.textura = textura;
        this.area = new Rectangle(x, y, width, height);
        moverZigZag = false; // Inicialmente, la caída es normal

        
    }

    // Método Template Method que define el algoritmo general
    public final void caer(Tarro tarro, SpriteBatch batch, boolean zigZag) {
    	moverZigZag = zigZag;
    	 if (moverZigZag) {
             moverZigZag();
         } else {
        	 mover();
         }
    	
        actualizarEfectos(tarro);
        dibujar(batch);
    }
    
    public void alternarCaida() {
        moverZigZag = !moverZigZag; // Alternar entre caída normal y zigzag
    }
    

    

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract void moverZigZag( );
    public abstract void mover();
    public abstract void actualizarEfectos(Tarro tarro);
    public abstract void dibujar(SpriteBatch batch);

    // Métodos comunes a todas las gotas
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getTipo() {
        return tipo;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Texture getTextura() {
        return textura;
    }

    public Rectangle getArea() {
        return area;
    }

    public void setX(float x) {
        this.x = x;
        this.area.setX(x);
    }

    public void setY(float y) {
        this.y = y;
        this.area.setY(y);
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setWidth(float width) {
        this.width = width;
        this.area.setWidth(width);
    }

    public void setHeight(float height) {
        this.height = height;
        this.area.setHeight(height);
    }

    public void setTextura(Texture textura) {
        this.textura = textura;
    }
}
