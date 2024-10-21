package factories;

public class BoundingBox extends java.awt.Rectangle {
	
	public BoundingBox (int x, int y, int width, int height){
		super(x,y,width,height);
	}
	
	public void updateBoundingBoxCoords(int positionInX, int positionInY) {
		this.setLocation(positionInX,positionInY);
	}
	/*
	public boolean upCollision () {
		
	}
	
	public boolean downCollision() {
		
	}
	
	public boolean rightCollision() {
		
	}
	
	public boolean leftCollision() {
		
	}
	*/
	public boolean collision (BoundingBox entityBox) {
		return this.intersects(entityBox);
	}
	
	public void setBoundingBoxX(float newX, float oldY) {
		this.setLocation((int)newX, (int)oldY);
	}
	
	public void setBoundingBoxY(float oldX, float newY) {
		this.setLocation((int)oldX, (int)newY);
	}
}
