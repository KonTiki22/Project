package com.maker.housemaker.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameObject {

    public float x;
    public float y;
    public float z;

    public float width;
    public float height;
    public String name;

    Rectangle bounds;
    Sprite object;


    public GameObject(String textureName, String name, float x, float y, float width, float height) {
        bounds = new Rectangle(x, y, width, height);
        object = new Sprite(new Texture(textureName));
        this.x = x;
        this.y = y;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public void draw(SpriteBatch batch){
        object.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        object.draw(batch);
    }

}
