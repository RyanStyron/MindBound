package mindbound.object;

import java.awt.Graphics;

public abstract class GameObject {

    protected ObjectId objectId;
    protected int x, y;
    protected int velocityX, velocityY;

    public GameObject(ObjectId objectId, int x, int y) {
        this.objectId = objectId;
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }
}
