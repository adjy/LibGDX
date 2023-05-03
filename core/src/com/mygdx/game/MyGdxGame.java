package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter{
    ShapeRenderer shape; // use to draw simple shapes
    Ball ball;
    Paddle paddle;
    Paddle sol;
    BitmapFont gameOver;
    SpriteBatch batch;




    ArrayList<Block> blocks = new ArrayList<>();
    ArrayList<Ball> balls = new ArrayList<>(); // create array balls
    Random r = new Random();


    @Override
    public void create(){ //runs once when the game starts.
        int blockWidth = 63;
        int blockHeight = 20;

        shape = new ShapeRenderer();
        ball = new Ball(150,200,10,5,5);
        paddle = new Paddle(10, 10, 70, 5);
        sol = new Paddle(0,0,Gdx.graphics.getWidth(), 1);
        batch = new SpriteBatch();



        // create all Blocks

        for(int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getWidth(); y += blockHeight + 10)
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10)
                blocks.add(new Block(x,y, blockWidth, blockHeight));

//        for(int i=0; i<10; i++) // create all balls
//            balls.add(new Ball(r.nextInt(Gdx.graphics.getWidth()), r.nextInt(Gdx.graphics.getHeight()), r.nextInt(100), r.nextInt(15), r.nextInt(15)));
    }

    @Override
    public void render(){ //runs every frame
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);

//        for(Ball ball: balls){ // update all balls
//            ball.update();
//            ball.draw(shape);
//        }

        for (Block block : blocks) {
            block.draw(shape);
            ball.checkCollision(block);
        }

        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            if (block.destroyed) {
                blocks.remove(block);
                i--;
            }
        }

//        if(!ball.collidesWith(sol)) {
            ball.update();
            ball.draw(shape);
            ball.checkCollision(paddle);

            paddle.update();
            paddle.draw(shape);
            sol.draw(shape);
//        }
//        else{
//            ball.draw(shape);
//            paddle.draw(shape);
//            batch.begin();
//
//            gameOver.draw(batch, "GAME OVER", Gdx.graphics.getWidth()/2, 40);
//            batch.end();
//
//        }


        shape.end();


    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}