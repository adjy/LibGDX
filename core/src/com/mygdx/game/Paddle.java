package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    float x; // X position
    float y; // y position
    float width;
    float height;
    public Paddle(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(){
        float screenHeight = Gdx.graphics.getHeight();
        float paddleY = screenHeight - Gdx.input.getY() - this.height/2; // Calculate paddle y position based on mouse position
//        y = paddleY;
        x = Gdx.input.getX() - (this.width/2); // this returns the x position of the cursor in pixels;
    }


    public void draw(ShapeRenderer shape){
        shape.rect(  this.x, this.y, this.width, this.height);
    }

}
