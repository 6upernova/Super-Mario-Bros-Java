package entities;
import entities.platforms.*;

public interface PlatformsVisitor {
	
	public void visit(Platform platform);

}