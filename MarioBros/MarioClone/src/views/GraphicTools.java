package views;

import java.awt.Image;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GraphicTools {

    
    public static int transformX(int x, JLabel observer){
        return x;
    }

    public static int transformY(int y , JLabel observer ){
        return ViewConstants.PANEL_HEIGHT - observer.getIcon().getIconHeight() -y   ;
    }

    public static ImageIcon scaleImage(float origin, float destination, ImageIcon imageIcon){
        float scale = calculateScale(origin, destination);
        Image image = imageIcon.getImage();
        int width = Math.round(imageIcon.getIconWidth() * scale);
        int height = Math.round(imageIcon.getIconHeight() * scale);
        image = image.getScaledInstance(width,  height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private static float calculateScale(float origin, float destination){
        return destination / origin;
    }
    
}
