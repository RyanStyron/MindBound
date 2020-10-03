package mindbound.object;

import java.awt.Graphics;
import java.util.LinkedList;

public class ObjectHandler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject temporaryObject = object.get(i);

            temporaryObject.tick();
        }
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < object.size(); i++) {
            GameObject temporaryObject = object.get(i);

            temporaryObject.render(graphics);
        }
    }

    public void addGameObject(GameObject gameObject) {
        this.object.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        this.object.remove(gameObject);
    }
}
