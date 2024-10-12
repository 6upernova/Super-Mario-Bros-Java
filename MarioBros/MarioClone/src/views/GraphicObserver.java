package views;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.LogicalEntity;

public abstract class GraphicObserver extends JLabel implements Observer {
    
    private LogicalEntity observedEntity;

    GraphicObserver( LogicalEntity observedEntity){
        super();
        this.observedEntity = observedEntity;

    }

    public void update(){
        updateSprite();
        updatePositionSize();

    }

    protected void updateSprite(){
        String path = observedEntity.getSprite().getImagePath();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(path));
        icon = scaleImage(icon.getIconWidth(),36    , icon);
        this.setIcon(icon);
    }

    protected void updatePositionSize(){
        int x = observedEntity.getX();
        int y = observedEntity.getY();
        int width = this.getIcon().getIconWidth();
        int height = this.getIcon().getIconHeight();
        this.setBounds(x, y, width, height);
    }

    //metodos temporales crear clase luego please

    private ImageIcon scaleImage(float origin, float destination, ImageIcon imageIcon){
        float scale = calculateScale(origin, destination);
        Image image = imageIcon.getImage();
        int width = Math.round(imageIcon.getIconWidth() * scale);
        int height = Math.round(imageIcon.getIconHeight() * scale);
        image = image.getScaledInstance(width,  height, ABORT);
        return new ImageIcon(image);
    }

    private float calculateScale(float origin, float destination){
        return destination / origin;
    }





}
