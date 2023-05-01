package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Ball {
    int x; // X position
    int y; // y position
    int size; // ball size
    int xSpeed; // ball x speed
    int ySpeed; // ball y speed
    Color color = Color.WHITE;


    public Ball(int x, int y, int size, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update(){
        x+=xSpeed;
        y += ySpeed;

        if(x<0 || x > Gdx.graphics.getWidth())
            xSpeed = -xSpeed;

        if(y<0 || y > Gdx.graphics.getHeight())
            ySpeed = -ySpeed;

    }

    public void draw(ShapeRenderer shape){
        shape.setColor(color);
        shape.circle(x,y,size);
    }

    public void checkCollision(Paddle paddle){
        if(collidesWith(paddle)){
            ySpeed = -ySpeed;
        }
    }

    public void checkCollision(Block block){
        if(collidesWith(block)){
            ySpeed = -ySpeed;
            block.destroyed = true;
        }
    }





    public boolean collidesWith(Paddle paddle){

        // Trouver le point le plus proche du centre du cercle dans le rectangle
        float closestX = MathUtils.clamp(x, paddle.x, paddle.x + paddle.width);
        float closestY = MathUtils.clamp(y, paddle.y, paddle.y + paddle.height);

        // Calculer la distance entre le point le plus proche et le centre du cercle
        float distanceX = x - closestX;
        float distanceY = y - closestY;
        float distanceSquared = distanceX * distanceX + distanceY * distanceY;

        // Vérifier si la distance est inférieure ou égale au rayon du cercle
        return distanceSquared <= size * size;


    }

    private boolean collidesWith(Block block){

        // Trouver le point le plus proche du centre du cercle dans le rectangle
        float closestX = MathUtils.clamp(x, block.x, block.x + block.width);
        float closestY = MathUtils.clamp(y, block.y, block.y + block.height);

        // Calculer la distance entre le point le plus proche et le centre du cercle
        float distanceX = x - closestX;
        float distanceY = y - closestY;
        float distanceSquared = distanceX * distanceX + distanceY * distanceY;

        // Vérifier si la distance est inférieure ou égale au rayon du cercle
        return distanceSquared <= size * size;


    }

}

