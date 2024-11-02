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

	public void reproduceSoundDeadth(String path) {
		game.reproduceLoopSound(path,0);
	}

	public boolean isRunning(){
		return game.isRunningSound();
	}

	public void loopMusicLevel(){
		game.startMusic();
	}
	
	public void stopSound() {
		game.stopSound();
	}

	public void stopSoundMusic() {
		game.stopMusic();
	}
}
