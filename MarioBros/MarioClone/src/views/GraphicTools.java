package views;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GraphicTools {

    //Screen position methods
    public static int getScreenPositionX(float worldX){
        return Math.round(worldX *  ViewConstants.CELL_SIZE);
    }

    public static int getScreenPositionY(float worldY){
        return Math.round(ViewConstants.PANEL_HEIGHT - (85 + worldY * ViewConstants.CELL_SIZE));
    }

    // Relative position methods
    public static int transformX(float x, JLabel observer){
        return (int) x * ViewConstants.CELL_SIZE ;
    }

    public static int transformY(float y , JLabel observer ){
        return (int) (ViewConstants.PANEL_HEIGHT - (85 + observer.getIcon().getIconHeight() + y * ViewConstants.CELL_SIZE))    ;
    }



    //Scaling methods

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
