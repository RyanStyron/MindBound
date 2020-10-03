package mindbound.entity;

import java.awt.Color;
import java.awt.Graphics;

import mindbound.object.GameObject;
import mindbound.object.ObjectId;

public class Player extends GameObject {

    public Player(ObjectId objectId, int x, int y) {
        super(objectId, x, y);

        velocityX = 1;
        velocityY = 0;
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(x, y, 32, 32);
    }
}
