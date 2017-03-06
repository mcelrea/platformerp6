package com.mcelrea.platformer;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private static final int COLLISION_WIDTH = 35;
    private static final int COLLISION_HEIGHT = 50;
    private Rectangle collisionRectangle;
    private float x;
    private float y;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        collisionRectangle = new Rectangle(x,
                y,
                COLLISION_WIDTH,
                COLLISION_HEIGHT);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(collisionRectangle.x,
                collisionRectangle.y,
                collisionRectangle.width,
                collisionRectangle.height);
    }
}
