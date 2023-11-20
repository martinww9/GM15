package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Level {
    void applyLevelStrategy(Tarro tarro, float delta, SpriteBatch batch, Lluvia lluvia);
    int getPuntajeMinimo();
    Texture obtenerFondo();
    Level obtenerSiguienteNivel();
}
