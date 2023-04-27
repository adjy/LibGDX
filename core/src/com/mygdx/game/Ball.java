package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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
        if(collidesWith(paddle))
            color = Color.GREEN;
        else
            color = Color.WHITE;
    }

    public boolean verif(float point, float debut, float fin){
        for(float i = debut; i< fin; i++){
            if(i == point)
                return true;
        }
        return false;
    }

    public Double Distance(float x1, float x2, float y1, float y2){
        float X = x2 - x1;
        float Y = y2 - y1;
        return Math.sqrt(Math.pow(X,2) + Math.pow(Y, 2) );
    }
    private boolean collidesWith(Paddle paddle){

//        if(  !( ( paddle.x < (x-size) || (paddle.x + paddle.width) < (x-size) ) || (paddle.x > (x + size) || (paddle.x + paddle.width) > (x + size) ) || ( paddle.y < (y-size) && (paddle.y + paddle.height) < (y-size) ) || (paddle.y > (y + size) && (paddle.y + paddle.height) > (y + size))  ) ){
//            return true;
//        }
//        if( paddle.x >= (x - size) && paddle.x <= (x + size) && paddle.y >= (y - size) && paddle.y <= (y + size))
//            return true;
//        if( (paddle.x + paddle.width) >= (x - size) && (paddle.x + paddle.width) <= (x + size) && (paddle.y + paddle.height) >= (y - size) && (paddle.y + paddle.height) <= (y + size))
//            return true;
//        if( x >= (paddle.x) && x<= (paddle.x + paddle.width) && y >= (paddle.y) && y<= (paddle.y + paddle.height))
//            return true;
//        if( (x + size) >= (paddle.x) && (x + size) <= (paddle.x + paddle.width) && (y + size) >= (paddle.y ) && (y + size)<= (paddle.y + paddle.height))
//            return true;

//        if(paddle.x >= (x- size) && (paddle.x) <= (x + size)  )
//            return true;
//        if(verif(paddle.x, x-size, x+size) && verif(paddle.y, y-size, y+size))
//            return true;

//        if((x-size + paddle.x + paddle.width) > paddle.x && ( (x+size + paddle.x + paddle.width) < (paddle.x + paddle.width) ) )
//            return true;
//        return false;

        Double distance = Distance(x ,paddle.x + (paddle.width/2) , y, paddle.y + (paddle.height/2) );
//        if(distance <= (size + x) + paddle.x)
//            return true;





        if(x + size == paddle.x) {
            System.out.println("x + size : " + (x + size));
            System.out.println("paddle.x: " + paddle.x);
            System.out.println("distance " + distance);

            return true;
        }

//        distance = Distance(x-size/2, paddle.x + paddle.width/2, y -size/2, paddle.y + paddle.height/2 );
//        distance = Distance(paddle.x + paddle.width / 2 , x)
//        if(distance < (size/2) + (paddle.width/2))
//            return true;

        return false;


    }

}

