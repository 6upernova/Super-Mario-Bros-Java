package entities.platforms;

import entities.PlatformsVisitor;

public interface Visited {
    public void acceptVisit(PlatformsVisitor visitor);

}
