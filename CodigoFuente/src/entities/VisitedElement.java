package entities;

import entities.character.CharacterVisitor;

public interface VisitedElement {
	
	public void acceptVisit(CharacterVisitor visitor);

}