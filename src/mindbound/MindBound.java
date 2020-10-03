package mindbound;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import mindbound.entity.Player;
import mindbound.graphics.GameWindow;
import mindbound.object.ObjectHandler;
import mindbound.object.ObjectId;
import mindbound.utilities.ImageUtils;

public class MindBound extends Canvas implements Runnable {

    private static final long serialVersionUID = -4942220373758113815L;

    private int windowWidth = 640;
    private int windowHeight = 400;

    private Thread thread;
    private boolean running = false;

    private ObjectHandler objectHandler = new ObjectHandler();

    public MindBound() {
        new GameWindow(this, ImageUtils.getMindBoundIcon(), windowWidth, windowHeight, "MindBound");

        objectHandler = new ObjectHandler();
        objectHandler.addGameObject(new Player(ObjectId.Player, 100, 100));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double tickCount = 60.0;
        double nanoSecond = 1000000000 / tickCount;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();

            delta += (now - lastTime) / nanoSecond;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        objectHandler.tick();
    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();

        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, windowWidth, windowHeight);

        objectHandler.render(graphics);

        graphics.dispose();
        bufferStrategy.show();
    }

    public static void main(String[] args) {
        new MindBound();
    }
}