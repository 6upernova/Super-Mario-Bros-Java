package entities.platforms;

import entities.PlatformsVisitor;

public interface VisitedPlatform {
    public void acceptVisit(PlatformsVisitor visitor);
}
