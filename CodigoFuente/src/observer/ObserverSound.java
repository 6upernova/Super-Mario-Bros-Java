package observer;

import game.Game;

public class ObserverSound {
	
	protected Game game;
           
	public ObserverSound(Game manager) {
		game= manager;
	}
	
	public void reproduceSound(String path) {
		game.reproduceSound(path);
	}

	public void reproduceSoundOneIteration(String path) {
		game.reproduceLoopSound(path,0);
	}

	public boolean isRunning(){
		return game.isRunningSound();
	}

	public void loopMusicLevel(){
		game.startMusicLevel();
	}
	
	public void stopSound() {
		game.stopSound();
	}

}
