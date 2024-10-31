package entities.character;

import game.Game;

public class ObserverSound {
	
	protected Game game;
           
	public ObserverSound(Game manager) {
		game= manager;
	}
	
	public void reproduceSound(String path) {
		game.reproduceSound(path);
	}
	
	public void stopSound() {
		game.stopSound();
	}
}
