package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class Level2 implements Level {
    @Override
    public int getPuntajeMinimo() {
        return 1000;
    }

    @Override
    public Texture obtenerFondo() {
        return new Texture(Gdx.files.internal("Level2BG.png"));
    }

}