package com.mygdx.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ElementoJuego {
    void actualizar(Tarro tarro, SpriteBatch batch);
    void dibujar(SpriteBatch batch);
    void destruir();
}