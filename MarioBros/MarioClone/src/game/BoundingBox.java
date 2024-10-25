package game;
import java.awt.Rectangle;

public class BoundingBox extends Rectangle {

    protected BoundingBox leftBound;
    protected BoundingBox rightBound;
    protected BoundingBox upperBound;
    protected BoundingBox downBound;

    public BoundingBox (int x, int y, int width, int height){
        super(x,y,width,height);
    }
    
    public void createExternalBounds(){
        upperBound = new BoundingBox(x+3, y, width-6, height / 4);
        downBound = new BoundingBox(x+3, y + height * 3 / 4, width-6, height / 4);
        leftBound = new BoundingBox(x, y+3, width / 4, height-6);
        rightBound = new BoundingBox(x + width * 3 / 4, y+3, width / 4, height-6);

    }
    
    public void updateBoundingBoxCoords(int newX, int newY) {
        this.setLocation(newX,newY);
        downBound.setLocation(newX+3, newY + height * 3 / 4);
        upperBound.setLocation(newX+3,newY);
        leftBound.setLocation(newX, newY + 3);
        rightBound.setLocation(newX + width * 3 / 4,newY + 3);

    }    

    public void setBoundingBoxX(float newX, float oldY) {
        this.setLocation((int)newX, (int)oldY);
    }

    public void setBoundingBoxY(float oldX, float newY) {
        this.setLocation((int)oldX, (int)newY);
    }

    public boolean collision (BoundingBox entityBox) {
        return this.intersects(entityBox);
    }

    public boolean rightCollision(BoundingBox externalBounding) {
        boolean colision = getBoundsRight().intersects(externalBounding);
        //System.out.println("Colision der: "+colision);
        return colision;
    }
    
    public boolean leftCollision(BoundingBox externalBounding) {
        boolean colision = getBoundsLeft().intersects(externalBounding);  
        return colision;
    }
    
    public boolean downCollision(BoundingBox externalBounding) {
        boolean downCollision = getBoundsBottom().intersects(externalBounding);
        return downCollision;
    }    

    public boolean upCollision(BoundingBox externalBounding) {
        boolean upCollision = getBoundsTop().intersects(externalBounding); 
        //System.out.println(upCollision);
        return upCollision;
    }
   
     // Sub-bounding boxes

    protected BoundingBox getBoundsTop() {
        return upperBound;
    }

    protected BoundingBox getBoundsBottom() {
        return downBound;
    }

    protected BoundingBox getBoundsLeft() {
        return leftBound;
    }

    protected BoundingBox getBoundsRight() {
        return rightBound;
    }
    


}