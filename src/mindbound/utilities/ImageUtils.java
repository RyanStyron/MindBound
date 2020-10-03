package mindbound.utilities;

import javax.swing.ImageIcon;
import java.awt.Image;

public class ImageUtils {

    public static Image getMindBoundLogo() {
        return new ImageIcon("assets/textures/gui/mindbound.png").getImage();
    }

    public static Image getMindBoundIcon() {
        return new ImageIcon("assets/textures/gui/icon.png").getImage();
    }
}
