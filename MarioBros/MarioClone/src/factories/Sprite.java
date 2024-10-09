package factories;

public class Sprite {
	
	protected String imageRoute;
	
	public Sprite (String imageRoute) {
		this.imageRoute=imageRoute;
	}
	public String getSkin() {
		return imageRoute;
	}
}
