package com.mcelrea.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private static final float MAX_X_SPEED = 2;
    private static final float MAX_Y_SPEED = 2;
    public static final int COLLISION_WIDTH = 35;
    public static final int COLLISION_HEIGHT = 50;
    private static final float MAX_JUMP_HEIGHT = COLLISION_HEIGHT*3;
    private Rectangle collisionRectangle;
    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float jumpYDistance = 0;
    private boolean jumpBlocked = false;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        collisionRectangle = new Rectangle(x,
                y,
                COLLISION_WIDTH,
                COLLISION_HEIGHT);
    }

    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;
        updateCollisionRectangle();
    }

    public void updateCollisionRectangle() {
        collisionRectangle.setPosition(x,y);
    }

    public void update() {
        Input input = Gdx.input;
        //left
        if(input.isKeyPressed(Input.Keys.D)) {
            xSpeed = MAX_X_SPEED;
        }
        //right
        else if(input.isKeyPressed(Input.Keys.A)) {
            xSpeed = -MAX_X_SPEED;
        }
        //no movement
        else {
            xSpeed = 0;
        }

        //if player jumps
        if(input.isKeyPressed(Input.Keys.W) && !jumpBlocked) {
            ySpeed = MAX_Y_SPEED;
            jumpYDistance += ySpeed;
            jumpBlocked = jumpYDistance > MAX_JUMP_HEIGHT;
        }
        else { //player not jumping (Gravity)
            ySpeed = -MAX_Y_SPEED;
            jumpBlocked = jumpYDistance > 0;
        }

        x += xSpeed;
        y += ySpeed;
        updateCollisionRectangle();
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(collisionRectangle.x,
                collisionRectangle.y,
                collisionRectangle.width,
                collisionRectangle.height);
    }

    public Rectangle getCollisionRectangle() {
        return collisionRectangle;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
