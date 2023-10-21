package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class PowerUp {
    private Texture texture;
    private float duracion;
    private boolean isExpired;
    private Rectangle bounds;
    private float velocidad;

    public PowerUp(Texture texture, float duracion, float x, float y, float width, float height, float velocidad) {
        this.texture = texture;
        this.duracion = duracion;
        this.isExpired = false;
        this.bounds = new Rectangle(x, y, width, height);
        this.velocidad = velocidad;
    }

    // Método abstracto para aplicar el efecto del power-up
    public abstract void applyEffect(Tarro tarro);
    
    public abstract void revertEffect(Tarro tarro);

    public void update(float delta) {
        // Actualiza el power-up (posición, duración, etc.) en las subclases
        bounds.y -= velocidad * delta; // Actualiza la posición del power-up
        duracion -= delta;
        if (duracion <= 0) {
            isExpired = true;
        }
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void draw(SpriteBatch batch) {
        // Dibuja el power-up en la pantalla en las subclases
        batch.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public Rectangle getBounds() {
        return bounds;
    }
}

