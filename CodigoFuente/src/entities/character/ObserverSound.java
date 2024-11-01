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

	public void loopSound(String path, int iteracions){
		game.reproduceLoopSound(path, iteracions);
	}
	
	public void stopSound() {
		game.stopSound();
	}
}
